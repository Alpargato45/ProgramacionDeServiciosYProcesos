package diccionarioraehttp;

import entradadatos.EntradaDatos;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiccionarioRAEHTTP {

    public static void main(String[] args) {

        try {
            String palabra = EntradaDatos.pedirCadena("Palabra a Buscar: ");

            URL url = new URL("https://dle.rae.es/" + palabra + "?m=form");
            URLConnection conexionURL = (HttpURLConnection) url.openConnection();
            conexionURL.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 OPR/77.0.4054.254");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conexionURL.getInputStream(), "UTF-8"));
                 BufferedWriter writer = new BufferedWriter(new FileWriter("diccionario-" + palabra + ".html"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Descarga Finalizada");
        } catch (MalformedURLException ex) {
            Logger.getLogger(DiccionarioRAEHTTP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DiccionarioRAEHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}