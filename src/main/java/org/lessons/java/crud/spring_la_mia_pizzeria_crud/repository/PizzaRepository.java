package org.lessons.java.crud.spring_la_mia_pizzeria_crud.repository;

import org.lessons.java.crud.spring_la_mia_pizzeria_crud.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository <Pizza, Integer>{

    
}