package com.cpd.quickcart.order_service_api.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailResponseDto {
    private String detailId;
    private Date productId;
    private int qty;
    private double unitPrice;
    private double discount;

}
