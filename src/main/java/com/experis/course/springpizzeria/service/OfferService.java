package com.experis.course.springpizzeria.service;

import com.experis.course.springpizzeria.model.Offer;
import com.experis.course.springpizzeria.model.Pizza;
import com.experis.course.springpizzeria.repository.OfferRepository;
import com.experis.course.springpizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OfferService {
    @Autowired
    PizzaRepository pizzaRepository;
    @Autowired
    OfferRepository offerRepository;
    public Offer createNewOffer(Integer pizzaId){
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()->new RuntimeException("La pizza con id " + pizzaId + "non è stata trovata"));
        Offer offer = new Offer();
        offer.setStartDate(LocalDate.now());
        offer.setEndDate(LocalDate.now().plusWeeks(1));
        offer.setPizza(pizza);
        return offer;
    }
    public Offer insertOfferIntoDB(Offer offer) {
        return offerRepository.save(offer);
    }
}
