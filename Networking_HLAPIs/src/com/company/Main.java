package com.company;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
//            URI uri=new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");

           // URI uri=new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");//when we use scheme as db when converting uri to url it  throw MalformedURLException because it requred absolute path so we use scheme as http

            //converting uri to url
            //URL url= uri.toURL();
            //System.out.println("URL = "+url);

            //converting Uri to url use one base uri and relative uri
            URI baseUri=new URI("http://username:password@myNewserver.com:5000");

            URI uri1=new URI("/catalogue/phones?os=android#samsung");//this uri has relative path(relative uri)
            URI uri2=new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3=new URI("/store/locations?zip=444001");

            URI resolveUri1=baseUri.resolve(uri1);
            URI resolveUri2=baseUri.resolve(uri2);
            URI resolveUri3=baseUri.resolve(uri3);

            URL url1=resolveUri1.toURL();
            System.out.println("URL = "+url1);

            URL url2=resolveUri2.toURL();
            System.out.println("URL = "+url2);

            URL url3=resolveUri3.toURL();
            System.out.println("URL = "+url3);


            URI uri=baseUri.relativize(resolveUri2);
            System.out.println("Relative URI = "+uri);



//            System.out.println("Scheme "+uri.getScheme());
//            System.out.println("Scheme-Specific part "+uri.getSchemeSpecificPart());
//            System.out.println("Authority "+uri.getAuthority());
//            System.out.println("User-Info "+uri.getUserInfo());
//            System.out.println("Host "+uri.getHost());
//            System.out.println("Port "+uri.getPort());
//            System.out.println("Path "+uri.getPath());
//            System.out.println("Query "+uri.getQuery());
//            System.out.println("Fragment "+uri.getFragment());








        }catch (URISyntaxException e){
            System.out.println("syntax error "+e.getMessage());
        }catch (MalformedURLException e){
            System.out.println("URL malformed "+e.getMessage());
        }
    }
}
