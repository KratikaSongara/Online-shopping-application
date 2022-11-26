package com.example.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    private Integer order_id;
    private LocalDate date;
    private String status;
    @OneToOne
    private Customer customer;
    @Embedded
    private Address address;
    @OneToMany
    private List<Product> product = new ArrayList<>();
}
