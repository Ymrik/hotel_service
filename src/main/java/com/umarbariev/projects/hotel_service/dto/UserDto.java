package com.umarbariev.projects.hotel_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String username;

    private String password;

    private boolean enabled;
    @JsonProperty("authorities")
    private List<AuthorityDto> authoritiesDto;
}
