package ejemplohttpurl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.*;



public class EjemploHTTPURL {

    public static void main(String[] args) throws MalformedURLException, IOException {
        
        URL url = new URL("http://www.google.es");
        URLConnection conexionURL = url.openConnection();
        InputStream is = conexionURL.getInputStream();
        int c;
        while ((c=is.read()) !=-1) {
            System.out.print((char) c);
        }
        is.close();
    }
    
}
