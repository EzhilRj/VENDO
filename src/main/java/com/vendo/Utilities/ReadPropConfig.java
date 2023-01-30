package com.vendo.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropConfig {

    Properties pro;

    public ReadPropConfig() {

        File src = new File("./src/main/resources/Configuration/Vendo.properties");

        try {

            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        } catch (Exception e) {

            System.out.println("Exception is" + e.getMessage());
        }

    }

    public String GetBrowser() {

        String browser = pro.getProperty("Browser");
        return browser;

    }

    public String getapplicationURL() {

        String Url = pro.getProperty("BaseURL");
        return Url;

    }
}
