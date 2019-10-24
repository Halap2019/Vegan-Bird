package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
public class Pajaro 
{
	private double x;
	private double y;
	private double size;
	private Image image;
	
	public Pajaro(double x, double y, double tamano)
	{
		this.x = x;
		this.y = y;
		this.size = tamano;
		this.image = Herramientas.cargarImagen("descarga.png");
		
	}
	public double getX() 
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	
	public boolean estaFuera(Entorno e) 
	{
		if (y<0 || y>e.alto()) 
		{
			return true;
		}
		return false;
	}
	public void dibujar(Entorno e)
	{
		e.dibujarImagen(image, x, y, 0, 0.35);
	}
	
	public void caer() 
	{
		y+=3;
	}

	
	public void volar() 
	{
		y-=10;
	}
	
	double perfilIzquierdo()
	{
		return this.x-(this.size/2);
	}
	
	double perfilDerecho()
	{
		return this.x+(this.size/2);
	}
	
	double perfilSuperior()
	{
		return this.y-(this.size/2);
	}
	
	double perfilInferior()
	{
		return this.y+(this.size/2);
	}
	// cree la funcion de chocar.... igual hay que tener ojo con este que esta incompleto
	//public boolean chocar() 
	//{
		
	//	if (posicionX == tubo.getPosicionX()|| posicionY == tubo.getPosicionY())
	//	{
	//		return true;
	//	}
	//	return false;
	//}
	public boolean chocasteConUn(Tubo tubo) {
		return (this.perfilIzquierdo() <= tubo.perfilDerecho()
				&& this.perfilDerecho() >= tubo.perfilIzquierdo()
				&& this.perfilInferior() >= tubo.perfilSuperior()
				&& this.perfilSuperior() <= tubo.perfilInferior());
	}
	//...
	public Vegibean disparar() {
		return new Vegibean(x, y, 10, 10, 0);
	}
}
