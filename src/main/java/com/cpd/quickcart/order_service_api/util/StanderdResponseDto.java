package com.cpd.quickcart.order_service_api.util;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StanderdResponseDto {
    private int stsus;
    private String msg;
    private Object data;

}
