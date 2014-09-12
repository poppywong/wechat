/*****************************************************************************
 * boer
 *****************************************************************************
 * VerifyController.java
 *----------------------------------------------------------------------------
 * 版权HeartArea所有，联系ding_cuiping@163.com
 *----------------------------------------------------------------------------
 * Version    Date       By            Comment
 * 1.0        2014-3-8    Frank       新建
 *****************************************************************************/
package com.eightspace.weixin.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 加密工具类
 * 
 * @author Frank
 * @date 2014-3-5
 * @since 1.0
 */
public class EncryptUtil {

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f' };



    /**
     * 把一个字符串按照指定的加密协议编码
     * 
     * @param algorithm
     * @param str
     * @return String
     */
    public static String encode(String algorithm, String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    /**
     * 
     * 将密文格式化
     * 
     * @author Frank
     * @date 2014-3-8
     * @param bytes
     * @return
     * @since 1.0
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }



    // 这段代码是丁哥写的测试用的吖╮(╯▽╰)╭
    public static void main(String[] args) {
        System.out.println(encode("sha1", "154456547814512343sfqwertsdfj12345"));
        String[] stra = new String[] { "acd", "bd", "aaaadf" };
        Arrays.sort(stra);
        System.out.println(Arrays.toString(stra));
    }
}
