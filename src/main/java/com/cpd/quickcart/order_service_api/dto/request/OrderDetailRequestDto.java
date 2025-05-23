package com.cpd.quickcart.order_service_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRequestDto {
    private String detailId;
    private Date productId;
    private int qty;
    private double unitPrice;
    private double discount;

}
