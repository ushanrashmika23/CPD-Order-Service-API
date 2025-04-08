package com.cpd.quickcart.order_service_api.repo;

import com.cpd.quickcart.order_service_api.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<CustomerOrder,String> {
}
