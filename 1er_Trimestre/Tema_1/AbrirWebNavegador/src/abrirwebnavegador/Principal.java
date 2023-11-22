package abrirwebnavegador;

import java.io.*;
import java.util.*;
import java.net.*;

public class Principal {

    
    public static void main(String[] args) {
        
        try {
            // Especifica el comando del navegador y la URL que deseas abrir
            String comando = "C:\\Users\\usuario\\AppData\\Local\\Programs\\Opera GX\\launcher.exe"; // Cambia esto al navegador que desees utilizar (por ejemplo, "chrome" o "firefox")
            String urlStr = "https://www.marca.com";

            // Crea un proceso para ejecutar el comando y abrir el navegador
            ProcessBuilder builder = new ProcessBuilder(comando, urlStr);
            builder.start();

            // Crea una URL y una conexión URLConnection para obtener el HTML de la página
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();

            // Lee el contenido HTML de la página
            StringBuilder html = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;

                while ((inputLine = reader.readLine()) != null) {
                    html.append(inputLine);
                }
            }

            // Específica la ruta completa del archivo
            String rutaArchivo = "codigoHTMLWeb.txt"; // Cambia la ruta a donde desees guardar el archivo

            // Escribe el HTML en el archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                writer.write(html.toString());
            }
            
            ProcessBuilder builderArchivo = new ProcessBuilder("Notepad.exe", "codigoHTMLWeb.txt");
            builderArchivo.start();

            System.out.println("Código HTML de la página guardado en " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
