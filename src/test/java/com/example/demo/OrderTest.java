package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.demo.delivery.Delivery;
import com.example.demo.flower.Item;
import com.example.demo.payment.Payment;

class OrderTest {

    private Order<Item> order;
    private List<Item> items;
    private Delivery delivery;
    private Payment payment;

    @BeforeEach
    void setUp() {
        items = new ArrayList<>();

        Item item1 = Mockito.mock(Item.class);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item1.getPrice()).thenReturn(10.0);
        Mockito.when(item2.getPrice()).thenReturn(20.0);

        items.add(item1);
        items.add(item2);

        delivery = Mockito.mock(Delivery.class);
        payment = Mockito.mock(Payment.class);

        order = new Order<>(items, delivery, payment);
    }

    @Test
    void testCalculateTotalPrice() {
        double totalPrice = order.calculateTotalPrice();
        assertEquals(30.0, totalPrice, "Total price should be the sum of item prices");
    }

    @Test
    void testAddItem() {
        Item newItem = Mockito.mock(Item.class);
        Mockito.when(newItem.getPrice()).thenReturn(15.0);

        order.addItem(newItem);

        assertEquals(3, order.getItems().size(), "Item count should be 3 after adding a new item");
        assertEquals(45.0, order.calculateTotalPrice(), "Total price should be updated after adding a new item");
    }

    @Test
    void testRemoveItem() {
        Item itemToRemove = items.get(0);

        order.removeItem(itemToRemove);

        assertEquals(1, order.getItems().size(), "Item count should be 1 after removing an item");
        assertEquals(20.0, order.calculateTotalPrice(), "Total price should be updated after removing an item");
    }

    @Test
    void testSetItems() {
        List<Item> newItems = new ArrayList<>();
        Item newItem = Mockito.mock(Item.class);
        Mockito.when(newItem.getPrice()).thenReturn(50.0);

        newItems.add(newItem);
        order.setItems(newItems);

        assertEquals(1, order.getItems().size(), "Item count should be 1 after setting new items");
        assertEquals(50.0, order.calculateTotalPrice(), "Total price should be updated after setting new items");
    }

}
