package com.umarbariev.projects.hotel_service.service.client;

import com.umarbariev.projects.hotel_service.dto.client.ClientDto;
import com.umarbariev.projects.hotel_service.dto.client.InfoForNextLoyalStatusDto;
import com.umarbariev.projects.hotel_service.dto.client.UserClientDto;
import com.umarbariev.projects.hotel_service.entities.client.Client;
import com.umarbariev.projects.hotel_service.repositories.client.ClientRepository;
import com.umarbariev.projects.hotel_service.service.order.OrderService;
import com.umarbariev.projects.hotel_service.service.user.UserService;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private LoyaltyStatusService loyaltyStatusService;

    public ClientDto addNewClient(UserClientDto userClientDto) {
        var userDto = userClientDto.getUserDto();
        if (!userService.saveUser(userDto)) {
            throw new RuntimeException("Error adding new client: user not saved.");
        }
        var clientDto = userClientDto.getClientDto();
        var client = BasicConverter.convert(clientDto, Client.class);
        var clientSaved = clientRepository.save(client);
        return BasicConverter.convert(clientSaved, ClientDto.class);
    }

    public ClientDto findClientByUsername(String username) {
        var client = clientRepository.findByUserUsername(username).orElse(null);
        return BasicConverter.convert(client, ClientDto.class);
    }

    public Client getById(int clientId) {
        return clientRepository.getById(clientId);
    }

    public InfoForNextLoyalStatusDto getInfoUntilNextLoyaltyStatus(ClientDto clientDto) {
        var infoForNextLoyalStatus = new InfoForNextLoyalStatusDto();
        var currentStatus = clientDto.getLoyaltyStatusDto();
        infoForNextLoyalStatus.setClient(clientDto);
        infoForNextLoyalStatus.setCurrent(currentStatus);
        if (currentStatus.getId() == 5) return infoForNextLoyalStatus;
        var ordersCount = orderService.getOrdersCountForClient(clientDto);
        var nextLoyaltyStatus = loyaltyStatusService.getLoyaltyStatusById(currentStatus.getId() + 1);
        infoForNextLoyalStatus.setCurrentOrdersCount(ordersCount);
        infoForNextLoyalStatus.setNext(nextLoyaltyStatus);
        infoForNextLoyalStatus.setOrdersForNextStatus(nextLoyaltyStatus.getOrdersCount() - ordersCount);
        return infoForNextLoyalStatus;
    }

    public ClientDto saveClient(ClientDto clientDto) {
        var client = BasicConverter.convert(clientDto, Client.class);
        var clientSaved = clientRepository.save(client);
        return BasicConverter.convert(clientSaved, ClientDto.class);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
