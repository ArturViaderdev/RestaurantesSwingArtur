/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arturviader.restaurantesswingartur.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alu2017363
 */
public class Memoria {
    //ArrayList<User> usuarios;
    private static Memoria instancia = new Memoria();
    private String usuario;
    private Memoria()
    {
        
    }
    
    public void createUserFolderIfNotExists()
    {
        if (!(Files.isDirectory(Paths.get("datos" + File.separator + usuario))))
        {
            try {        
                Files.createDirectories(Paths.get("datos" + File.separator + usuario));
            } catch (IOException ex) {
                
            }
        } 
    }
    
    public void createDataFolderIfNotExists()
    {
        if (!(Files.isDirectory(Paths.get("datos"))))
        {
            try {        
                Files.createDirectories(Paths.get("datos"));
            } catch (IOException ex) {
                
            }
        } 
    }
    
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public static Memoria getInstance()
    {
        return instancia;
    }
    
    /**
     * Comprueba un login leyendo el fichero directamente.
     * Si se encuentra el usuario se deja de leer el fichero sino se lee hasta el final.
     * @param usuario Nombre de usuario
     * @param password Password
     * @return Si el login es correcto
     */
    public Boolean login(String usuario, String password)
    {
        BufferedReader lector;
        File archivo = new File("datos" + File.separator + "usuarios.txt");
        String linea;
        Boolean encontrado = false;
        if(usuario.equals("admin") && password.equals("admin"))
        {
            encontrado = true;
            this.usuario = "admin";
        }
        else
        {
            try {
                lector = new BufferedReader(new FileReader(archivo));
                try
                {
                    do {
                    
                        linea = lector.readLine();
                        if (linea != null) {
                            encontrado = interpretalinealogin(linea, usuario, password);
                        }
                    } while (linea != null && !encontrado);
                } catch (IOException ex) {
                    System.out.println("Error leyendo archivo.");
                }
                finally
                {
                    try
                    {
                        lector.close();
                    }
                    catch(IOException ex)
                    {
                        
                    }    
                }
         } catch (FileNotFoundException ex) {
                //Mostrar error
         }
        }
        
         
         return encontrado;
    }
     
    private boolean interpretalinealogin(String linea, String usuario, String password) {
        String[] datos;
        datos = linea.split("\\*");
        //Divide los campos en un array de string
      
        //Crea el objeto alumno con los datos y lo añade a la lista en memoria.
        User useranade = new User(datos[0], datos[1]);
        boolean login = false;
        if(useranade.getUserName().equals(usuario))
        {
            if(useranade.getPassword().equals(password))
            {
                login = true;
                this.usuario = usuario;
            }
        }
        return login;
    }
 
    
    
}
