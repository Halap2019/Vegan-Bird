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
		this.image = Herramientas.cargarImagen("tubo Flappy Bird 2.jpg");
	}
	
	
	public void dibujarTubo(Entorno e)
	{
		e.dibujarImagen(image, posicionX, posicionY, angulo, 0.45);
	}
	
	public void desplazarTubo()
	{
		posicionX-=2;
	}
}
