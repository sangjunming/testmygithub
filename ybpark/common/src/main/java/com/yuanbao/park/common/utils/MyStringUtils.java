package com.yuanbao.park.common.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: CrazyZhou
 * @description: string的工具封装类
 * @date: created in 17:01 2018/6/25
 * @param:
 */
public class MyStringUtils extends StringUtils {
    private static final String CHARSET_NAME = "UTF-8";

    public MyStringUtils() {
    }

    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException var2) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            return "";
        }
    }

    public static String UnicodeToGB(String str) throws UnsupportedEncodingException {
        return isEmpty(str) ? "" : new String(str.getBytes("ISO_8859_1"), "UTF-8");
    }

    public static String getRandomChar(int length) {
        char[] chr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            buffer.append(chr[random.nextInt(36)]);
        }

        return buffer.toString();
    }

    public static String getRandomNum(int length) {
        char[] chr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            buffer.append(chr[random.nextInt(10)]);
        }

        return buffer.toString();
    }

    public static int getRandomNum(int min, int max) {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    public static String getPrimaryKey() {
        Date now = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return dateformat.format(now) + getRandomNum(3);
    }

    public static String left(String input, int count) {
        if (isEmpty(input)) {
            return "";
        } else {
            count = count > input.length() ? input.length() : count;
            return input.substring(0, count);
        }
    }

    public static String right(String input, int count) {
        if (isEmpty(input)) {
            return "";
        } else {
            count = count > input.length() ? input.length() : count;
            return input.substring(input.length() - count, input.length());
        }
    }

    public static String[] splitString(String input, String delim) {
        if (isEmpty(input)) {
            return new String[0];
        } else {
            ArrayList<String> al = new ArrayList();
            StringTokenizer stringtokenizer = new StringTokenizer(input, delim);

            while(stringtokenizer.hasMoreTokens()) {
                al.add(stringtokenizer.nextToken());
            }

            String[] result = new String[al.size()];

            for(int i = 0; i < result.length; ++i) {
                result[i] = (String)al.get(i);
            }

            return result;
        }
    }

    public String replaceNewlineToHtml(String str) {
        if (str.contains("\n")) {
            str = str.replace("\n", "<br>");
        }

        if (str.contains("\r")) {
            str = str.replace("\r", "&nbsp;");
        }

        return str;
    }

    public static String replaceSpecialCharToEscape(String str) {
        if (str.contains("<")) {
            str = str.replace("<", "&lt");
        }

        if (str.contains(">")) {
            str = str.replace(">", "&gt");
        }

        return str;
    }

    public static String addZero(String target, int length, int direction) {
        target = target == null ? "" : target;
        int targetLength = target.length();
        if (targetLength < length) {
            int temp = length - targetLength;

            for(int i = 0; i < temp; ++i) {
                if (direction == 0) {
                    target = target + "0";
                } else if (direction == 1) {
                    target = "0" + target;
                } else {
                    target = target + "0";
                }
            }
        }

        return target;
    }
}