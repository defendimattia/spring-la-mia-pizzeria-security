package org.lessons.java.webapi.spring_la_mia_pizzeria.repository;

import org.lessons.java.webapi.spring_la_mia_pizzeria.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
