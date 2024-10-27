package com.example.demo.flower;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flower
        extends
        Item {
    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;

    public Flower(
            Flower flower) {
        sepalLength = flower.sepalLength;
        color = flower.color;
        price = flower.price;
        flowerType = flower.flowerType;
    }

    public String getColor() {
        return color
                .toString();
    }

    @Override
    public double getPrice() {
        return price;
    }
}
