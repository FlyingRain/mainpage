package com.wl.myweb.basic.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Created by wul on 2016/12/5.
 */
public class ModelToView {

    private static Logger logger = LoggerFactory.getLogger(ModelToView.class);

    public static <T> T modelToView(Object object, Class<T> returnType) {
        Field fields[] = object.getClass().getDeclaredFields();
        T temp = null;
        try {
            temp = returnType.newInstance();
        } catch (InstantiationException e) {
            logger.error("instance object failed!" + object.getClass().getName(),e);
            return null;
        } catch (IllegalAccessException e) {
            logger.error("can't access object !",e);
            return null;
        }
        Field tempFields[] = returnType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            for (int j = 0; j <tempFields.length; j++) {
                tempFields[j].setAccessible(true);
                //当声明的域和声明的类型都相同时进行赋值操作
                if(tempFields[j].getName().equals(fields[i].getName())&&(tempFields[j].getDeclaringClass()==fields[i].getDeclaringClass())){
                    try {
                        tempFields[j].set(temp,fields[i].get(object));
                        if(fields[i].getDeclaringClass()==String.class&&fields[i].get(object)==null){
                            tempFields[i].set(temp,"");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return temp;
    }

}
