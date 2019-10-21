package juego;

import java.awt.Color;

import entorno.Entorno;


public class Vegibean 
{
	//posicion que se encuentra
	private double posX;
	private double posY;
	//altura y anchura del objeto
	private double alto;
	private double ancho;
	//angulo del objeto
	private double angulo;
	//private Alimento alimento;
	
	public Vegibean(double x, double y, double alto, double ancho, double angulo)
	{
		this.posX=x;
		this.posY=y;
		this.alto=alto;
		this.ancho=ancho;
		this.angulo=angulo;
	}
	
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(posX, posY, ancho, alto, angulo, Color.ORANGE);
	}
	
	public void mover() {
		posX+=30;
		
	}
	//hice el boolean de chocar pero tira warning
	//public static boolean chocar()
	//{
		//if (posicionX == alimento.getPosicionX() || posicionY == alimento.getPosicionY())
		//{
			//return true;
		//}
		//return false;
	//}
	
	
}
