package com.shmonin.clientorder.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClientDto implements Serializable {
    private String name;
    private Integer phoneNumber;
    private Integer taxpayerIdentificationNumber;
    private Integer regionCode;
    private String settlement;
    private String street;
    private Integer houseNumber;
    private Integer buildingNumber;
    private Integer roomNumber;
}
