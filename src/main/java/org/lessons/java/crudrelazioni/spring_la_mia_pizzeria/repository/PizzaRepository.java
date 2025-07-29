package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.repository;

import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository <Pizza, Integer>{

    
}