package com.umarbariev.projects.hotel_service.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SexDto {
    public static SexDto MALE = new SexDto(1, "Male");
    public static SexDto FEMALE = new SexDto(2, "Female");

    private int id;

    private String name;

    public static SexDto getSexDto(String sex) {
        if (sex.equals("Male")) return MALE;
        if (sex.equals("Female")) return FEMALE;
        return null;
    }
}
