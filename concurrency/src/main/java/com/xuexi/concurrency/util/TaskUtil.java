package com.xuexi.concurrency.util;

import com.xuexi.concurrency.model.Order;

import java.util.concurrent.Callable;

public class TaskUtil {
    public static Callable<Order> getOrderTask() {
        return Order::new;
    }

    public static Callable<Order> processOrderTask(Order order) {
        return Order::new;
    }

    public static Callable<Order> dispatchOrderTask(Order order) {
        return Order::new;
    }

    public static Order getOrder() {
        return new Order();
    }

    public static Order processOrder(Order order) {
        return new Order();
    }

    public static Order dispatchOrder(Order order) {
        return new Order();
    }
}
