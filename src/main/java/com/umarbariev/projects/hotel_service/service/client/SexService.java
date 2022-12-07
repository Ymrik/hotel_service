package com.umarbariev.projects.hotel_service.service.client;

import com.umarbariev.projects.hotel_service.dto.client.SexDto;
import com.umarbariev.projects.hotel_service.repositories.client.SexRepository;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SexService {
    @Autowired
    private SexRepository sexRepository;

    public SexDto findByName(String name) {
        var sex = sexRepository.findByName(name).orElse(null);
        if (sex == null) return null;
        return BasicConverter.convert(sex, SexDto.class);
    }
}
