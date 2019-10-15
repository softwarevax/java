package com.wit.ctw;

public class NativeJni {

    private static native int multiply(int a,int b);

    static{
        System.loadLibrary("NativeJni");
    }

    public static void main(String[] args) {
        System.out.println("invoke native function, 5 * 8 = " + multiply(5, 8));
    }
}
