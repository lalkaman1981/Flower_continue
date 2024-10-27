package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.Delivery;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.flower.Flower;
import com.example.demo.flower.FlowerColor;
import com.example.demo.flower.FlowerType;
import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.Payment;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/order")
    public static List<Order> listFlowers() {

        Flower flower1 = new Flower(10, FlowerColor.BLUE, 10, FlowerType.ROSE);
        Flower flower2 = new Flower(10, FlowerColor.BLUE, 10, FlowerType.ROSE);
        Flower flower3 = new Flower(10, FlowerColor.BLUE, 10, FlowerType.ROSE);

        Flower flower4 = new Flower(10, FlowerColor.BLUE, 10, FlowerType.ROSE);
        Flower flower5 = new Flower(10, FlowerColor.BLUE, 10, FlowerType.ROSE);
        Flower flower6 = new Flower(10, FlowerColor.BLUE, 10, FlowerType.ROSE);

        List<Flower> flowersOrder1 = new ArrayList<>();
        flowersOrder1.add(flower1);
        flowersOrder1.add(flower2);
        flowersOrder1.add(flower3);

        Order order1 = new Order(flowersOrder1, new DHLDeliveryStrategy(), new CreditCardPaymentStrategy());

        List<Flower> flowersOrder2 = new ArrayList<>();
        flowersOrder2.add(flower4);
        flowersOrder2.add(flower5);
        flowersOrder2.add(flower6);

        Order order2 = new Order(flowersOrder2, new PostDeliveryStrategy(), new CreditCardPaymentStrategy());

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        return orders;
    }

    @GetMapping("/payment")
    public static Payment Payment() {
        return new CreditCardPaymentStrategy();
    }

    @GetMapping("/delivery")
    public static Delivery Delivery() {
        return new PostDeliveryStrategy();
    }
}
