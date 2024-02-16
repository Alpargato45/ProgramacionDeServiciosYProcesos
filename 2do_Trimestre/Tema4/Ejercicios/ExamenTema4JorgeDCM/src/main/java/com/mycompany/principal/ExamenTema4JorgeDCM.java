package com.mycompany.principal;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamenTema4JorgeDCM {

    public static void descargarImagen(String urlImagen) throws MalformedURLException, IOException {
        URL url = new URL(urlImagen);
        HttpURLConnection conexionURL = (HttpURLConnection) url.openConnection();
        conexionURL.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 OPR/77.0.4054.254");
        try (InputStream inputStream = new BufferedInputStream(conexionURL.getInputStream()); FileOutputStream outputStream = new FileOutputStream("imagenPersonaje.jpg")) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            System.out.println("Error al descargar la imagen: " + ex.getMessage());
        }
    }

    public static void enviarCorreo(GestorEmail email, String mensaje, String asunto) throws MessagingException, AddressException, IOException {
        String emailEmisor = "jorgedelcid2004@gmail.com";
        String passwordEmisor = "ahwv vytw neif frtc";
        email.enviarMensajeConAdjunto(emailEmisor, "rvilbri995@g.educaand.es",
                "Examen T4 " + asunto, mensaje, emailEmisor, passwordEmisor, "imagenPersonaje.jpg");
    }

    public static void main(String[] args) {
        try {
            GestionJson gestion = new GestionJson("8");
            GestorEmail email = new GestorEmail();
            
            String apiResponse = gestion.llamarApi();
            
            StringBuilder st = new StringBuilder();
            st.append(gestion.obtenerPrecioProducto(apiResponse)+ "\n");
            st.append(gestion.obtenerDescripcionProducto(apiResponse));
            descargarImagen(gestion.obtenerImagenProducto(apiResponse));
            String titulo = gestion.obtenerTituloProducto(apiResponse);
            enviarCorreo(email,st.toString(),titulo);
            
        } catch (IOException | MessagingException ex) {
            Logger.getLogger(ExamenTema4JorgeDCM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
