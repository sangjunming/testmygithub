package com.yuanbao.park.common.utils;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author: CrazyZhou
 * @description: 集合工具类
 * @date: created in 17:37 2018/6/25
 * @param:
 */
public class MyCollectionsUtils extends CollectionUtils {



    /**
     * 根据传入对象创建并返回一个集合列表
     * @param object 【作为集合元素的对象】
     * @return 根据集合元素对象创建的集合列表
     */
    public static List createArrayListBySingleObject(Object object){
        List list = new ArrayList();
        list.add(object);
        return list;
    }

    /**
     * 拷贝一个集合中的数据到另一个结合中
     * @param from 【待拷贝的集合】
     * @param dest 【目标集合】
     */
    public static void copyToAnotherList(List from,List dest){
        for (Object  obj : from) {
            dest.add(obj);
        }
    }

    /**
     * 安全获取集合中的第一个元素
     * @param list【待处理的集合信息】
     * @return 集合中的第一个元素
     */
    public static Object getTheFirstElementOfList(List list){
        if(isNotEmpty(list)){
            return list.get(0);
        }else{
            return null;
        }
    }

    /**
     * 按照指定的字符拼接集合为字符串
     * @param list 【待处理的集合信息】
     * @param appender 【拼接字符串】
     * @param appenderTrim 【是否去除最后一个拼接符】
     * @return
     */
    public static String changeListToStringByAppenDer(List list, String appender,boolean appenderTrim){
        StringBuffer stringBuffer = new StringBuffer();
        if(isNotEmpty(list)){
            for (Object o : list) {
                stringBuffer.append(o);
                stringBuffer.append(appender);
            }
            if(appenderTrim){
                stringBuffer.delete(stringBuffer.lastIndexOf(appender),stringBuffer.length());
            }
        }
        return stringBuffer.toString();
    }
}
