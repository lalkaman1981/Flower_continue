package com.example.demo.delivery;

import com.example.demo.flower.Item;

public class PostDeliveryStrategy implements Delivery {
    public String getDeliveryNotification() {
        return "Delivery with simple Post";
    }

    public void deliver(Item item) {
        System.out.println("Item was delivered");
    }
}
