package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "special_offerts")
public class SpecialOffert {

    public SpecialOffert() {
    }

    public SpecialOffert(Integer id, List<Pizza> pizzas, String title, LocalDate dataStart, LocalDate dataEnd) {
        this.id = id;
        this.pizzas = pizzas;
        this.title = title;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "specialOffert")
    private List<Pizza> pizzas;

    @NotBlank(message = "Must insert a title")
    private String title;

    @FutureOrPresent(message = "The starting date cannot be in the past")
    private LocalDate dataStart;

    @FutureOrPresent(message = "The ending date cannot be in the past")
    private LocalDate dataEnd;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return this.pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDataStart() {
        return this.dataStart;
    }

    public void setDataStart(LocalDate dataStart) {
        this.dataStart = dataStart;
    }

    public LocalDate getDataEnd() {
        return this.dataEnd;
    }

    public void setDataEnd(LocalDate dataEnd) {
        this.dataEnd = dataEnd;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", pizza='" + getPizzas() + "'" +
                ", title='" + getTitle() + "'" +
                ", dataStart='" + getDataStart() + "'" +
                ", dataEnd='" + getDataEnd() + "'" +
                "}";
    }

}