package juego;

import java.awt.Color;

import entorno.Entorno;


public class Vegibean 
{
	//posicion que se encuentra
	private double X;
	private double Y;
	//altura y anchura del objeto
	private double alto;
	private double ancho;
	//angulo del objeto
	private double angulo;
	//private Alimento alimento;
	
	public Vegibean(double x, double y, double alto, double ancho, double angulo)
	{
		this.X=x;
		this.Y=y;
		this.alto=alto;
		this.ancho=ancho;
		this.angulo=angulo;
	}
	
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(X, Y, ancho, alto, angulo, Color.ORANGE);
	}
	
	public void mover() {
		X+=30;
		
	}

	double perfilDerecho()
	{
		return this.X+(this.ancho/2);
	}
	
	double perfilSuperior()
	{
		return this.Y-(this.alto/2);
	}
	
	double perfilInferior()
	{
		return this.Y+(this.alto/2);
	}
	
	public boolean chocasteConUn(Alimento alimento) {
		return (this.perfilDerecho() >= alimento.perfilIzquierdo()
				&& this.perfilInferior() >= alimento.perfilSuperior()
				&& this.perfilSuperior() <= alimento.perfilInferior());
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
