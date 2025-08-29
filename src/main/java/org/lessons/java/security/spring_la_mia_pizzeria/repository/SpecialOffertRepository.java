package org.lessons.java.security.spring_la_mia_pizzeria.repository;

import org.lessons.java.security.spring_la_mia_pizzeria.model.SpecialOffert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialOffertRepository extends JpaRepository <SpecialOffert, Integer>{
    
}
