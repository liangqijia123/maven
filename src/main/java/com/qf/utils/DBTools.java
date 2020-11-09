package com.qf.utils;

import java.io.IOException;
import java.util.Properties;

public class DBTools {

   static {

       try {
           Properties pro = new Properties();
           pro.load(DBTools.class.getClassLoader().getResourceAsStream("db.properties"));
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
