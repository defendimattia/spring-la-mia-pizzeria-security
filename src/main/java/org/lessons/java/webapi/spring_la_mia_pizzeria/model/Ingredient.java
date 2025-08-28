package org.lessons.java.webapi.spring_la_mia_pizzeria.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Ingredient must have a valid name")
    @Size(min = 3, max = 50, message = "Ingredient name must be between 3 and 50 characters long")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnoreProperties("pizzas")
    private List<Pizza> pizzas;

    public Ingredient(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ingredient() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pizza> getPizzas() {
        return this.pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public String toString() {
        return getName();
    }

}
