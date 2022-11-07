package com.umarbariev.projects.hotel_service.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoyaltyStatusDto {
    private int id;

    private String name;

    private int discount;

    private int ordersCount;
}
