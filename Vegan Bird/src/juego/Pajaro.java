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
	private Tubo tubo;
	private boolean choco;
	
	public Pajaro(double x, double y, double diametro)
	{
		this.posicionX = x;
		this.posicionY = y;
		this.diametro = diametro;
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
	// cree la funcion de chocar.... igual hay que tener ojo con este que esta incompleto
	public boolean chocar() 
	{
		
		if (posicionX == tubo.getPosicionX()|| posicionY == tubo.getPosicionY())
		{
			return true;
		}
		return false;
	}
	//...
}
