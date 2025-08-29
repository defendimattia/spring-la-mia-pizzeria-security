package org.lessons.java.security.spring_la_mia_pizzeria.repository;

import org.lessons.java.security.spring_la_mia_pizzeria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository <Pizza, Integer>{

    
}