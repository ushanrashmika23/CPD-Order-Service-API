package com.cpd.quickcart.order_service_api.api;

import com.cpd.quickcart.order_service_api.dto.request.CustomerOrderRequestDto;
import com.cpd.quickcart.order_service_api.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer-orders")
@RequiredArgsConstructor
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    @PostMapping("/business")
    public String createCustomer(@RequestBody CustomerOrderRequestDto customerOrderRequestDto) {
        customerOrderService.createOrder(customerOrderRequestDto);
    }

    @GetMapping("/visitors/find-by-id/{id}")
    public String create(@PathVariable String id) {
        customerOrderService.findOrderById(id);
    }

    @PutMapping("/business/update-order/{id}")
    public String createCustomer(@RequestBody CustomerOrderRequestDto customerOrderRequestDto, @PathVariable String id) {
        customerOrderService.updateOrder(customerOrderRequestDto, id);
    }

    @PutMapping("/business/update-remark/{id}")
    public String createCustomer(@RequestParam String remark, @PathVariable String id) {
        customerOrderService.manageRemark(remark, id);
    }

    @PutMapping("/business/update-status/{id}")
    public String createCustomer(@RequestParam String status, @PathVariable String id) {
        customerOrderService.manageStatus(status, id);
    }

    @DeleteMapping("/business/delete-by-id/{id}")
    public String createCustomer(@PathVariable String id) {
        customerOrderService.deleteOrderById(id);
    }

    @GetMapping("/visitors")
    public String createCustomer(@RequestParam String searchText,@RequestParam int page,@RequestParam int size) {
        customerOrderService.searchAll(searchText,page,size);
    }


}
