package com.shmonin.clientorder.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "tin")
    private Integer taxpayerIdentificationNumber;

    @Column(name = "region_code")
    private Integer regionCode;

    @Column(name = "settlement", length = 50)
    private String settlement;

    @Column(name = "street", length = 50)
    private String street;

    @Column(name = "house_number")
    private Integer houseNumber;

    @Column(name = "building_number")
    private Integer buildingNumber;

    @Column(name = "room_number")
    private Integer roomNumber;
}