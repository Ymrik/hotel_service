package com.umarbariev.projects.hotel_service.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private int clientId;

    private int roomTypeId;

    private Date checkInDate;

    private Date checkOutDate;

    private int guestsCount;
}
