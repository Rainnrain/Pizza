package com.cydeo.repository;

import com.cydeo.exception.PizzaNotFoundException;
import com.cydeo.model.Pizza;
import com.cydeo.model.PizzaOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {
    private static List<PizzaOrder> pizzaOrderList = new ArrayList<>();

    public PizzaOrder createOrder(PizzaOrder PizzaOrderToSave) {
        pizzaOrderList.add(PizzaOrderToSave);
        return PizzaOrderToSave;
    }

    public List<PizzaOrder> readAll() {
        return pizzaOrderList;
    }

    public PizzaOrder findById(String id){
        return pizzaOrderList.stream().filter(p->p.getCcNumber().equals(id))
                .findFirst().orElseThrow(()->new PizzaNotFoundException("Pizza not found"));
    }
}
