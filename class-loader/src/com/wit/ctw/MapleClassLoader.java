package com.wit.ctw;

import java.io.*;

/**
 * @author caotingwang
 * @description TODO
 * @project class-loader
 * @classname MapleClassLoader
 * @date 2019/10/16 17:11
 */
public class MapleClassLoader extends ClassLoader {

    private String classFilePath;

    public MapleClassLoader(String classFilePath) {
        super(null);
        this.classFilePath = classFilePath;
    }

    @Override
    public String toString() {
        return this.classFilePath;
    }

    /**
     * 绕过双亲委派逻辑，直接获取Class
     */
    public Class<?> createClass(String name) throws Exception{
        byte[] data;
        data = readClassFile(name);
        return defineClass(name,data,0,data.length);
    }

    /**
     * 读取Class文件
     */
    private byte[] readClassFile(String name) throws Exception{
        String fileName = getFileName(name);
        File file = new File(classFilePath,fileName);
        FileInputStream is = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len = 0;
        while ((len = is.read()) != -1) {
            bos.write(len);
        }
        byte[] data = bos.toByteArray();
        is.close();
        bos.close();
        return data;
    }

    /**
     * 获取要加载 的class文件名
     * @param name
     * @return
     */
    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> clazz = null;
        ClassLoader system = getSystemClassLoader();
        try {
            clazz = system.loadClass(name);
        } catch (Exception e) {
            // ignore
        }
        if (clazz != null)
            return clazz;
        clazz = findClass(name);
        return clazz;
    }

    /**
     * 双亲委派逻辑，父加载器读不到Class才会调用此方法
     * @param name
     * @return
     */
    @Override
    public Class<?> findClass(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File(name));
            int c = 0;
            while (-1 != (c = is.read())) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return this.defineClass(name, data, 0, data.length);
    }

}
