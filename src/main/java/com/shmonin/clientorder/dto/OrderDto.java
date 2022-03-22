package com.shmonin.clientorder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto implements Serializable {
    private LocalDate date;
    private String details;
    private Integer amount;
}
