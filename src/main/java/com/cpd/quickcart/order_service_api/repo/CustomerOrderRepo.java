package com.cpd.quickcart.order_service_api.repo;

import com.cpd.quickcart.order_service_api.entity.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,String> {
    @Query(nativeQuery = true, value = "SELECT * FROM customer_order WHERE remark LIKE %?1%")
    public Page<CustomerOrder>  searchAll(String searchText, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM customer_order WHERE remark LIKE %?1%")
    public long  searchCount(String searchText);
}
