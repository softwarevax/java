package com.wit.ctw;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Main.class.getClassLoader();
        Class<?> clazz = classLoader.loadClass("com.wit.ctw.Hello");
        MapleClassLoader classLoader1 = new MapleClassLoader("E:\\project\\idea\\git\\java\\class-loader\\out\\production\\class-loader\\com\\wit\\ctw");
        Class<?> clazz1 = classLoader1.createClass("com.wit.ctw.Hello");  //绕过双亲委派原则
        Class<?> clazz2 = classLoader1.loadClass("com.wit.ctw.Hello");   //使用双亲委派原则


        Hello hello = (Hello) clazz.newInstance();
        System.out.println(hello.hello("maple"));
        System.out.println(hello.add(5, 8));

        Object obj1 = clazz1.newInstance();
        Method hello1 = clazz1.getDeclaredMethod("hello", String.class);
        String msg1 = (String) hello1.invoke(obj1, "maple");
        System.out.println(msg1);

        Method add1 = clazz1.getDeclaredMethod("add", int.class, int.class);
        int result1 = (int) add1.invoke(obj1, 5, 8);
        System.out.println(result1);

        System.out.println("clazz = " + clazz.getClassLoader().getParent());
        System.out.println("clazz1 = " + clazz1.getClassLoader().getParent());
        System.out.println("clazz2 = " + clazz2.getClassLoader().getParent());
        System.out.println(clazz == clazz1);
        System.out.println(clazz == clazz2);
        System.out.println(clazz1 == clazz2);
    }
}

/**
 *
 clazz = sun.misc.Launcher$ExtClassLoader@1996cd68
 clazz1 = sun.misc.Launcher$AppClassLoader@18b4aac2
 clazz2 = sun.misc.Launcher$AppClassLoader@18b4aac2
 false
 false
 true
 */
