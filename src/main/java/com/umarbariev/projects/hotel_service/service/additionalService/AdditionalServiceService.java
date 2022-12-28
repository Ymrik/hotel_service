package com.umarbariev.projects.hotel_service.service.additionalService;

import com.umarbariev.projects.hotel_service.dto.additionalService.AdditionalServiceDto;
import com.umarbariev.projects.hotel_service.dto.additionalService.ClientAdditionalServiceDto;
import com.umarbariev.projects.hotel_service.entities.additionalService.ClientAdditionalService;
import com.umarbariev.projects.hotel_service.repositories.additionalService.AdditionalServiceRepository;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdditionalServiceService {
    @Autowired
    private AdditionalServiceRepository additionalServiceRepository;

    public List<AdditionalServiceDto> getAllEnabledServices() {
        return additionalServiceRepository.findAllByEnabledTrue()
                .stream()
                .map(service -> BasicConverter.convert(service, AdditionalServiceDto.class))
                .collect(Collectors.toList());
    }


    public AdditionalServiceDto getServiceById(int serviceId) {
        var service = additionalServiceRepository.findById(serviceId).orElse(null);
        return BasicConverter.convert(service, AdditionalServiceDto.class);
    }
}
