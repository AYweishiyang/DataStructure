package com.ay.offer;

import java.util.Objects;

/**
 * @author ay
 * @create 2020-02-27 17:19
 */
public class T16 {
    public double Power(double base, int exponent) {
        if(Objects.equals(base, 0.0) && exponent < 0){
           return 0.0;
        }
        int absExponent = Math.abs(exponent);
        double result = powerWithUnsignedExponent(base, absExponent);
        if(exponent < 0){
            result = 1.0 / result;
        }
        return result;

    }
    private double powerWithUnsignedExponent(double base,int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if((exponent & 1) == 1){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        T16 t16 = new T16();
        System.out.println(t16.Power(5, -2));

    }
}
