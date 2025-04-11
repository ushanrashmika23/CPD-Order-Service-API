package com.cpd.quickcart.order_service_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name="order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail {
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

    @ManyToOne
    @JoinColumn(name="customer_order_id")
    private CustomerOrder customerOrder;

}
