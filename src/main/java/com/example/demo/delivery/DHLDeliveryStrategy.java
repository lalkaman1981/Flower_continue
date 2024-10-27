package com.example.demo.delivery;

import com.example.demo.flower.Item;

public class DHLDeliveryStrategy implements Delivery {
    public String getDeliveryNotification() {
        return "Delivery with DHL";
    }

    public void deliver(Item item) {
        System.out.println("Item was delivered");
    }

}
