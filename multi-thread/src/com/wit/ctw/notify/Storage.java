package com.wit.ctw.notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caotingwang
 * @description 库存
 * @project multi-thread
 * @classname Storage
 * @date 2019/10/15 15:17
 */
public class Storage implements IAction {

    private final static int MAX_SIZE = 10;

    private List<String> apples;

    {
        apples = new ArrayList<>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
            apples.add("apple" + i);
        }
    }

    /**
     * 消费者
     * @return 返回消费的apple
     */
    @Override
    public String consume() {
        synchronized (apples) { //同一时间，只能有一个线程在消费
            if (apples.size() == 0) { //如果没有库存了，则禁止消费。并一直等待，等待生产者告知有库存时，才允许消费
                try {
                    apples.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int idx = apples.size() - 1;
            String apple = apples.get(idx);
            apples.remove(idx);
            apples.notifyAll(); //唤醒操作，告知消费者，仓库有剩余容量了，可以再生产一些
            System.out.println("消费apple = " + apple);
            return apple;
        }
    }

    /**
     * 生产者
     * @return 返回生产的apple
     */
    @Override
    public String product() {
        synchronized(apples) {
            if (apples.size() == MAX_SIZE) {   //如果库存放不下了，则停止生产。直到消费者告知仓库还能放下apple
                try {
                    apples.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int size = apples.size();
            String apple = "apple" + size;
            apples.add(apple);
            apples.notifyAll();  // 唤醒操作，告知消费者，仓库有apple，可以消费了
            System.out.println("生产apple = " + apple);
            return apple;
        }
    }
}
