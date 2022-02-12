package com.vytrack.utlis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {
    private static final Properties properties= new Properties();

     static{
        try {
            FileInputStream file=new FileInputStream("configuration.properties");

            properties.load(file);
        }
        catch(IOException e){
            System.out.println(e.getCause());
            System.out.println("File cannot be found");
        }
    }


    public static String Get_Properties(String key){

        return properties.getProperty(key);
    }

}
