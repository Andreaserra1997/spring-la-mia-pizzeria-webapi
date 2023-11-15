package com.experis.course.springpizzeria.controller;

import com.experis.course.springpizzeria.model.Offer;
import com.experis.course.springpizzeria.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Controller
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    OfferService offerService;
    @GetMapping("/create")
    public String create(@RequestParam Integer pizzaId, Model model) {
        try {
            model.addAttribute("offer", offerService.createNewOffer(pizzaId));
            return "offers/form";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("offer") Offer formOffer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "offers/form";
        }
        Offer savedOffer = offerService.insertOfferIntoDB(formOffer);
        return "redirect:/pizze/show/" + formOffer.getPizza().getId();
    }
}
