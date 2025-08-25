package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.controller;

import java.util.List;

import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.model.Ingredient;
import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository repository;

    @GetMapping("")
    public String index(Model model) {

        List<Ingredient> ingredients = repository.findAll();

        model.addAttribute("ingredients", ingredients);

        return "ingredients/index";
    }

}
