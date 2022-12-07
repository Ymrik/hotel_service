package com.umarbariev.projects.hotel_service.service.client;

import com.umarbariev.projects.hotel_service.dto.client.LoyaltyStatusDto;
import com.umarbariev.projects.hotel_service.repositories.client.LoyaltyStatusRepository;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyStatusService {
    @Autowired
    private LoyaltyStatusRepository loyaltyStatusRepository;

    public LoyaltyStatusDto getLoyaltyStatusById(int id) {
        return BasicConverter.convert(loyaltyStatusRepository.findById(id).orElse(null), LoyaltyStatusDto.class);
    }
}
