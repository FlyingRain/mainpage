package com.wl.myweb.basic.utils;

import java.lang.reflect.Field;

/**
 * Created by wul on 2016/12/5.
 */
public class ModelToView {

    public static <T> T modelToView(Object object, Class<T> returnType) {
        Field fields[] = object.getClass().getDeclaredFields();
        T temp = null;
        try {
            temp = returnType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
        Field tempFields[] = returnType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            for (int j = 0; j <tempFields.length; j++) {
                tempFields[j].setAccessible(true);
                if(tempFields[j].getName().equals(fields[i].getName())){
                    try {
                        tempFields[j].set(temp,fields[i].get(object));
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
