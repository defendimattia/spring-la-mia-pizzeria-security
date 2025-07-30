package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.controller;

import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.SpecialOffert;
import org.lessons.java.crudrelazioni.spring_la_mia_pizzeria.repository.SpecialOffertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/specialofferts")
public class SpecialOffertController {

    @Autowired
    private SpecialOffertRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("specialOffert") SpecialOffert formSpecialOffert,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "special-offerts/create-or-edit";
        }

        repository.save(formSpecialOffert);

        return "redirect:/pizzas";
    }

}
