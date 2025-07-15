package org.lessons.java.crud.spring_la_mia_pizzeria_crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.crud.spring_la_mia_pizzeria_crud.Pizza;
import org.lessons.java.crud.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping("")
    public String index(@RequestParam(name = "ingredients", required = false) String ingredients, Model model) {

        List<Pizza> pizzas = repository.findAll();
        ;

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

        Pizza pizzaDetails = repository.findById(id).get();
        model.addAttribute("selectedPizza", pizzaDetails);

        return "pizzas/pizzaDetails";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("pizza", new Pizza());

        return "pizzas/create";
    }
    

}
