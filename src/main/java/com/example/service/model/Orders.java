package com.example.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {  //since 'Order' is a keyword in mysql, so, we cannot use it as our class name
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer o_id;
    private LocalDate date;
    private String status;
    @OneToOne
    private Customer customer;
    @OneToMany
    private List<Product> product = new ArrayList<>();
}
