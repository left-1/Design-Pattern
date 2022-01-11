package com.left.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 定义了对象之间的一对多依赖，让多个观察者同时监听某一个主题对象，当主题对象发生变化时，所有观察者都会收到通知并更新
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Task1 observer1 = new Task1();
        subject.add(observer1);
        Task2 observer2 = new Task2();
        subject.add(observer2);
        subject.notifyObserver("hello world");
        // 移除观察者
        subject.remove(observer1);
        subject.notifyObserver("hello");
    }

}

class Subject{
    // 容器
    List<Observer> observers = new ArrayList<>();
    // add
    public void add(Observer observer) {
        observers.add(observer);
    }
    // remove
    public void remove(Observer observer) {
        observers.remove(observer);
    }
    // notify
    public void notifyObserver(Object object) {
        for (Observer observer : observers) {
            observer.update(object);
        }
    }
}

interface Observer {
    void update(Object object);
}
class Task1 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("task1 received: " + object);
    }

}
class Task2 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("task2 received: " + object);
    }

}