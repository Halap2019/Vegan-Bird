package juego;


import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import javafx.scene.paint.Color;

public class Juego extends InterfaceJuego 
{
	
	//variables y métodos propios de cada grupo
	private Entorno entorno;
	private Pajaro pajaro;
	private Alimento alimento;
	private Tubo tubo;
	private Tubo tubo2;
	private Vegibean rayovegano;
	private Image gameover;
	//...
	
	public Juego() 
	{
		
		entorno = new Entorno(this, "Vegan Bird - grupo 11 - v1", 800, 600);
		
		
		//inicializar lo que haga falta para el juego
		pajaro = new Pajaro (entorno.ancho()/4, entorno.alto()/2,30);
		alimento = new Alimento (750, 250, 20);
		tubo = new Tubo (750,0,60,150,34.5577);
		tubo2 = new Tubo (750,600,60,500,0);
		rayovegano = new Vegibean (pajaro.getPosicionX(),pajaro.getPosicionY(),15,30,0);
		//rayovegano = new Vegibean();
		
		
		//... 
		
		//inicia el juego
		entorno.iniciar();
	}

	public void tick() 
	{
		// aqui va el escenario
		
		pajaro.dibujarPajaro (entorno);
		pajaro.caer();
		
		alimento.dibujarAlimento (entorno);
		alimento.Avanzar();
		
		tubo.dibujarTubo(entorno);
		tubo.desplazarTubo();
		
		tubo2.dibujarTubo(entorno);
		tubo2.desplazarTubo();
		
		//procesamiento de un instante de tiempo
		if (entorno.estaPresionada(entorno.TECLA_ESPACIO))
		{
			pajaro.salta();
		}
		 
		if (entorno.estaPresionada(entorno.TECLA_ENTER)) 
		{
			rayovegano.dibujarRayo(entorno);
			rayovegano.desplazar();
		}
		
		if (pajaro.estaFuera(entorno) == true) 
		{
			gameover = Herramientas.cargarImagen("game over.jpg");
			//completar con una imagen de game over random(¡no la del mario!)....
		}
		
		//if (rayovegano.desplazar()) {
			
		//}
		//...
				
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}

}
