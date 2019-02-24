package com.monotonic.testing.m4;

public class LeapYear {

    public static boolean isLeapYear(final int year) {
        return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
    }

    private static boolean isDivisible(final int year, final int i) {
        return year % i == 0;
    }

//    public static boolean isLeapYear(final int year) {
//        return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
//    }
//
//    private static boolean isDivisible(int value, int denominator) {
//        return value % denominator == 0;
//    }

}
