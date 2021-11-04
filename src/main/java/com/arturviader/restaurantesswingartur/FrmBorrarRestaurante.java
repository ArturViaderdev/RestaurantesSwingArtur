/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arturviader.restaurantesswingartur;

import Code.Metodos;
import com.arturviader.restaurantesswingartur.Data.Restaurante;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Ventana de borrar restaurante
 * @author arturviadermataix
 */
public class FrmBorrarRestaurante extends javax.swing.JDialog {
    ArrayList<Restaurante> restaurantes;
    Boolean hayrestaurantes = false;
    Boolean seleccionado = false;
    /**
     * Creates new form FrmBorrarRestaurante
     */
    public FrmBorrarRestaurante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Se leen los restaurantes
        restaurantes = Metodos.leeRestaurantes();
        if(restaurantes.size()>0)
        {
            hayrestaurantes = true;
        }
        //Se añaden restaurantes a la lista
        bAceptar.setEnabled(false);
        for (Restaurante elrestaurante:restaurantes)
        {
           
            cRestaurante.addItem(elrestaurante.getNombre());
        }
        if(!hayrestaurantes)
        {
            cRestaurante.addItem("----No hay restaurantes");
        }
            
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(81,29);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cRestaurante = new javax.swing.JComboBox<>();
        bSeleccionar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Restaurante");

        bSeleccionar.setText("Seleccionar");
        bSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeleccionarActionPerformed(evt);
            }
        });

        bAceptar.setText("Borrar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(bCancelar)
                .addGap(63, 63, 63)
                .addComponent(bAceptar)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cRestaurante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSeleccionar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSeleccionar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón seleccionar
     * @param evt 
     */
    private void bSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeleccionarActionPerformed
        if(hayrestaurantes && cRestaurante.getSelectedIndex()>=0)
        {
            //Se actualiza el plato de la lista
            cRestaurante.setEnabled(false);
            bAceptar.setEnabled(true);           
            seleccionado = true;
        }
    }//GEN-LAST:event_bSeleccionarActionPerformed

    /**
     * Botón cancelar
     * @param evt 
     */
    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    /**
     * Botón aceptar
     * @param evt 
     */
    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        if(hayrestaurantes && cRestaurante.getSelectedIndex()>=0 && seleccionado)
        {
            int reply = JOptionPane.showConfirmDialog(this, "Se borrarán los platos del restaurante. ¿Estás seguro?", "Atención", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Metodos.borraPlatosCascada(restaurantes.get(cRestaurante.getSelectedIndex()).getNombre());        
                restaurantes.remove(cRestaurante.getSelectedIndex());
                Metodos.regrabaFicheroRestaurantes(restaurantes);
                this.dispose();
            }
        }
    }//GEN-LAST:event_bAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bSeleccionar;
    private javax.swing.JComboBox<String> cRestaurante;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}