
package com.mycompany.actividadresuelta46;

import java.io.*;
import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestorEmail {
    
    private Properties propiedades;
    private Session sesion;
    
    private void setPropiedadesServidorSMTP() {
        propiedades = System.getProperties();
        propiedades.put("mail.smtp.auth", true);
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port","587");
        propiedades.put("mail.smtp.starttls.enable", true);
        sesion = Session.getInstance(propiedades, null);
    }
    
    private Transport conectarServidorSMTP(String direccionEmail, String password)
                                            throws NoSuchProviderException, MessagingException {
        
        Transport t = (Transport) sesion.getTransport("smtp");
        t.connect(propiedades.getProperty("mail.smtp.host"),direccionEmail,password);
        
        return t;
    }
    
    private Message crearNucleoMensaje(String emisor, String destinatario, String asunto)
                                        throws AddressException, MessagingException {
    
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(emisor));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(asunto);
        
        return mensaje;
    }
    
    private Message crearMensajeTexto(String emisor, String destinatario, String asunto,
                                        String textoMensaje) throws MessagingException,
                                                                    AddressException,
                                                                    IOException {
        
        Message mensaje = crearNucleoMensaje(emisor,destinatario,asunto);
        mensaje.setText(textoMensaje);
        
        return mensaje;
    }
    
    
    private Message crearMensajeConAdjunto(String emisor, String destinatario, String asunto,
                                            String textoMensaje, String pathFichero)
                                            throws MessagingException, AddressException,
                                                   IOException {
        
        Message mensaje = crearNucleoMensaje(emisor,destinatario,asunto);
        // Cuerpo del mensaje
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(textoMensaje);
        // Adjunto del mensaje
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.attachFile(new File(pathFichero));
        // Composicion del mensaje (Cuerpo + Adjunto)
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);
        multipart.addBodyPart(mimeBodyPart);
        mensaje.setContent(multipart);

        return mensaje;
    }

    public void enviarMensajeTexto(String emisor, String destinatario, String asunto,
            String textoMensaje, String direccionEmail, String password) 
            throws AddressException, MessagingException, IOException {

        setPropiedadesServidorSMTP();
        Message mensaje = crearMensajeTexto(emisor, destinatario, asunto, textoMensaje);
        Transport t = conectarServidorSMTP(direccionEmail, password);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
    }

    public void enviarMensajeConAdjunto(String emisor, String destinatario, String asunto,
            String textoMensaje, String direccionEmail,
            String password, String pathFichero)
            throws AddressException, MessagingException,
            IOException {

        setPropiedadesServidorSMTP();
        Message mensaje = crearMensajeConAdjunto(emisor, destinatario, asunto, textoMensaje,
                pathFichero);
        Transport t = conectarServidorSMTP(direccionEmail, password);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
    }

    public static void main(String[] args) {

        try {

            String emailEmisor = "jorgedelcid2004@gmail.com";  // Cuenta Gmail completa de emisor
            String passwordEmisor = "ahwv vytw neif frtc";  // Codigo de "Contraseñas de aplicacion"


            for (int i = 0; i < 20; i++) {
                GestorEmail gestorEmail = new GestorEmail();
            gestorEmail.enviarMensajeTexto(emailEmisor, "caballeroscuro04@gmail.com",
                    "Moriel gitano", "Moriel Gitano", emailEmisor, passwordEmisor);
            }

//            gestorEmail.enviarMensajeConAdjunto(emailEmisor, "correobasurakawai@gmail.com",
//                    "Aviso de entrega de factura", "El importe de la factura"
//                    + " es 113,72€", emailEmisor, passwordEmisor,"Factura.pdf"
//                            + "");
            
            System.out.println("Correos enviados");

        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        } 
    }
}
