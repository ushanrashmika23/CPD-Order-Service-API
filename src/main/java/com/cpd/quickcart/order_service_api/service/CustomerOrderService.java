package com.cpd.quickcart.order_service_api.service;

import com.cpd.quickcart.order_service_api.dto.request.CustomerOrderRequestDto;
import com.cpd.quickcart.order_service_api.dto.response.CustomerOrderResponseDto;

public interface CustomerOrderService {
    public void createOrder(CustomerOrderRequestDto customerOrder);
    public CustomerOrderResponseDto findOrderById(String orderId);
    public void DeleteOrderById(String orderId);
}
