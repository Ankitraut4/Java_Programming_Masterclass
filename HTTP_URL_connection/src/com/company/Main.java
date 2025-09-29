package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {

            URL url=new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cars");
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");


            connection.setConnectTimeout(10000);//if the server does not response within 10 sec after GET method is called it will terminate

            int responseCode=connection.getResponseCode();//here connection.connect(); is not required because connection.getResponse() is intialize the connect method
            System.out.println("response code : "+responseCode);


            if ((responseCode=connection.getResponseCode())!=200){
                System.out.println("URL not Found "+responseCode);
                System.out.println(connection.getResponseMessage());
            }else {
                BufferedReader inputReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String value;
               while ((value=inputReader.readLine())!=null){
                   System.out.println(value);
                }
            }



        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println("exception  "+e.getMessage());
        }
    }
}
