package com.cpd.quickcart.order_service_api.service;

import com.cpd.quickcart.order_service_api.dto.request.CustomerOrderRequestDto;
import com.cpd.quickcart.order_service_api.dto.response.CustomerOrderResponseDto;
import com.cpd.quickcart.order_service_api.dto.response.paginate.CustomerOrderPaginateDto;

public interface CustomerOrderService {
    public void createOrder(CustomerOrderRequestDto customerOrder);
    public CustomerOrderResponseDto findOrderById(String orderId);
    public void deleteOrderById(String orderId);
    public CustomerOrderPaginateDto searchAll(String searchText,int page,int size);
}
