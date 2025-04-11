package com.cpd.quickcart.order_service_api.adviser;

import com.cpd.quickcart.order_service_api.exception.EntryNotFoundException;
import com.cpd.quickcart.order_service_api.util.StanderdResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    public ResponseEntity<StanderdResponseDto> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<>(
               new  StanderdResponseDto(
                        204,
                        e.getMessage(),
                        e
                ), HttpStatus.NOT_FOUND
        );
    }
}
