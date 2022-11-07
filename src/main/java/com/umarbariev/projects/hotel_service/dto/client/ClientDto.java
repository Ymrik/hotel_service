package com.umarbariev.projects.hotel_service.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umarbariev.projects.hotel_service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
    private int id;
    @JsonProperty("user")
    private UserDto userDto;

    private String name;

    private String surname;

    private int age;
    @JsonProperty("sex")
    private SexDto sexDto;

    private String phoneNumber;

    private String email;
    @JsonProperty("loyaltyStatus")
    private LoyaltyStatusDto loyaltyStatusDto;
}
