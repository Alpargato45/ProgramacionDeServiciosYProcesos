package com.mycompany.apppokeapi;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class PantallaBusqueda extends javax.swing.JFrame {

    private int contadorCapturas = 1;

    public PantallaBusqueda() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPokeApp = new java.awt.Label();
        label2 = new java.awt.Label();
        txtFieldNombrePokemon = new javax.swing.JTextField();
        btnResetear = new javax.swing.JButton();
        btnCaptura = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBusquedaPokemon = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imagenPokemon = new javax.swing.JLabel();
        imagenPokemon1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.lightGray);
        setResizable(false);

        txtPokeApp.setFont(new java.awt.Font("Segoe Print", 1, 48)); // NOI18N
        txtPokeApp.setText("POKEAPP");

        label2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label2.setText("Buscar Pokemon");

        txtFieldNombrePokemon.setToolTipText("Puedes probar con algunos Pokemons como pikachu, charmander, lucario, zekrom, buizel...");
        txtFieldNombrePokemon.setBorder(null);
        txtFieldNombrePokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNombrePokemonActionPerformed(evt);
            }
        });

        btnResetear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnResetear.setText("Resetear");
        btnResetear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetearActionPerformed(evt);
            }
        });

        btnCaptura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCaptura.setText("Captura de Pantalla");
        btnCaptura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaActionPerformed(evt);
            }
        });

        txtBusquedaPokemon.setColumns(20);
        txtBusquedaPokemon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBusquedaPokemon.setRows(5);
        txtBusquedaPokemon.setBorder(null);
        jScrollPane1.setViewportView(txtBusquedaPokemon);

        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Hecho Por Jorge del Cid Moreno usando PokeApi");

        imagenPokemon1.setBackground(new java.awt.Color(255, 255, 255));
        imagenPokemon1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFieldNombrePokemon, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imagenPokemon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnResetear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCaptura))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtPokeApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenPokemon)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtPokeApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imagenPokemon1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldNombrePokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnResetear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(imagenPokemon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaActionPerformed
        capturarPantalla();
    }//GEN-LAST:event_btnCapturaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            StringBuilder cadena = new StringBuilder();
            String nombrePokemon = txtFieldNombrePokemon.getText().toLowerCase();
            GestionJson gestion = new GestionJson(nombrePokemon);
            String respuestaApi = gestion.llamarApi();
            if (respuestaApi != null) {
                cadena.append("\t").append(nombrePokemon.toUpperCase()).append("\n");

                float pokemonPeso = gestion.obtenerPesoPokemon(respuestaApi) / 10;
                float pokemonAltura = gestion.obtenerAlturaPokemon(respuestaApi) / 10;
                String pokemonHabilidades = gestion.obtenerHabilidadesPokemon(respuestaApi);
                String pokemonTipos = gestion.obtenerTiposPokemon(respuestaApi);

                cadena.append("Peso: ").append(pokemonPeso).append(" kg\n");
                cadena.append("Altura: ").append(pokemonAltura).append(" m\n");
                cadena.append(pokemonHabilidades);
                cadena.append(pokemonTipos);
                String urlImagen = gestion.obtenerUrlImagenPokemon(respuestaApi);
                String tipo = gestion.obtenerPrimerTipoPokemon(respuestaApi);
                cambiarColorTipo(tipo);
                txtFieldNombrePokemon.setText("");

                if (urlImagen != null && !urlImagen.isEmpty()) {
                    ImageIcon imagenIcono = new ImageIcon(new URL(urlImagen));
                    imagenPokemon1.setIcon(imagenIcono);
                } else {
                    imagenPokemon1.setIcon(null);
                }
            } else {
                cadena.append("EL POKEMON NO EXISTE");
                imagenPokemon1.setIcon(null);
            }
            txtBusquedaPokemon.setText(cadena.toString());
        } catch (IOException ex) {
            System.err.println("Error al llamar a la API: " + ex.getMessage());
            Logger.getLogger(PantallaBusqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFieldNombrePokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombrePokemonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNombrePokemonActionPerformed

    private void btnResetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetearActionPerformed
        txtFieldNombrePokemon.setText("");
        txtBusquedaPokemon.setText("");
        imagenPokemon1.setIcon(null);
        imagenPokemon1.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        btnCaptura.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        btnResetear.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        txtBusquedaPokemon.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        txtFieldNombrePokemon.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        btnBuscar.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        txtPokeApp.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnResetearActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new PantallaBusqueda().setVisible(true);
        });
    }

    private void capturarPantalla() {
        try {
            Rectangle ventanaApp = getBounds();
            Robot robot = new Robot();
            BufferedImage capturaPantalla = robot.createScreenCapture(ventanaApp);

            String carpetaProyecto = System.getProperty("user.dir");
            File carpetaCapturas = new File(carpetaProyecto + File.separator + "capturas");
            carpetaCapturas.mkdirs();

            String nombreBaseArchivo = "captura_";
            String extensionArchivo = ".png";

            String nombreArchivo = nombreBaseArchivo + contadorCapturas + extensionArchivo;
            File outputfile = new File(carpetaCapturas, nombreArchivo);
            while (outputfile.exists()) {
                contadorCapturas++;
                nombreArchivo = nombreBaseArchivo + contadorCapturas + extensionArchivo;
                outputfile = new File(carpetaCapturas, nombreArchivo);
            }

            ImageIO.write(capturaPantalla, "png", outputfile);
            JOptionPane.showMessageDialog(this, "Captura de pantalla guardada en " + nombreArchivo);
            contadorCapturas++;
        } catch (AWTException | HeadlessException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void cambiarColorTipo(String tipo) {
        Color color = Color.WHITE;
        switch (tipo) {
            case "normal" -> {
                color = Color.GRAY;
            }
            case "fire" -> {
                color = Color.ORANGE;
            }
            case "water" -> {
                color = Color.BLUE;
            }
            case "grass" -> {
                color = Color.GREEN;
            }
            case "electric" -> {
                color = Color.YELLOW;
            }
            case "ice" -> {
                color = Color.BLUE.brighter().brighter();
            }
            case "fighting" -> {
                color = Color.RED.darker();
            }
            case "poison" -> {
                color = Color.MAGENTA.darker();
            }
            case "ground" -> {
                color = Color.ORANGE.brighter().brighter();
            }
            case "flying" -> {
                color = Color.MAGENTA.brighter().brighter();
            }
            case "psychic" -> {
                color = Color.PINK.darker();
            }
            case "bug" -> {
                color = Color.GREEN.brighter().brighter();
            }
            case "rock" -> {
                color = Color.ORANGE.darker().darker();
            }
            case "ghost" -> {
                color = Color.MAGENTA.darker().darker();
            }
            case "dragon" -> {
                color = Color.MAGENTA;
            }
            case "dark" -> {
                color = Color.BLACK.brighter();
            }
            case "steel" -> {
                color = Color.LIGHT_GRAY;
            }
            case "fairy" -> {
                color = Color.PINK;
            }
        }
        imagenPokemon1.setBorder(BorderFactory.createLineBorder(color,3));
        btnCaptura.setBorder(BorderFactory.createLineBorder(color,3));
        btnResetear.setBorder(BorderFactory.createLineBorder(color,3));
        txtBusquedaPokemon.setBorder(BorderFactory.createLineBorder(color,3));
        txtFieldNombrePokemon.setBorder(BorderFactory.createLineBorder(color,3));
        btnBuscar.setBorder(BorderFactory.createLineBorder(color,3));
        txtPokeApp.setForeground(color);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCaptura;
    private javax.swing.JButton btnResetear;
    private javax.swing.JLabel imagenPokemon;
    private javax.swing.JLabel imagenPokemon1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label2;
    private javax.swing.JTextArea txtBusquedaPokemon;
    private javax.swing.JTextField txtFieldNombrePokemon;
    private java.awt.Label txtPokeApp;
    // End of variables declaration//GEN-END:variables
}