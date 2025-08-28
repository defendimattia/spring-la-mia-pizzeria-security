package org.lessons.java.webapi.spring_la_mia_pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.webapi.spring_la_mia_pizzeria.model.Pizza;
import org.lessons.java.webapi.spring_la_mia_pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaRestController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public List<Pizza> index() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        return pizzas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> show(@Valid @PathVariable Integer id) {

        Optional<Pizza> pizzaTry = pizzaRepository.findById(id);

        if (pizzaTry.isEmpty()) {
            return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Pizza>(pizzaTry.get(), HttpStatus.OK);
    }

    // @PostMapping
    // public Pizza store(@Valid @RequestBody Pizza pizza) {

    //     return;
    // }

    // @PutMapping("/{id}")
    // public Pizza update(@Valid @RequestBody Pizza pizza, @PathVariable Integer id) {

    //     return;
    // }

    // @DeleteMapping("/{id}") {
    //     public void delete(@Valid @PathVariable Integer id) {

    //     }
    // }
}
