package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.model.Pizza;
import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.model.SpecialOffert;
import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.repository.IngredientRepository;
import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("")
    public String index(@RequestParam(name = "ingredients", required = false) String ingredients, Model model) {

        List<Pizza> pizzas = pizzaRepository.findAll();

        if (ingredients != null && !ingredients.isEmpty()) {
            List<Pizza> filteredPizzas = new ArrayList<>();

            for (Pizza pizza : pizzas) {
                if (pizza.getDescription() != null &&
                        pizza.getDescription().toLowerCase().contains(ingredients.toLowerCase())) {
                    filteredPizzas.add(pizza);
                }
            }

            pizzas = filteredPizzas;
        }

        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {

        Pizza pizzaDetails = pizzaRepository.findById(id).get();
        model.addAttribute("selectedPizza", pizzaDetails);

        return "pizzas/pizzaDetails";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("isNew", true);
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("ingredients", ingredientRepository.findAll());

        return "pizzas/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/pizzas/create-or-edit";
        }

        pizzaRepository.save(formPizza);
        return "redirect:/pizzas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("ingredients", ingredientRepository.findAll());

        model.addAttribute("pizza", pizzaRepository.findById(id).get());
        return "/pizzas/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult,
            Model model) {

        model.addAttribute("ingredients", ingredientRepository.findAll());

        if (bindingResult.hasErrors()) {
            return "/pizzas/edit";
        }

        pizzaRepository.save(formPizza);

        return "redirect:/pizzas";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        pizzaRepository.deleteById(id);
        return "redirect:/pizzas";
    }

    @GetMapping("/{id}/specialoffert")
    public String createSpecialOffert(@PathVariable Integer id, Model model) {
        model.addAttribute("isNew", true);

        SpecialOffert specialOffert = new SpecialOffert();
        specialOffert.setPizza(pizzaRepository.findById(id).get());

        model.addAttribute("specialOffert", specialOffert);

        return "special-offerts/create-or-edit";
    }

}
