/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arturviader.restaurantesswingartur.Data;

/**
 *
 * @author arturviadermataix
 */
public class Restaurante {
    private String nombre;
    private String poblacion;
    private String direccion;
    private String telefono;
    
    public Restaurante(String nombre, String poblacion, String direccion, String telefono)
    {
        this.nombre= nombre;
        this.poblacion = poblacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setPoblacion(String poblacion)
    {
        this.poblacion = poblacion;
    }
        
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }
            
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getPoblacion()
    {
        return poblacion;
    }
    
    public String getDireccion()
    {
        return direccion;
    }
    
    public String getTelefono()
    {
        return telefono;
    }
}
