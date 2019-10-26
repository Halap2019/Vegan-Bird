package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Alimento
{
	private Entorno entorno;
	private int X;
	private int Y;
	private double size;
	private boolean vegan;
	private Image imagen;
	
	public Alimento(int X, int Y , double tamaño) 
	{
		Random r= new Random();
		this.X=r.nextInt(800);
		this.Y=r.nextInt(600);
		this.size= tamaño;
		this.vegan=false;
		this.imagen=Herramientas.cargarImagen("descarga.png");
	}
	
	public void dibujar(Entorno e) 
	{
		e.dibujarCirculo(X, Y, size, Color.BLUE);
		
	}
	
	public double perfilIzquierdo()
	{
		return this.X-(this.size/2);
	}
	
	double perfilDerecho() {
		return this.X+(this.size/ 2);
	}
	double perfilSuperior()
	{
		return this.Y-(this.size/2);
	}
	
	double perfilInferior()
	{
		return this.Y+(this.size/2);
	}
	//...
	
	
	public void mover() 
	{
		X-=1;
		if (this.perfilDerecho()<=0){
            X=800;
        }
	}
	
	/*public boolean queAlimentoSos() {
		if ()
		return this.vegan;
	}*/
	
	/*public boolean Mutar() 
	{
		if 
		return vegan;
	}*/
}