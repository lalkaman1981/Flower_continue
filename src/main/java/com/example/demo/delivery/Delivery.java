package com.example.demo.delivery;

import com.example.demo.flower.Item;

public interface Delivery {
    public String getDeliveryNotification();

    public void deliver(Item item);
}
