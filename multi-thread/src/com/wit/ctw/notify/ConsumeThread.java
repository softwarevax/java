package com.wit.ctw.notify;

/**
 * @author caotingwang
 * @description 消费者线程
 * @project multi-thread
 * @classname ConsumeThread
 * @date 2019/10/15 15:15
 */
public class ConsumeThread implements Runnable {

    private Storage storage;

    public ConsumeThread(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (true) {
                storage.consume();
                Thread.sleep(Math.round(Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
