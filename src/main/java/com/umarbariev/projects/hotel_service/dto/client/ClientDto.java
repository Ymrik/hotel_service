package com.umarbariev.projects.hotel_service.dto.client;

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

    private UserDto userDto;

    private String name;

    private String surname;

    private int age;

    private SexDto sex;

    private String phoneNumber;

    private String email;

    private LoyaltyStatusDto loyaltyStatusDto;
}
