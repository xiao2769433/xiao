package com.model;

/**
 * @Description
 * @Author huangxiao
 * @Date 2022-09-01
 */
public class Apple {

    private Integer num;

    private String color;

    public Apple() {
    }

    public Apple(Integer num) {
        this.num = num;
    }

    public Apple(String color) {
        this.num = num;
    }

    public Apple(Integer num, String color) {
        this.num = num;
        this.color = color;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
