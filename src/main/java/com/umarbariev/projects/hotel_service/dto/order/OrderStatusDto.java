package com.umarbariev.projects.hotel_service.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatusDto {
    public final static OrderStatusDto ORDER_STATUS_AWAITING_CONFIRMATION = new OrderStatusDto(1,"Awaiting Confirmation");
    public final static OrderStatusDto ORDER_STATUS_ACTIVE = new OrderStatusDto(2,"Active");
    public final static OrderStatusDto ORDER_STATUS_FINISHED = new OrderStatusDto(3,"Finished");

    private int id;

    private String name;
}
