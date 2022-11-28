package com.grammar;

import java.math.BigDecimal;

/**
 * @Description
 * @Author huangxiao
 * @Date 2022-11-14
 */
public class BigDecimalLearn {
    public static void main(String[] args) {
        /**
         * 精度丢失问题
         */
        double result = 3.00 - 2.61;
        System.out.println(result);   // 0.3900000000000001

        /**
         * BigDecimal 解决了浮点数相减错误的问题，但可能会造成程序运行速度的下降，因为该类并没有很好地得到Java语言的支持。
         */
        BigDecimal num1 = new BigDecimal("3.33");
        BigDecimal num2 = new BigDecimal("1.63");
        BigDecimal num3 = num1.subtract(num2);
        System.out.println(num3);   // 1.70
        double num3Double = num3.doubleValue();
        System.out.println(num3Double); // 1.7

        /**
         * 将 浮点数 转换为整数 提升效率
         */
        double num21 = 3.33D;
        double num22 = 1.39D;
        long num23 = (long) (num21 * 100);
        long num24 = (long) (num22 * 100);
        long resultNum = num23 - num24;
        double resultNum1 = resultNum/100.0;
        System.out.println(resultNum1);
    }
}
