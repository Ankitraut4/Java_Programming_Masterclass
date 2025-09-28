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

//            URL url=new URL("http://example.org");
//            BufferedReader inputStream=new BufferedReader(new InputStreamReader(url.openStream()));//here we are using high level API so  here connecting,opening the url  and open the socket is done by .openStream() method
//            String inputString="";
//            while (inputString!=null){
//                inputString=inputStream.readLine();
//                System.out.println(inputString);
//            }
//            inputStream.close();

            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();//openConnection() return connection instance so we can use it to read or do other operation
            //urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Map<String, List<String>> headerField=urlConnection.getHeaderFields();
            for (Map.Entry<String,List<String>> entry: headerField.entrySet()){
                String key= entry.getKey();
                List<String> values=entry.getValue();
                System.out.println("---keys---"+key);
                for (String s: values ){
                    System.out.println("value "+s);
                }
            }




//            String inputString="" ;
//            while (inputString != null) {
//                inputString = inputStream.readLine();
//                System.out.println(inputString);
//            }
//            inputStream.close();

        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println("exception  "+e.getMessage());
        }
    }
}
