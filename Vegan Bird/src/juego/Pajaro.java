package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Pajaro 
{
	private double posicionX;
	private double posicionY;
	private double diametro;
	private Image image;
	
	public Pajaro(double x, double y, double diametro)
	{
		this.posicionX = x;
		this.posicionY = y;
		this.diametro = diametro;
		//this.direccion = direccion;
		this.image = Herramientas.cargarImagen("descarga.png");
		
	}
	public double getPosicionX() 
	{
		return posicionX;
	}
	public double getPosicionY()
	{
		return posicionY;
	}
	
	public boolean estaFuera(Entorno e) 
	{
		if (posicionY<0 || posicionY>e.alto()) 
		{
			return true;
		}
		return false;
	}
	public void dibujarPajaro(Entorno e)
	{
		//e.dibujarCirculo(x, y, diametro, Color.ORANGE);
		e.dibujarImagen(image, posicionX, posicionY, 0, 0.35);
	}
	
	public void caer() 
	{
		posicionY+=3;
	}
	
	public void salta() 
	{
		posicionY-=10;
	}
	
	public boolean chocar() {
		
		return false;
	}
	
}
