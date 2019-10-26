package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Tubo 
{
	private Entorno entorno;
	private double X;
	private double Y;
	private double ancho;
	private double alto;
	private double angulo;
	private Image image;
	private Image tuboSuperior1;
	
	public Tubo(double x, double y, double ancho, double alto, double angulo) 
	{
		this.X = x;
		this.Y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.angulo = angulo;
		//pude poner una imagen del tuvo de super mario
		this.image = Herramientas.cargarImagen("super mario tubo.png");
		this.tuboSuperior1 = Herramientas.cargarImagen("tuboSuperior1.png");
		//...
	}
	
	
	void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.X, this.Y, this.ancho, this.alto, 0, Color.GREEN);
	}
	
	double perfilIzquierdo() {
		return this.X - (this.ancho / 2);
	}

	double perfilDerecho() {
		return this.X+ (this.ancho / 2);
	}

	double perfilSuperior() {
		return this.Y - (this.alto / 2);
	}

	double perfilInferior() {
		return this.Y + (this.alto / 2);
	}

	public void mover()
	{
		X-=2;
		 if (this.perfilDerecho()<=0){
	            X=2500;
	        }
	}
	
	
}
