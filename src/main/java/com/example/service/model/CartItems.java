package com.example.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartItem_id;
    private Integer quantity;
    @ManyToOne
    private Product product;
}
