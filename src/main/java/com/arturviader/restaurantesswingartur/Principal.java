/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arturviader.restaurantesswingartur;

import com.arturviader.restaurantesswingartur.Data.Memoria;
import javax.swing.JFrame;

/**
 * Clase principal
 * @author alu2017363
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Memoria.getInstance().createDataFolderIfNotExists();
        FrmIniciaSesion frmlogin;
        frmlogin = new FrmIniciaSesion(null,true);
        frmlogin.setLocationRelativeTo(null);
        frmlogin.setVisible(true);
    }
    
}
