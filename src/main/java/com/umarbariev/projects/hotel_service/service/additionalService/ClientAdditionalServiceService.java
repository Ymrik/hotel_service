package com.umarbariev.projects.hotel_service.service.additionalService;

import com.umarbariev.projects.hotel_service.dto.additionalService.AdditionalServiceDto;
import com.umarbariev.projects.hotel_service.dto.additionalService.ClientAdditionalServiceDto;
import com.umarbariev.projects.hotel_service.dto.client.ClientDto;
import com.umarbariev.projects.hotel_service.entities.additionalService.ClientAdditionalService;
import com.umarbariev.projects.hotel_service.repositories.additionalService.ClientAdditionalServiceRepository;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientAdditionalServiceService {
    @Autowired
    private ClientAdditionalServiceRepository clientAdditionalServiceRepository;

    public ClientAdditionalServiceDto buyService(ClientAdditionalServiceDto clientServiceDto) {
        var clientService = BasicConverter.convert(clientServiceDto, ClientAdditionalService.class);
        var clientServiceSaved = clientAdditionalServiceRepository.save(clientService);
        return BasicConverter.convert(clientServiceSaved, ClientAdditionalServiceDto.class);
    }

    public ClientAdditionalServiceDto create(ClientDto client, AdditionalServiceDto service) {
        var cost = service.getBasePrice();
        if (client.getLoyaltyStatusDto() != null) {
            cost = cost * (1 - client.getLoyaltyStatusDto().getDiscount() / 100);
        }
        return ClientAdditionalServiceDto
                .builder()
                .client(client)
                .additionalService(service)
                .cost(cost)
                .build();
    }

    public List<ClientAdditionalServiceDto> getAllByClientId(int clientId) {
        return clientAdditionalServiceRepository.findAllByClientId(clientId)
                .stream()
                .map(x -> BasicConverter.convert(x, ClientAdditionalServiceDto.class))
                .collect(Collectors.toList());
    }

    public List<ClientAdditionalServiceDto> getAllByClient(ClientDto clientDto) {
        return getAllByClientId(clientDto.getId());
    }
}
