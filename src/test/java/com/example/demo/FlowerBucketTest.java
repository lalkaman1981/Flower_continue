package com.example.demo;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.flower.Flower;
import com.example.demo.flower.FlowerBucket;
import com.example.demo.flower.FlowerPack;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR
                .nextInt(
                        MAX_PRICE);
        int quantity = RANDOM_GENERATOR
                .nextInt(
                        MAX_QUANTITY);
        Flower flower = new Flower();
        flower.setPrice(
                price);
        var flowerPack = new FlowerPack(
                flower,
                quantity);
        flowerBucket
                .add(flowerPack);
        Assertions
                .assertEquals(
                        price * quantity,
                        flowerBucket
                                .getPrice());
    }
}
