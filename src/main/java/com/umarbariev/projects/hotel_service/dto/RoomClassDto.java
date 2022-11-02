package com.umarbariev.projects.hotel_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomClassDto {
    private int id;

    private String name;

    private String description;
}
