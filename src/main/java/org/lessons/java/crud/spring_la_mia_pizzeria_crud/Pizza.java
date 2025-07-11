package org.lessons.java.crud.spring_la_mia_pizzeria_crud;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Must insert a name")
    private String name;

    @Lob
    private String description;

    private String imageURL;

    @Column(nullable = false)
    @NotNull(message = "Must insert a price")
    @DecimalMin(value = "0.00", inclusive = true, message = "The price cannot be less than 0.00")
    private BigDecimal price;

}
