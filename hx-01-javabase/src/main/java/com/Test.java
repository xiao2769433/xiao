package com;



import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * @Description
 * @Author huangxiao
 * @Date 2022-09-01
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        ArrayList arrayList = new ArrayList();
        arrayList.add("test");
        arrayList.add(0,"test1");


        System.out.println(arrayList.toArray()[0]);
        System.out.println(arrayList.toArray()[1]);
    }
}
