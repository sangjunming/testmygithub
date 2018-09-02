package com.yuanbao.park.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author: CrazyZhou
 * @description: 字符串编码处理工具类
 * @date: 2018-06-28 10:20
 * @param:
 */
public class MyTranCharset {
    private static final String PRE_FIX_UTF = "&#x";
    private static final String POS_FIX_UTF = ";";

    public MyTranCharset() {
    }

    public static String XmlFormalize(String sTemp) {
        StringBuffer sb = new StringBuffer();
        if (sTemp != null && !sTemp.equals("")) {
            String s = TranEncodeTOGB(sTemp);

            for(int i = 0; i < s.length(); ++i) {
                char cChar = s.charAt(i);
                if (isGB2312(cChar)) {
                    sb.append("&#x");
                    sb.append(Integer.toHexString(cChar));
                    sb.append(";");
                } else {
                    switch(cChar) {
                        case ' ':
                            sb.append("&#32;");
                            break;
                        case '"':
                            sb.append("&quot;");
                            break;
                        case '&':
                            sb.append("&amp;");
                            break;
                        case '<':
                            sb.append("&lt;");
                            break;
                        case '>':
                            sb.append("&gt;");
                            break;
                        default:
                            sb.append(cChar);
                    }
                }
            }

            return sb.toString();
        } else {
            return "";
        }
    }

    public static String TranEncodeTOGB(String str) {
        try {
            String strEncode = getEncoding(str);
            String temp = new String(str.getBytes(strEncode), "GB2312");
            return temp;
        } catch (IOException var3) {
            return null;
        }
    }

    public static boolean isGB2312(char c) {
        Character ch = new Character(c);
        String sCh = ch.toString();

        try {
            byte[] bb = sCh.getBytes("gb2312");
            return bb.length > 1;
        } catch (UnsupportedEncodingException var4) {
            return false;
        }
    }

    public static String getEncoding(String str) {
        String encode = "GB2312";

        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception var6) {
            ;
        }

        encode = "ISO-8859-1";

        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception var5) {
            ;
        }

        encode = "UTF-8";

        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception var4) {
            ;
        }

        encode = "GBK";

        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception var3) {
            ;
        }

        return "";
    }
}
