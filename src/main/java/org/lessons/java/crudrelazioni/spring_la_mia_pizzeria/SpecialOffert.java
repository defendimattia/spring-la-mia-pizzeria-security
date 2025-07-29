package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "special_offerts")
public class SpecialOffert {

    public SpecialOffert() {
    }

    public SpecialOffert(Integer id, Pizza pizza, String title, LocalDate dataStart, LocalDate dataEnd) {
        this.id = id;
        this.pizza = pizza;
        this.title = title;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

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

    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
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
                ", pizza='" + getPizza() + "'" +
                ", title='" + getTitle() + "'" +
                ", dataStart='" + getDataStart() + "'" +
                ", dataEnd='" + getDataEnd() + "'" +
                "}";
    }

}