package com.mycompany.lectoremail;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.imap.IMAPFolder;


public class LectorEmail {
    
    private Session getSesionImap() {
        
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.store.protocol","imap");
        propiedades.setProperty("mail.imap.host","imap.gmail.com");
        propiedades.setProperty("mail.imap.port", "993");
        propiedades.setProperty("mail.imap.ssl.enable", "true");
        propiedades.setProperty("mail.imap.ssl.trust", "imap.gmail.com");
        
        Session sesion = Session.getDefaultInstance(propiedades);
        
        return sesion;
    }
    
    
    public void leerCarpetaInbox(String email, String password) throws Exception {
        
        String textoMensaje = "";
        Session sesion = this.getSesionImap();
        Store almacen = sesion.getStore("imaps");
        almacen.connect("imap.gmail.com",993,email,password);
        IMAPFolder inbox = (IMAPFolder) almacen.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);
        Message[] mensajes = inbox.getMessages();
        
        for (int i = 0; i < mensajes.length; i++) {
            System.out.println("\n -- CORREO " + i);
            String to = "";
            Message mensaje = mensajes[i];
            Address[] direccionesOrigen = mensaje.getFrom();
            String from = direccionesOrigen[0].toString();
            Address[] direccionesDestino = mensaje.getRecipients(RecipientType.TO);
            if (direccionesDestino != null) {
                to = direccionesDestino[0].toString();
            }
            String subject = mensaje.getSubject();
            if (mensaje.isMimeType("text/plain")) {
                textoMensaje = (String) mensaje.getContent();
            } else {
                MimeMultipart mimeMultipart = (MimeMultipart) mensaje.getContent();
                if (mimeMultipart.getBodyPart(0).isMimeType("text/plain")) {
                    textoMensaje = (String) mimeMultipart.getBodyPart(0).getContent();
                }   
            }
            System.out.printf("De %s A %s Asunto: %s Mensaje: %s\n", from, to, subject,textoMensaje);
        } 
    }

            
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Introduce direccion de correo: ");
        String email  = "richivilla@gmail.com";
//        System.out.print("Introduce contraseña: ");
        String password = "kpxxkzbvcfhudtye";    // Contraseña dada en la configuracion
        sc.close();
        try {
            new LectorEmail().leerCarpetaInbox(email, password);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
