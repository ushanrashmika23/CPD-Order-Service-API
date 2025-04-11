package com.cpd.quickcart.order_service_api.service.impl;

import com.cpd.quickcart.order_service_api.dto.request.CustomerOrderRequestDto;
import com.cpd.quickcart.order_service_api.dto.request.OrderDetailRequestDto;
import com.cpd.quickcart.order_service_api.dto.response.CustomerOrderResponseDto;
import com.cpd.quickcart.order_service_api.dto.response.OrderDetailResponseDto;
import com.cpd.quickcart.order_service_api.dto.response.paginate.CustomerOrderPaginateDto;
import com.cpd.quickcart.order_service_api.entity.CustomerOrder;
import com.cpd.quickcart.order_service_api.entity.OrderDetail;
import com.cpd.quickcart.order_service_api.entity.OrderStatus;
import com.cpd.quickcart.order_service_api.repo.CustomerOrderRepo;
import com.cpd.quickcart.order_service_api.repo.OrderDetailRepo;
import com.cpd.quickcart.order_service_api.repo.OrderStatusRepo;
import com.cpd.quickcart.order_service_api.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepo customerOrderRepo;
    private final OrderStatusRepo orderStatusRepo;

    @Override
    public void createOrder(CustomerOrderRequestDto requestDto) {

        OrderStatus orderStatus=orderStatusRepo.findByStatus("Pending").orElseThrow(()->new RuntimeException("Order status not found"));

        CustomerOrder customerOrder =new CustomerOrder();
        customerOrder.setOrderId(UUID.randomUUID().toString());
        customerOrder.setUserId(requestDto.getUserId());
        customerOrder.setTotalAmount(requestDto.getTotalAmount());
        customerOrder.setOrderDate(requestDto.getOrderDate());
        customerOrder.setRemark("");

        customerOrder.setOrderStatus(orderStatus);
        customerOrder.setProducts(
                requestDto.getOrderDetails().stream().map(e -> createOrderDetail(e, customerOrder)).collect(Collectors.toSet())
        );
        customerOrderRepo.save(customerOrder);

    }

    @Override
    public CustomerOrderResponseDto findOrderById(String orderId) {

        CustomerOrder customerOrder = customerOrderRepo.findById(orderId).orElseThrow(() -> new RuntimeException(String.format("Order with id %s not found", orderId)));
        return toCustomerOrderResponseDto(customerOrder);
    }

    @Override
    public CustomerOrderPaginateDto searchAll(String searchText, int page, int size) {
        return CustomerOrderPaginateDto.builder()
                .count(customerOrderRepo.searchCount(searchText))
                .dataList(
                        customerOrderRepo.searchAll(searchText, PageRequest.of(page,size))
                                .stream().map(this::toCustomerOrderResponseDto).collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public void deleteOrderById(String orderId) {
        CustomerOrder customerOrder = customerOrderRepo.findById(orderId).orElseThrow(() -> new RuntimeException(String.format("Order with id %s not found", orderId)));
        customerOrderRepo.delete(customerOrder);
    }

    private OrderDetail createOrderDetail(OrderDetailRequestDto requestDto, CustomerOrder order){
        if(requestDto==null){
            return null;
        }
        return OrderDetail.builder()
                .detailId(UUID.randomUUID().toString())
                .unitPrice(requestDto.getUnitPrice())
                .discount(requestDto.getDiscount())
                .qty(requestDto.getQty())
                .customerOrder(order)
                .build();
    }


    private CustomerOrderResponseDto toCustomerOrderResponseDto(CustomerOrder customerOrder){
        if(customerOrder==null){
            return null;
        }
        return CustomerOrderResponseDto.builder()
                .userId(customerOrder.getOrderId())
                .orderID(customerOrder.getUserId())
                .orderDetails(
                        customerOrder.getProducts().stream()
                                .map(this::toOrderDetailResponseDto)
                                .collect(Collectors.toList())
                )
                .orderDate(customerOrder.getOrderDate())
                .totalAmount(customerOrder.getTotalAmount())
                .remark(customerOrder.getRemark())
                .orderStatus(customerOrder.getOrderStatus().getStatus())
                .build();
    }

    private OrderDetailResponseDto toOrderDetailResponseDto(OrderDetail orderDetail){
        if(orderDetail==null){
            return null;
        }
        return OrderDetailResponseDto.builder()
                .detailId(orderDetail.getDetailId())
                .productId(orderDetail.getProductId())
                .qty(orderDetail.getQty())
                .unitPrice(orderDetail.getUnitPrice())
                .discount(orderDetail.getDiscount())
                .build();
    }

}
