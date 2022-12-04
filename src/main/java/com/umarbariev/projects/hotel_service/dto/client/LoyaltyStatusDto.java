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
    public static LoyaltyStatusDto LEVEL_1 = new LoyaltyStatusDto(1, "Level 1", 5, 5);
    public static LoyaltyStatusDto LEVEL_2 = new LoyaltyStatusDto(2, "Level 2", 10, 10);
    public static LoyaltyStatusDto LEVEL_3 = new LoyaltyStatusDto(3, "Level 3", 15, 20);
    public static LoyaltyStatusDto LEVEL_4 = new LoyaltyStatusDto(4, "Level 4", 20, 30);
    public static LoyaltyStatusDto LEVEL_5 = new LoyaltyStatusDto(5, "Level 5", 30, 45);

    private int id;

    private String name;

    private int discount;

    private int ordersCount;
}
