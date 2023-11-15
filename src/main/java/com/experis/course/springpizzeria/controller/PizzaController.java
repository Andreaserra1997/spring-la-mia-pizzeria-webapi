package com.experis.course.springpizzeria.controller;

import com.experis.course.springpizzeria.model.Pizza;
import com.experis.course.springpizzeria.repository.PizzaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pizze")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(@RequestParam Optional<String> search, Model model) {
        List<Pizza> pizzaList;
        if (search.isPresent()) {
            pizzaList = pizzaRepository.findByNameContainingIgnoreCase(search.get());
        } else {
            pizzaList = pizzaRepository.findAll();
        }
        model.addAttribute("pizzaList", pizzaList);
        return "pizze/list";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("pizza", result.get());
            return "pizze/show";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pizza with id " + id + "not found");
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizze/form";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pizze/form";
        }
        Pizza savedPizza = pizzaRepository.save(formPizza);
        return "redirect:/pizze/show/" + savedPizza.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("pizza", result.get());
            return "/pizze/form";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La pizza con " + id + "non è stat trovata");
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/pizze/form";
        }
        Pizza pizzaToEdit = pizzaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        pizzaToEdit.setName(formPizza.getName());
        pizzaToEdit.setPrice(formPizza.getPrice());
        pizzaToEdit.setUrlImg(formPizza.getUrlImg());
        pizzaToEdit.setDescription(formPizza.getDescription());

        Pizza savedPizza = pizzaRepository.save(pizzaToEdit);
        return "redirect:/pizze/show/" + savedPizza.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Pizza pizzaToDelete = pizzaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        pizzaRepository.deleteById(id);
        return "redirect:/pizze";
    }
}