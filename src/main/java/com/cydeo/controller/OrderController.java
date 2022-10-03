package com.cydeo.controller;

import com.cydeo.model.Pizza;
import com.cydeo.model.PizzaOrder;
import com.cydeo.repository.OrderRepository;
import com.cydeo.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;



@Controller
@RequestMapping("/orders")
public class OrderController {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    public OrderController(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(@RequestParam UUID pizzaId, Model model) {

        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setPizza(getPizza(pizzaId));
        model.addAttribute("pizzaOrder", pizzaOrder);
        System.out.println(pizzaOrder);
        return "/orderForm";
        // Fix the getPizza method below in line 49.
    }

    @PostMapping("/{pizzaId}")
    public String processOrder(@RequestParam UUID pizzaId, PizzaOrder pizzaOrder) {

       pizzaOrder.setPizza(getPizza(pizzaId)); // Why do I need to pass this, if I dont it's null?

      orderRepository.createOrder(pizzaOrder);
       System.out.println(pizzaOrder);

        return "redirect:/home";
    }

    //TODO
    private Pizza getPizza(UUID pizzaId) {
      return pizzaRepository.findById(pizzaId);

    }

}
