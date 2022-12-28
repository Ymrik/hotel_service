package com.umarbariev.projects.hotel_service.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umarbariev.projects.hotel_service.dto.AuthorityDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;

    private String password;

    private boolean enabled;

    @JsonProperty("authorities")
    private List<AuthorityDto> authoritiesDto;
}
