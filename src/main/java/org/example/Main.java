package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        AllOne allOne = new AllOne();
        allOne.increment("hello");
        allOne.increment("world");
        allOne.increment("hello");
        allOne.decrement("world");
        allOne.increment("leet");
        System.out.println(allOne.getMax());


        allOne.decrement("hello");
        allOne.decrement("hello");
        allOne.decrement("hello");
        System.out.println(allOne.getMax());

      //  System.out.printf(allOne.getMaxx().get());
        }
    }
