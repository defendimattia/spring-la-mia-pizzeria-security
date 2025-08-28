package org.lessons.java.webapi.spring_la_mia_pizzeria.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizzas")
@JsonPropertyOrder({ "id", "name", "ingredients", "specialOfferts", "imageURL", "price" })
public class Pizza {

    public Pizza(Integer id, String name, String imageURL, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
    }

    public Pizza() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "pizza")
    @JsonManagedReference
    private List<SpecialOffert> specialOfferts;

    @ManyToMany()
    @JoinTable(name = "ingredient_pizza", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    @JsonIgnoreProperties("pizzas")
    private List<Ingredient> ingredients;

    @Column(nullable = false)
    @NotBlank(message = "Must insert a name")
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters long")
    private String name;

    @Column(name = "image_url")
    @Size(max = 300, message = "The image URL must be at most 300 characters long")
    private String imageURL;

    @Column(nullable = false)
    @NotNull(message = "Must insert a price")
    @DecimalMin(value = "0.00", inclusive = false, message = "The price cannot be equal or less than 0.00")
    private BigDecimal price;

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

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<SpecialOffert> getSpecialOfferts() {
        return this.specialOfferts;
    }

    public void setSpecialOfferts(List<SpecialOffert> specialOfferts) {
        this.specialOfferts = specialOfferts;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", imageURL='" + getImageURL() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}
