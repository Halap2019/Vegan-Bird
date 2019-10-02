package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;

public class Alimento
{
	private double posicionX;
	private double posicionY;
	private double diametro;
	private boolean vegan;
	private Image image;
	
	public Alimento(double x, double y, double diametro) 
	{
		this.posicionX=x;
		this.posicionY=y;
		this.diametro= diametro;
		this.vegan=false;
		//this.image=herramientas.cargarImagen();
	}
	
	public void dibujarAlimento(Entorno e) 
	{
		e.dibujarCirculo(posicionX, posicionY, diametro, Color.BLUE);
	}
	
	public void Avanzar() 
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
