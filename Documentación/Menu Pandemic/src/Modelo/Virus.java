package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAM1
 */
public class Virus {
    
    // ATRIBUTOS
    
    protected String nombre;
    
    // CONSTRUCTOR
    
    	public Virus(String n) {
            this.nombre = n;
	}
        
    public String getNombre() {
        return nombre;
    }	 
    
    public void setNombre(String nombre) {
	this.nombre=nombre;
    }
        
    
    
}
