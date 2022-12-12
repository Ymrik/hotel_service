package com.umarbariev.projects.hotel_service.dto.client;

import com.umarbariev.projects.hotel_service.dto.AuthorityDto;
import com.umarbariev.projects.hotel_service.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserClientDto {
    private String username;

    private String password;

    private String name;

    private String surname;

    private Date birthDate;

    private String sex;

    private String phoneNumber;

    private String email;

    public UserDto getUserDto() {
        return UserDto.builder()
                .username(username)
                .password(password)
                .authoritiesDto(List.of(new AuthorityDto(1, "ROLE_CLIENT")))
                .build();
    }

    public ClientDto getClientDto() {
        return ClientDto.builder()
                .userDto(getUserDto())
                .name(name)
                .surname(surname)
                .birthDate(birthDate)
                .sexDto(SexDto.getSexDto(sex))
                .phoneNumber(phoneNumber)
                .email(email)
                .loyaltyStatusDto(LoyaltyStatusDto.LEVEL_0)
                .build();
    }
}
