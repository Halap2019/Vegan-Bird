package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.Entorno;

public class Alimento
{
	private int posicionX;
	private int posicionY;
	private double diametro;
	private boolean vegan;
	private Image image;
	
	public Alimento(int X, int Y , double diametro) 
	{
		Random r= new Random();
		this.posicionX=r.nextInt(750);
		this.posicionY=r.nextInt(550);
		this.diametro= diametro;
		//this.vegan=false;
		//this.image=herramientas.cargarImagen();
	}
	//cree dos getters
	public int getPosicionX() 
	{
		return posicionX;
	}
	
	public int getPosicionY()
	{
		return posicionY;
	}
	//...
	public void dibujar(Entorno e) 
	{
		e.dibujarCirculo(posicionX, posicionY, diametro, Color.BLUE);
	}
	
	public void mover() 
	{
		posicionX-=1;
	}
	
	
	
	//public void Mutar() 
	//{
	//	if (vegan==false&&Vegibean.chocar()==true) {
	//		vegan=true;
	//	}
	//}
}
