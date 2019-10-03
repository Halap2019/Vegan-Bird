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
	
	public Tubo(double x, double y, double ancho, double alto, double angulo) 
	{
		this.posicionX = x;
		this.posicionY = y;
		this.ancho = ancho;
		this.alto = alto;
		this.angulo = angulo;
		//pude poner una imagen del tuvo de super mario
		this.image = Herramientas.cargarImagen("super mario tubo.png");
		//...
	}
	
	
	public void dibujarTubo(Entorno e)
	{
		e.dibujarImagen(image, posicionX, posicionY, angulo, 0.45);
	}
	
	public void desplazarTubo()
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
}
