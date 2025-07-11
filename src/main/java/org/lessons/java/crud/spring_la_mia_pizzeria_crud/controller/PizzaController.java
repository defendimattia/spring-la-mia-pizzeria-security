package org.lessons.java.crud.spring_la_mia_pizzeria_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/pizze")
public class PizzaController {

    @GetMapping("")
    public String index() {
        return "pizzas/index";
    }

}
