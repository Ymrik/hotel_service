package com.umarbariev.projects.hotel_service.service.client;

import com.umarbariev.projects.hotel_service.dto.client.ClientDto;
import com.umarbariev.projects.hotel_service.dto.client.UserClientDto;
import com.umarbariev.projects.hotel_service.entities.User;
import com.umarbariev.projects.hotel_service.entities.client.Client;
import com.umarbariev.projects.hotel_service.repositories.client.ClientRepository;
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
}
