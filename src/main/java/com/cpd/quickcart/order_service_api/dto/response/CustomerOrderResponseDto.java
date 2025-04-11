package com.cpd.quickcart.order_service_api.dto.response;


import com.cpd.quickcart.order_service_api.dto.request.OrderDetailRequestDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerOrderResponseDto {
    private String orderID;
    private String userId;
    private String remark;
    private String orderStatus;
    private double totalAmount;
    private Date orderDate;
    private List<OrderDetailResponseDto> orderDetails;
}
