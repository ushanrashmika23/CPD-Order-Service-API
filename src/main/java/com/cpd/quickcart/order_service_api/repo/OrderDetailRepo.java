package com.cpd.quickcart.order_service_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<CustomerOrderRepo,String> {
}
