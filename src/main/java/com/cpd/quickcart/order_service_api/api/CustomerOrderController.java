package com.cpd.quickcart.order_service_api.api;

import com.cpd.quickcart.order_service_api.dto.request.CustomerOrderRequestDto;
import com.cpd.quickcart.order_service_api.dto.response.CustomerOrderResponseDto;
import com.cpd.quickcart.order_service_api.dto.response.paginate.CustomerOrderPaginateDto;
import com.cpd.quickcart.order_service_api.service.CustomerOrderService;
import com.cpd.quickcart.order_service_api.util.StanderdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer-orders")
@RequiredArgsConstructor
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    @PostMapping("/business")
    public ResponseEntity<StanderdResponseDto> createCustomer(@RequestBody CustomerOrderRequestDto customerOrderRequestDto) {
        customerOrderService.createOrder(customerOrderRequestDto);
        return new ResponseEntity<>(
                new StanderdResponseDto(
                        200,
                        "Order created successfully",
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/visitors/find-by-id/{id}")
    public ResponseEntity<StanderdResponseDto> find(@PathVariable String id) {
        CustomerOrderResponseDto orderById = customerOrderService.findOrderById(id);
        return new ResponseEntity<>(
                new StanderdResponseDto(
                        200,
                        "Order founded",
                            orderById
                ), HttpStatus.OK
        );
    }

    @PutMapping("/business/update-order/{id}")
    public ResponseEntity<StanderdResponseDto> updateCustomer(@RequestBody CustomerOrderRequestDto customerOrderRequestDto, @PathVariable String id) {
        customerOrderService.updateOrder(customerOrderRequestDto, id);
        return new ResponseEntity<>(
                new StanderdResponseDto(
                        200,
                        "Order updated successfully",
                        null
                ), HttpStatus.OK
        );
    }

    @PutMapping("/business/update-remark/{id}")
    public ResponseEntity<StanderdResponseDto> updateRemark(@RequestParam String remark, @PathVariable String id) {
        customerOrderService.manageRemark(remark, id);
        return new ResponseEntity<>(
                new StanderdResponseDto(
                        200,
                        "Order remark updated successfully",
                        null
                ), HttpStatus.OK
        );
    }

    @PutMapping("/business/update-status/{id}")
    public ResponseEntity<StanderdResponseDto> updateStaus(@RequestParam String status, @PathVariable String id) {
        customerOrderService.manageStatus(status, id);
        return new ResponseEntity<>(
                new StanderdResponseDto(
                        200,
                        "Order status updated successfully",
                        null
                ), HttpStatus.OK
        );
    }

    @DeleteMapping("/business/delete-by-id/{id}")
    public ResponseEntity<StanderdResponseDto> deleteCustomer(@PathVariable String id) {
        customerOrderService.deleteOrderById(id);
        return new ResponseEntity<>(
                new StanderdResponseDto(
                        204,
                        "Order deleted successfully",
                        null
                ), HttpStatus.OK
        );
    }

    @GetMapping("/visitors")
    public ResponseEntity<StanderdResponseDto> createCustomer(@RequestParam String searchText, @RequestParam int page, @RequestParam int size) {
        CustomerOrderPaginateDto customerOrderPaginateDto = customerOrderService.searchAll(searchText, page, size);
        return new ResponseEntity<>(
                new StanderdResponseDto(
                        200,
                        "Orders fetched successfully",
                        customerOrderPaginateDto
                ), HttpStatus.OK
        );
    }


}
