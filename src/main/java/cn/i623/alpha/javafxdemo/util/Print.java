package cn.i623.alpha.javafxdemo.util;


public class Print {

    public static void p(Object value) {

        System.out.println(value); // "Xiao Ming"
    }

    public static void p(String s, Object value) {
        System.out.println(s + ":[" + value + "]"); // "Xiao Ming"
    }
}
