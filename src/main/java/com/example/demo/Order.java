package com.example.demo;

import java.util.List;

import com.example.demo.delivery.Delivery;
import com.example.demo.flower.Item;
import com.example.demo.payment.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order<T extends Item> {

    private List<T> items;
    private Delivery delivery;
    private Payment payment;

    public void setItems(List<T> newItems) {
        items = newItems;
    }

    public Order(List<T> items, Delivery delivery) {
        this.items = items;
        this.delivery = delivery;
    }

    public Order(List<T> items, Delivery delivery, Payment payment) {
        this.items = items;
        this.delivery = delivery;
        this.payment = payment;
    }

    public double calculateTotalPrice() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void processOrder() {
        System.out.println("order was processed");
    }

    public void removeItem(T item) {
        items.remove(item);
    }
}
