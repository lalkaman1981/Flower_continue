package com.example.demo.flower;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerPack
        extends
        Item {
    private Flower flower;
    private int quantity;

    public FlowerPack(
            Flower flower,
            int quantity) {
        this.flower = new Flower(
                flower);
        this.quantity = quantity;
    }

    @Override
    public double getPrice() {
        return flower
                .getPrice()
                * quantity;
    }
}
