package com.wit.ctw.notify;

public class NotifyMain {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread product = new Thread(new ProductThread(storage));
        product.setName("product");
        product.start();
        Thread consume = new Thread(new ConsumeThread(storage));
        consume.setName("consume");
        consume.start();
    }
}
