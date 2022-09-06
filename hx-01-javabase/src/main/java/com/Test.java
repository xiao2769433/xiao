package com;


import com.model.Apple;

/**
 * @Description
 * @Author huangxiao
 * @Date 2022-09-01
 */
public class Test {
    public static void main(String[] args) {
        Apple apple0 = new Apple();
        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple("red");
        Apple apple3 = new Apple(2,"yellow");

        System.out.println(apple0.getColor() + " " + apple0.getNum());
        System.out.println(apple1.getColor() + " " + apple1.getNum());
        System.out.println(apple2.getColor() + " " + apple2.getNum());
        System.out.println(apple3.getColor() + " " + apple3.getNum());
    }

}
