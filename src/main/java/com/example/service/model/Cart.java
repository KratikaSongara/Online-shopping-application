package com.example.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    private Integer cart_id;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToMany
    private List<Product> productList = new ArrayList<>();
    private Integer quantity;
}
