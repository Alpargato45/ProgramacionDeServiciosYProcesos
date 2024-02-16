package com.mycompany.Principal;

import jakarta.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class Pantalla extends javax.swing.JFrame {

    private static ArrayList<String> rutaFichero = new ArrayList<>();
    private GestorEmail gestor = new GestorEmail();

    public Pantalla() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        textoDestinatario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoMensaje = new javax.swing.JTextArea();
        textoAsunto = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCorreos = new javax.swing.JList<>();
        label4 = new java.awt.Label();
        btnBorrarCorreo = new java.awt.Button();
        label5 = new java.awt.Label();
        btnAñadirCorreo = new java.awt.Button();
        btnEnviarCorreo = new java.awt.Button();
        btnReset = new java.awt.Button();
        btnArchivoAdjunto = new java.awt.Button();
        label6 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaArchivos = new javax.swing.JList<>();
        btnBorrarAdjunto = new java.awt.Button();

        jPanel1.setBackground(new java.awt.Color(49, 177, 227));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        label1.setFont(new java.awt.Font("DialogInput", 1, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("CorreosJorge");

        label2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Destinatario");

        textoDestinatario.setToolTipText("Asegúrate de que el texto que introduces es un correo");

        textoMensaje.setColumns(20);
        textoMensaje.setRows(5);
        jScrollPane1.setViewportView(textoMensaje);

        label3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Asunto");

        jScrollPane2.setViewportView(listaCorreos);

        label4.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("Lista Destinatarios");

        btnBorrarCorreo.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        btnBorrarCorreo.setLabel("Borrar");
        btnBorrarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCorreoActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setText("Mensaje");

        btnAñadirCorreo.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        btnAñadirCorreo.setLabel("Añadir");
        btnAñadirCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirCorreoActionPerformed(evt);
            }
        });

        btnEnviarCorreo.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        btnEnviarCorreo.setLabel("Enviar Correo");
        btnEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        btnReset.setLabel("Resetear Todo");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnArchivoAdjunto.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        btnArchivoAdjunto.setLabel("Añadir Archivo");
        btnArchivoAdjunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoAdjuntoActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setText("Lista Archivos");

        jScrollPane3.setViewportView(listaArchivos);

        btnBorrarAdjunto.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        btnBorrarAdjunto.setLabel("Borrar");
        btnBorrarAdjunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAdjuntoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnArchivoAdjunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoAsunto)
                                    .addComponent(jScrollPane1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAñadirCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEnviarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3)
                            .addComponent(btnBorrarAdjunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAñadirCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(textoDestinatario, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textoAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnArchivoAdjunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 23, Short.MAX_VALUE)
                                .addComponent(btnEnviarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBorrarAdjunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirCorreoActionPerformed
        if (esCorreoElectronicoValido(textoDestinatario.getText())) {
            DefaultListModel<String> modeloLista = (DefaultListModel<String>) listaCorreos.getModel();
            if (!correoEstaIntroducido(textoDestinatario.getText())) {
                modeloLista.addElement(textoDestinatario.getText());
            }
        }
    }//GEN-LAST:event_btnAñadirCorreoActionPerformed

    private void btnBorrarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCorreoActionPerformed
        DefaultListModel<String> modeloLista = (DefaultListModel<String>) listaCorreos.getModel();
        int[] indicesSeleccionados = listaCorreos.getSelectedIndices();
        for (int i = 0; i < indicesSeleccionados.length; i++) {
            int indice = indicesSeleccionados[i];
            modeloLista.removeElementAt(indice);
        }
    }//GEN-LAST:event_btnBorrarCorreoActionPerformed

    private void btnArchivoAdjuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoAdjuntoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        DefaultListModel<String> modeloListaArchivos = (DefaultListModel<String>) listaArchivos.getModel();

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            rutaFichero.add(selectedFile.getAbsolutePath());
            modeloListaArchivos.addElement(obtenerNombreFichero(selectedFile.getAbsolutePath()));
        }
    }//GEN-LAST:event_btnArchivoAdjuntoActionPerformed

    private void btnBorrarAdjuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAdjuntoActionPerformed
        DefaultListModel<String> modeloListaArchivos = (DefaultListModel<String>) listaArchivos.getModel();
        int[] indicesSeleccionados = listaArchivos.getSelectedIndices();
        for (int i = 0; i < indicesSeleccionados.length; i++) {
            int indice = indicesSeleccionados[i];
            modeloListaArchivos.removeElementAt(indice);
            rutaFichero.remove(i);
        }
    }//GEN-LAST:event_btnBorrarAdjuntoActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        DefaultListModel<String> modeloLista = (DefaultListModel<String>) listaCorreos.getModel();
        DefaultListModel<String> modeloListaArchivos = (DefaultListModel<String>) listaArchivos.getModel();
        for (int i = 0; i < modeloLista.size(); i++) {
            modeloLista.removeElementAt(i);
        }
        for (int i = 0; i < modeloListaArchivos.size(); i++) {
            modeloListaArchivos.removeElementAt(i);
            rutaFichero.remove(i);
        }
        textoDestinatario.setText("");
        textoAsunto.setText("");
        textoMensaje.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoActionPerformed
        String emailEmisor = "jorgedelcid2004@gmail.com";  // Cuenta Gmail completa de emisor
        String passwordEmisor = "ahwv vytw neif frtc";  // Codigo de "Contraseñas de aplicacion"
        DefaultListModel<String> modeloLista = (DefaultListModel<String>) listaCorreos.getModel();
        try {
            if (hayArchivo()) {
                DefaultListModel<String> modeloListaArchivos = (DefaultListModel<String>) listaArchivos.getModel();
                for (int i = 0; i < modeloLista.size(); i++) {
                    gestor.enviarMensajeConAdjuntos(emailEmisor, modeloLista.elementAt(i),
                            textoAsunto.getText(), textoMensaje.getText(), emailEmisor, passwordEmisor, rutaFichero);
                    JOptionPane.showMessageDialog(this, "Correo Enviado.");
                }
            } else if (!textoMensaje.getText().isEmpty()) {
                for (int i = 0; i < modeloLista.size(); i++) {
                    gestor.enviarMensajeTexto(emailEmisor, modeloLista.elementAt(i), textoAsunto.getText(), textoMensaje.getText(), emailEmisor, passwordEmisor);
                    JOptionPane.showMessageDialog(this, "Correo Enviado.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha introducido ningún archivo o texto para enviar.");
            }
        } catch (MessagingException | IOException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarCorreoActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new Pantalla().setVisible(true);
            DefaultListModel<String> modeloLista = new DefaultListModel<>();
            DefaultListModel<String> modeloListaArchivos = new DefaultListModel<>();
            listaCorreos.setModel(modeloLista);
            listaArchivos.setModel(modeloListaArchivos);
        });
    }

    public static boolean esCorreoElectronicoValido(String texto) {
        String patronCorreoElectronico = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern patron = Pattern.compile(patronCorreoElectronico);
        Matcher matcher = patron.matcher(texto);
        return matcher.matches();
    }

    public static boolean correoEstaIntroducido(String correo) {
        DefaultListModel<String> modeloLista = (DefaultListModel<String>) listaCorreos.getModel();
        for (int i = 0; i < modeloLista.size(); i++) {
            if (modeloLista.getElementAt(i).equals(correo)) {
                return true;
            }
        }
        return false;
    }

    public static String obtenerNombreFichero(String rutaCompleta) {
        File archivo = new File(rutaCompleta);
        return archivo.getName();
    }

    public static boolean hayArchivo() {
        return !rutaFichero.isEmpty();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnArchivoAdjunto;
    private java.awt.Button btnAñadirCorreo;
    private java.awt.Button btnBorrarAdjunto;
    private java.awt.Button btnBorrarCorreo;
    private java.awt.Button btnEnviarCorreo;
    private java.awt.Button btnReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private static javax.swing.JList<String> listaArchivos;
    private static javax.swing.JList<String> listaCorreos;
    private javax.swing.JTextField textoAsunto;
    private javax.swing.JTextField textoDestinatario;
    private javax.swing.JTextArea textoMensaje;
    // End of variables declaration//GEN-END:variables
}