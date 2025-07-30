package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.repository;

import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.SpecialOffert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialOffertRepository extends JpaRepository <SpecialOffert, Integer>{
    
}
