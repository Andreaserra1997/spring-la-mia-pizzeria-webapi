package com.experis.course.springpizzeria.service;
import java.util.List;
import java.util.Optional;
import com.experis.course.springpizzeria.model.Pizza;
import com.experis.course.springpizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getPizzaList(Optional<String> search) {
        if (search.isPresent()) {
            return pizzaRepository.findByNameContainingIgnoreCase(search.get());
        } else {
            return pizzaRepository.findAll();
        }
    }

    public List<Pizza> getPizzaList() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Integer id) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pizza with id " + id + "not found");
        }
    }

    // metodo per creare un nuovo libro
    public Pizza createPizza(Pizza pizza) {
        pizza.setId(null);
        try {
            return pizzaRepository.save(pizza);
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

    public Pizza editPizza(Pizza pizza) {
        Pizza pizzaToEdit = getPizzaById(pizza.getId());
        // sostituisco i valori dei campi previsti
        pizzaToEdit.setName(pizza.getName());
        pizzaToEdit.setPrice(pizza.getPrice());
        pizzaToEdit.setUrlImg(pizza.getUrlImg());
        pizzaToEdit.setDescription(pizza.getDescription());
        pizzaToEdit.setIngredients(pizza.getIngredients());

        return pizzaRepository.save(pizzaToEdit);
    }

    // metodo che elimina un libro da database
    public void deletePizza(Integer id) {
        pizzaRepository.deleteById(id);
    }
}
