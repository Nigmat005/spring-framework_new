package com.Amazon.utility;

import com.google.j2objc.annotations.Property;
import org.apache.hc.core5.reactor.Command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    // Before we create Configuration reader, we need to have configuration.properties file(U need to read from here)
// what do we use to read or extract data -> Properties we need to create in stance of Properties
   private static Properties properties = new Properties();
//     We can use  properties.load()method to get data from configuration. properties file
//    We need to create a path that takes data inbound (Input)

    static {
        try {
            FileInputStream file =new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        }
        catch(IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public static String Configuration_reader(String key){
       return properties.getProperty(key);
    }









    public static void main(String[] args) {
        System.out.println(System.getenv());
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.runtime.version"));
//       Check
        System.out.println(Configuration_reader("StringName"));
    }

}
