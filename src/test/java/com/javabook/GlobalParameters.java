package com.javabook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalParameters {
    public static String URI_DEFAUL;
    public static String REQUEST_RESPONSE_MODEL;

    private Properties properties;

    public GlobalParameters(){
        properties = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("globalParameters.properties");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //Enviroment variable
        URI_DEFAUL = properties.getProperty("baseURI");
        REQUEST_RESPONSE_MODEL = properties.getProperty("requestRestResponseModel");
    }
}
