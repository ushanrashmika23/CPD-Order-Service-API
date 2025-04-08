package com.cpd.quickcart.order_service_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name="order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @Id
    @Column(name = "detail_id",unique = true,nullable = false)
    private String detailId;
    @Column(name = "product_id",nullable = false,length = 80)
    private Date productId;
    @Column(name = "qty",nullable = false)
    private int qty;
    @Column(name = "unit_price",nullable = false,precision = 10,scale = 2)
    private double unitPrice;
    @Column(name = "discount",precision = 10,scale = 2)
    private double discount;



}
