package Modelo;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAM1
 */
public class Ciudad {
    
    // ATRIBUTOS
    
    protected String nombre;
    protected int tipo;
    
    protected int verde;
    protected int azul;
    protected int rojo;
    protected int morado;
    protected int brotes;
    protected int numColin;
    
    protected String[] colindantes;
    protected int[] coordenadas ;
    
    // CONSTRUCTOR
    
    	public Ciudad() {
            this.nombre = "";
            this.tipo = 0;
            this.verde = 0;
            this.azul = 0;
            this.rojo = 0;
            this.morado = 0;
            
	}
    
    	public Ciudad(String n, int t, int v, int a, int r, int m, String[] c, int[] coo, int num) {
            coordenadas= new int[2];
            this.nombre = n;
            this.tipo = t;
            this.verde = v;
            this.azul = a;
            this.rojo = r;
            this.morado = m;
            this.colindantes = c;
            this.coordenadas = coo;
            this.numColin = num;
            
	}
        
        
    // GETTERS AND SETTERS
        
        public String getNombre() {
		return nombre;
	}	 
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
        
        public int getTipo() {
            return tipo;
	}	 
	public void setTipo(int t) {
            this.tipo = t;
	}
        
        public int getVerde() {
		return verde;
	}	 
	public void setVerde(int v) {
		this.verde=v;
	}
        
        public int getAzul() {
		return azul;
	}	 
	public void setAzul(int a) {
		this.azul=a;
	}
        
        public int getRojo() {
		return rojo;
	}	 
	public void setRojo(int r) {
		this.rojo=r;
	}
        
        public int getMorado() {
		return morado;
	}	 
	public void setMorado(int m) {
		this.morado=m;
	}
        
        public int[] getCoordenadas() {
		return coordenadas;
	}	 
	public void setCoordenadas(int[] coo) {
		this.coordenadas = coo;
	}
        
        public String getColindantes(int posicion) {
		return colindantes[posicion];
	}	 
	public void setColindantes(String[] co) {
		this.colindantes = co;
	}
        
        public int getNumColin() {
		return numColin;
	}	 
	public void setNumColin(int n) {
		this.numColin=n;
	}
        
        // CREAR CIUDAD
        
    
}
