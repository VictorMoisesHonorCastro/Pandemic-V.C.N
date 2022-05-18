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
public class Jugador {
    
    protected String posicion;
    protected String nombre;
    protected int acciones;
    protected int vacunaVerde;
    protected int vacunaAzul;
    protected int vacunaRojo;
    protected int vacunaMorado;
    
    
    
    public Jugador(String p, String n, int a, int vv, int va, int vr, int vm) {
        
        this.posicion = p;
        this.nombre = n;
        this.acciones = a;
        this.vacunaVerde = vv;
        this.vacunaAzul = va;
        this.vacunaRojo = vr;
        this.vacunaMorado = vm;
        
    }
    
        public String getPosicion() {
		return posicion;
	}	 
	public void setPosicion(String p) {
		this.posicion=p;
	}
        
        
    
}
