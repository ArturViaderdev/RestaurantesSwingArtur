/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arturviader.restaurantesswingartur.Data;

import java.util.Date;

/**
 *
 * @author arturviadermataix
 */
public class Plato implements Comparable<Plato> {
    private String nombre;
    private String restaurante;
    private int tipo;
    private int precio;
    private int nota;
    private Date fecha;
    
    public Plato(String nombre, String restaurante, int tipo, int precio, int nota, Date fecha)
    {
        this.nombre = nombre;
        this.restaurante = restaurante;
        this.tipo = tipo;
        this.precio = precio;
        this.nota = nota;
        this.fecha = fecha;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setRestaurante(String restaurante)
    {
        this.restaurante = restaurante;
    }
    
    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }
    
    public void setPrecio(int precio)
    {
        this.precio = precio;
    }
    
    public void setNota(int nota)
    {
        this.nota = nota;
    }
    
   public void setFecha(Date fecha)
   {
       this.fecha = fecha;
   }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getRestaurante()
    {
        return restaurante;
    }
    
    public int getTipo()
    {
        return tipo;
    }
    
    public int getPrecio()
    {
        return precio;
    }
    
    public int getNota()
    {
        return nota;
    }
    
    public Date getFecha()
    {
        return fecha;
    }

    @Override
    public int compareTo(Plato o) {
        return o.getNota() - this.getNota();
    }
}
