
package com.mycompany.actividadresuelta46;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.Transport;

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
            String textoMensaje, String direccionEmail,
            String password) throws AddressException, MessagingException,
            IOException {

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
            Scanner teclado = new Scanner(System.in);
            System.out.print("Introduce dirección de correo: ");
            String emailEmisor = teclado.nextLine();   // richivilla@gmail.com
//            System.out.print("Introduce contraseña: ");
            String passwordEmisor = "yofobkiwmtucpxex";   // Recogida de la configuracion de la cuenta
            teclado.close();

            GestorEmail gestorEmail = new GestorEmail();
            gestorEmail.enviarMensajeTexto(emailEmisor, "richivilla15@hotmail.com",
                    "Aviso de entrega de factura", "El importe de la factura"
                    + " es 113,72€", emailEmisor, passwordEmisor);

            gestorEmail.enviarMensajeConAdjunto(emailEmisor, "richivilla15@hotmail.com",
                    "Aviso de entrega de factura", "El importe de la factura"
                    + " es 113,72€", emailEmisor, passwordEmisor,"Factura.pdf"
                            + "");
            
            System.out.println("Correos enviados");

        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        } 
    }
    
}
