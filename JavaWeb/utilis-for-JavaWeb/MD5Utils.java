package com.hzlx.utils;

import java.security.MessageDigest;

public class MD5Utils {

    /**
     * 对消息进行MD5算法的信息摘要计算
     */
    public static String encryptMD5(byte[] data) {
        try {
            // 判断数据的合法性
            if (data == null) {
                throw new RuntimeException("数据不能为NULL");
            }
            // 获取MD5算法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 加入要获取摘要的数据
            md5.update(data);
            // 获取数据的信息摘要
            byte[] resultBytes = md5.digest();
            // 将字节数组转化为16进制
            return fromBytesToHex(resultBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 对数据进行MD5消息的加密
     */
    public static String encryptMD5(String data) {
        try {
            // 判断数据的合法性
            if (data == null) {
                throw new RuntimeException("数据不能为NULL");
            }
            // 获取MD5算法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 加入要获取摘要的数据
            md5.update(data.getBytes());
            // 获取数据的信息摘要
            byte[] resultBytes = md5.digest();
            // 将字节数组转化为16进制
            return fromBytesToHex(resultBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对数据，进行MD5算法的信息摘要计算，加入了salt
     *
     * @param data 数据的字节数组
     * @param salt 加入的盐
     * @return 返回String
     */
    public static String encryptMD5AndSalt(byte[] data, Object salt) {
        try {
            // 将data和盐拼接
            String dataTemp = new String(data);
            String dataSalt = mergeDataAndSalt(dataTemp, salt);
            // 加入盐后，数据的信息摘要
            // 获取MD5算法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 加入要获取摘要的数据
            md5.update(dataSalt.getBytes());
            // 获取数据的信息摘要
            byte[] resultBytes = md5.digest();
            // 将字节数组转化为16进制
            return fromBytesToHex(resultBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 对数据，进行MD5算法的信息摘要计算，加入了salt
     *
     * @param data 数据的字符串形式
     * @param salt 加入的盐
     * @return 返回String
     */
    public static String encryptMD5AndSalt(String data, Object salt) {
        try {
            // 将data和盐拼接
            String dataSalt = mergeDataAndSalt(data, salt);
            // 加入盐后，数据的信息摘要
            // 获取MD5算法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 加入要获取摘要的数据
            md5.update(dataSalt.getBytes());
            // 获取数据的信息摘要
            byte[] resultBytes = md5.digest();
            // 将字节数组转化为16进制
            return fromBytesToHex(resultBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 用于数据和salt的拼接
     *
     * @param data 要计算数据摘要的数据
     * @param salt 加入的盐
     * @return 返回string
     */
    private static String mergeDataAndSalt(String data, Object salt) {
        if (data == null) {
            data = "";
        }

        if ((salt == null) || "".equals(salt)) {
            return data;
        } else {
            return data + "{" + salt + "}";
        }

    }

    /**
     * 将给定的字节数组，转化为16进制数据
     */
    private static String fromBytesToHex(byte[] resultBytes) {
        StringBuilder builder = new StringBuilder();
        for (byte resultByte : resultBytes) {
            if (Integer.toHexString(0xFF & resultByte).length() == 1) {
                builder.append("0").append(
                        Integer.toHexString(0xFF & resultByte));
            } else {
                builder.append(Integer.toHexString(0xFF & resultByte));
            }
        }
        return builder.toString();
    }

    /**
     * 两次MD5加密，第二次放入盐
     *
     * @param value 待加密字符串
     * @param salt  盐
     * @return 加密完成的字符串
     */
    public static String encryptMD5(String value, String salt) {
        return encryptMD5AndSalt(encryptMD5(value), salt);
    }

    //测试加密算法是否正常
    public static void main(String[] args) {
        System.out.println(encryptMD5("admin", "admin"));
    }
}




