/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arturviader.restaurantesswingartur;

import Code.Metodos;
import com.arturviader.restaurantesswingartur.Data.Plato;
import com.arturviader.restaurantesswingartur.Data.Restaurante;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Ventana de mostrar restaurantes
 * @author arturviadermataix
 */
public class FrmVerRestaurantes extends javax.swing.JDialog {

    ArrayList<Restaurante> restaurantes;
    int posicion = 0;
    /**
     * Creates new form FrmVerRestaurantes
     */
    public FrmVerRestaurantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Se leen los restaurantes
        restaurantes = Metodos.leeRestaurantes();
        if(restaurantes.size()>0)
        {
            posicion = 0;
        }
   
        muestraPosicion();
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(97,29);
    }

    /**
     * Vacia los campos
     */
    private void vaciaCampos()
    {
           lNombre.setText("");
           lDireccion.setText("");
           lPoblacion.setText("");
           lTelefono.setText("");
           lNumero.setText("");
           lNota.setText("");
           lMejor.setText("");
           lPeor.setText("");
           lNotaMejor.setText("");
           lNotaPeor.setText("");
    }
    
    /**
     * Muestra la posición actual y controla la visibilidad de las flechas
     */
    private void muestraPosicion()
    {
        if(restaurantes.size()>0)
        {
            if(posicion==restaurantes.size()-1)
            {
                bSiguiente.setEnabled(false);
            }
            else
            {
                bSiguiente.setEnabled(true);
            }
            
            if(posicion==0){
                bAnterior.setEnabled(false);
            }
            else
            {
                bAnterior.setEnabled(true);
            }
            
            if(posicion>=0 && posicion<restaurantes.size())
            {
                ArrayList<Plato> platos = Metodos.leePlatos();
                ArrayList<Plato> platosrestaurante = Metodos.filtraPlatosRestaurante(platos, restaurantes.get(posicion).getNombre());
                double notamedia =0;
                for(Plato elplato:platosrestaurante)
                {
                    notamedia += elplato.getNota();
                }
                if (platosrestaurante.size()>0)
                {
                    notamedia /= platosrestaurante.size();
                    Collections.sort(platosrestaurante);
               
                    lMejor.setText(platosrestaurante.get(0).getNombre());
                    lNotaMejor.setText(Integer.toString(platosrestaurante.get(0).getNota()));
                    lPeor.setText(platosrestaurante.get(platosrestaurante.size()-1).getNombre());
                    lNotaPeor.setText(Integer.toString(platosrestaurante.get(platosrestaurante.size()-1).getNota()));
                    
                }
                else
                {
                    lMejor.setText("");
                    lNotaMejor.setText("");
                    lPeor.setText("");
                    lNotaPeor.setText("");
                }
                lNota.setText(Double.toString(notamedia));
                
                lNumero.setText(Integer.toString(platos.size()));
                
                lNombre.setText(restaurantes.get(posicion).getNombre());
                lDireccion.setText(restaurantes.get(posicion).getDireccion());
                lPoblacion.setText(restaurantes.get(posicion).getPoblacion());
                lTelefono.setText(restaurantes.get(posicion).getTelefono());
            }
            else
            {
                vaciaCampos();
            }
        }
        else
        {
            bSiguiente.setEnabled(false);
            bAnterior.setEnabled(false);
            vaciaCampos();
        }
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
        lNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lDireccion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lPoblacion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lTelefono = new javax.swing.JLabel();
        bAnterior = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lNota = new javax.swing.JLabel();
        lMejor = new javax.swing.JLabel();
        lNotaMejor = new javax.swing.JLabel();
        lPeor = new javax.swing.JLabel();
        lNotaPeor = new javax.swing.JLabel();
        lNumero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre:");

        lNombre.setText("jLabel2");

        jLabel3.setText("Dirección:");

        lDireccion.setText("jLabel4");

        jLabel5.setText("Población:");

        lPoblacion.setText("jLabel6");

        jLabel7.setText("Teléfono:");

        lTelefono.setText("jLabel8");

        bAnterior.setText("<- Anterior");
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });

        bSiguiente.setText("Siguiente ->");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        bCerrar.setText("Cerrar");
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Número de platos:");

        jLabel4.setText("Nota media platos:");

        jLabel6.setText("Nombre plato mejor valorado:");

        jLabel8.setText("Nota plato mejor valorado:");

        jLabel9.setText("Nombre plato peor valorado:");

        jLabel10.setText("Nota plato peor valorado:");

        lNota.setText("jLabel11");

        lMejor.setText("jLabel12");

        lNotaMejor.setText("jLabel13");

        lPeor.setText("jLabel14");

        lNotaPeor.setText("jLabel15");

        lNumero.setText("jLabel16");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(69, 69, 69))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lPoblacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lNota, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addComponent(lMejor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lNotaMejor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lPeor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lNotaPeor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lNumero))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAnterior)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(bCerrar)
                        .addGap(54, 54, 54)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(bSiguiente)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lDireccion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPoblacion)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lTelefono))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lNota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lMejor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lNotaMejor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lPeor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lNotaPeor))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAnterior)
                    .addComponent(bSiguiente))
                .addGap(2, 2, 2)
                .addComponent(bCerrar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón de siguiente
     * @param evt 
     */
    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        posicion += 1;
        muestraPosicion();
    }//GEN-LAST:event_bSiguienteActionPerformed

    /**
     * Botón de anterior
     * @param evt 
     */
    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed
       posicion -= 1;
       muestraPosicion();
    }//GEN-LAST:event_bAnteriorActionPerformed

    /**
     * Botón de cerrar
     * @param evt 
     */
    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lDireccion;
    private javax.swing.JLabel lMejor;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lNota;
    private javax.swing.JLabel lNotaMejor;
    private javax.swing.JLabel lNotaPeor;
    private javax.swing.JLabel lNumero;
    private javax.swing.JLabel lPeor;
    private javax.swing.JLabel lPoblacion;
    private javax.swing.JLabel lTelefono;
    // End of variables declaration//GEN-END:variables
}
