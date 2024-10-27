package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.demo.flower.FlowerType;

class FlowerTypeTest {

    @Test
    void testFlowerTypeValues() {
        FlowerType[] expectedTypes = {
                FlowerType.CHAMOMILE,
                FlowerType.ROSE,
                FlowerType.TULIP };
        Assertions
                .assertArrayEquals(
                        expectedTypes,
                        FlowerType
                                .values());
    }

    @Test
    void testIndividualFlowerType() {
        Assertions
                .assertEquals(
                        FlowerType.ROSE,
                        FlowerType
                                .valueOf(
                                        "ROSE"));
        Assertions
                .assertEquals(
                        FlowerType.CHAMOMILE,
                        FlowerType
                                .valueOf(
                                        "CHAMOMILE"));
        Assertions
                .assertEquals(
                        FlowerType.TULIP,
                        FlowerType
                                .valueOf(
                                        "TULIP"));
    }

    @Test
    void testInvalidFlowerType() {
        IllegalArgumentException thrown = Assertions
                .assertThrows(
                        IllegalArgumentException.class,
                        () -> FlowerType
                                .valueOf(
                                        "INVALID"));

        Assertions
                .assertEquals(
                        "No enum constant flower.store.FlowerType.INVALID",
                        thrown.getMessage());
    }
}
