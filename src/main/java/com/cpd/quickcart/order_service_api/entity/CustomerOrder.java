package com.cpd.quickcart.order_service_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity(name="customer_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {
    @Id
    @Column(name = "order_id",unique = true,nullable = false)
    private String orderId;
    @Column(name = "order_date",nullable = false,columnDefinition = "DATETIME")
    private Date orderDate;
    @Column(name = "order_amount",nullable = false,precision = 10,scale = 2)
    private double totalAmount;
    @Column(name = "user_id",nullable = false)
    private String userId;
    @Column(name = "remark",length = 750)
    private String remark;
}
