package com.umarbariev.projects.hotel_service.dto.additionalService;

import com.umarbariev.projects.hotel_service.dto.client.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientAdditionalServiceDto {
    private int id;
    private ClientDto client;
    private AdditionalServiceDto additionalService;
    private Double cost;
}
