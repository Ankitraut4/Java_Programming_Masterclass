package com.company;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApacheTest {
    public static void main(String[] args) throws IOException {
        //this alternative way
        //instead of java.net we are using Apache_HTTPClient for display/retriving the data from website

        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet request=new HttpGet("http://example.org");
        request.setHeader("User-Agent","Chrome");

        CloseableHttpResponse closeableHttpResponse=httpClient.execute(request);
        try {
          //  System.out.println("Response code "+closeableHttpResponse.getReasonPhrase().getStatusCode());

            BufferedReader inputReader=new BufferedReader(new InputStreamReader(closeableHttpResponse.getEntity().getContent()));
            String value;
            while ((value=inputReader.readLine())!=null){
                System.out.println(value);
            }
        }finally {
            try {
                closeableHttpResponse.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
     }
}
