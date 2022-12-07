package com.umarbariev.projects.hotel_service.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoForNextLoyalStatusDto {
    private ClientDto client;

    private LoyaltyStatusDto current;

    private LoyaltyStatusDto next;

    private int currentOrdersCount;

    private int ordersForNextStatus;
}
