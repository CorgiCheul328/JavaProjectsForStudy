package com.hzlx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description:
 * 读取properties配置文件
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/9 14:23
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class PropertiesUtil {
    private static Properties properties;

    private PropertiesUtil() {
    }

    //使用静态代码块创建对象（单例模式的实现方式）
    static {
        properties = new Properties();
    }

    /**
     * 把配置文件读取到程序当中
     *
     * @param fileName 配置文件的名字(只需要写名字即可)
     */
    public static void load(String fileName) {
        //把配置文件转成一个输入流
        InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName + ".properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            System.out.println("加载配置文件异常");
            e.printStackTrace();
        }
    }

    /**
     * 根据配置文件中的key获取指定的值
     * @param key
     * @return
     */
    public static String getValue(String key) {
        return properties.get(key).toString();
    }
}
