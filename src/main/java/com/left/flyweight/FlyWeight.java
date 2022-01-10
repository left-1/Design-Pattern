package com.left.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 */
public class FlyWeight {

    public static void main(String[] args) {
        TreePoint treePoint1 = new TreePoint(1, 3, TreeFactory.getTree("x", "1"));
        TreePoint treePoint2 = new TreePoint(2, 4, TreeFactory.getTree("x", "1"));
    }

}

class TreePoint {
    private int x;
    private int y;
    private Tree tree;

    public TreePoint(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

}

class TreeFactory {
    private static Map<String, Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }

}

class Tree {

    private final String name;
    private final String data;

    public Tree(String name, String data) {
        this.name = name;
        this.data = data;
        System.out.println("create a new tree");
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

}
