package juego;

import java.awt.Color;

import entorno.Entorno;


public class Vegibean 
{
	//posicion que se encuentra
	private double posicionX;
	private double posicionY;
	//altura y anchura del objeto
	private double alto;
	private double ancho;
	//angulo del objeto
	private double angulo;
	
	public Vegibean(double x, double y, double alto, double ancho, double angulo)
	{
		this.posicionX=x;
		this.posicionY=y;
		this.alto=alto;
		this.ancho=ancho;
		this.angulo=angulo;
	}
	
	public void dibujarRayo(Entorno e) {
		e.dibujarRectangulo(posicionX, posicionY, ancho, alto, angulo, Color.ORANGE);
	}
	
	public void desplazar() {
		posicionX+=10;
		
	}
	
	//public static boolean chocar()
	//{
		
	//}
	
	
}
