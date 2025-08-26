package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.controller;

import java.util.List;

import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.model.Ingredient;
import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.model.Pizza;
import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("")
    public String index(Model model) {

        List<Ingredient> ingredients = ingredientRepository.findAll();

        model.addAttribute("ingredients", ingredients);

        return "ingredients/index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("isNew", true);
        model.addAttribute("ingredient", new Ingredient());
        return "ingredients/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("ingredient") Ingredient formIngredient, BindingResult bindingresult,
            Model model) {

        if (bindingresult.hasErrors()) {
            return "ingredients/create-or-edit";
        }

        ingredientRepository.save(formIngredient);
        return "redirect:/ingredients";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        Ingredient ingredientToDelete = ingredientRepository.findById(id).get();

        for (Pizza pizza : ingredientToDelete.getPizzas()) {
            pizza.getIngredients().remove(ingredientToDelete);
        }

        ingredientRepository.delete(ingredientToDelete);

        return "redirect:/ingredients";
    }

}
