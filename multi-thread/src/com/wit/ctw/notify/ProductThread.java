package com.wit.ctw.notify;

/**
 * @author caotingwang
 * @description 生产者线程
 * @project multi-thread
 * @classname ProductThread
 * @date 2019/10/15 15:15
 */
public class ProductThread implements Runnable {

    Storage storage;

    public ProductThread(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (true) {
                storage.product();
                Thread.sleep(Math.round(Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
