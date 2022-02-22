package com.example.javasample.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class AddressEntity {

    @Id @GeneratedValue
    private Long id;

    private Address address;

}
