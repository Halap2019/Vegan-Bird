package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Tubo 
{
	private double posicionX;
	private double posicionY;
	private double ancho;
	private double alto;
	private double angulo;
	private Image image;
	private Image tuboSuperior1;
	
	public Tubo(double x, double y, double ancho, double alto, double angulo) 
	{
		this.posicionX = x;
		this.posicionY = y;
		this.ancho = ancho;
		this.alto = alto;
		this.angulo = angulo;
		//pude poner una imagen del tuvo de super mario
		this.image = Herramientas.cargarImagen("super mario tubo.png");
		this.tuboSuperior1 = Herramientas.cargarImagen("tuboSuperior1.png");
		//...
	}
	
	
/*	public void dibujarTubo(Entorno e)
	{
		e.dibujarImagen(this.image, this.posicionX, this.posicionY, this.angulo, 0.45);
	}
	
	void dibujarTuboSuperior1(Entorno entorno) {
		
		entorno.dibujarImagen(this.tuboSuperior1,this.posicionX, this.posicionY, this.angulo, 0.51);
	}*/
	
	void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.posicionX, this.posicionY, this.ancho, this.alto, 0, Color.GREEN);
	}
	
	double perfilIzquierdo() {
		return this.posicionX - (this.ancho / 2);
	}

	double perfilDerecho() {
		return this.posicionX+ (this.ancho / 2);
	}

	double perfilSuperior() {
		return this.posicionY - (this.alto / 2);
	}

	double perfilInferior() {
		return this.posicionY + (this.alto / 2);
	}
	
	public double getAncho() {
		return ancho;
	}


	public double getAlto() {
		return alto;
	}


	public double getAngulo() {
		return angulo;
	}


	//public void setAngulo(double angulo) {
		//this.angulo = angulo;
	//}


	


	//public void setPosicionY(double posicionY) {
		//this.posicionY = posicionY;
	//}


	public void mover()
	{
		posicionX-=2;
	}

	//cree dos getters
	public double getPosicionX() 
	{
		return posicionX;
	}
	
	public double getPosicionY()
	{
		return posicionY;
	}
	//...


	public void reaparecerEnDerecha() {
		// aca va lo del tubo
	}
}
