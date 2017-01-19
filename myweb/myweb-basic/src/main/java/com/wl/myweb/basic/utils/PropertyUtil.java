package com.wl.myweb.basic.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wul on 1/19/17.
 */
public class PropertyUtil {

    private static  ConcurrentHashMap<String,Properties> map = new ConcurrentHashMap<>();

    public void init(List<String> modules){
        modules.forEach(module->{
            Properties properties = new Properties();
            try {
                //获取程序运行的当前目录
                String dir = System.getProperty("user.dir");
                InputStream inputStream = new FileInputStream(dir + "/conf/" + module +"/" + module + ".properties");
                properties.load(inputStream);
                map.put(module,properties);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }



    /**
     * 获取配置文件内容
     * @param moduleName
     * @param propertyName
     * @return
     */
    public static  String getProperty(String moduleName,String propertyName){
        Properties moduleProperties = map.get(moduleName);
        if(moduleProperties==null){
            return null;
        }
        return moduleProperties.get(propertyName).toString();


    }
}
