package com.wit.ctw.notify;

/**
 * @author caotingwang
 * @description 消费和生产动作
 * @project multi-thread
 * @classname IAction
 * @date 2019/10/15 15:20
 */
public interface IAction {

    String consume();

    String product();
}
