package juego;


import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

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
	private Vegibean rayovegano;
	
	private Tubo[] tubos;
	
	private boolean gameOver;
	//...
	
	public Juego() 
	{
		
		entorno = new Entorno(this, "Vegan Bird - grupo 11 - v1", 800, 600);
		
		
		//inicializar lo que haga falta para el juego
		pajaro = new Pajaro (entorno.ancho()/4, entorno.alto()/2,30);
		
		//este otra parte es para crear alimentos
		alimento = new Alimento (entorno.ancho(), entorno.alto(), 20);
		
		//...
		
		rayovegano = new Vegibean (pajaro.getPosicionX(),pajaro.getPosicionY(),15,30,0);
		
		//ya esta parte es el loop que hace para crear tubos
		 
		this.tubos = new Tubo[6];
		this.tubos[0] = new Tubo(800, 40, 100, 350,34.5577);
		this.tubos[1] = new Tubo(2000, 40, 100, 500,34.5577);
		this.tubos[2] = new Tubo(5000, 40, 100, 200,34.5577);
		this.tubos[3] = new Tubo(800, 560, 100, 350,0);
		this.tubos[4] = new Tubo(2000, 560, 100, 200,0);
		this.tubos[5] = new Tubo(5000, 560, 100, 500,0);

		//...
		
		this.gameOver = false;
		
		
		//... 
		
		//inicia el juego
		entorno.iniciar();
	}

	public void tick() 
	{
		// aqui va el escenario
		
		//Se engloba el juego con un booleano de juego terminado para verificar que las condiciones de perder o ganar se cumplan.
		if(!gameOver) {
	   //se inicia dibujando al pajaro y dejandolo caer
		pajaro.dibujar(entorno);
		pajaro.caer();
		
		alimento.dibujar (entorno);
		alimento.mover();
		
		if (rayovegano != null) {
			rayovegano.dibujar(entorno);
			rayovegano.mover();
		}
		
		//se hace un foreach del ArrayList de tubos para dibujarlos, desplazarlos, reposicionarlos al final de la pantalla
		// y verificar la colicion con el pajaro.
		
		for (Tubo tub : tubos) {
			
			tub.dibujar(entorno);
			
			tub.mover();
			
			if (pasoTubo(tub)) {
				
				tub.reaparecerEnDerecha();
			}
			
			if(pajaro.chocasteConUn(tub) || pajaro.estaFuera(entorno) ) {
				gameOver= true;
			}
			
		}	
		
		//procesamiento de un instante de tiempo
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA))
		{
			pajaro.volar();
		}
		 
		if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) 
		{
			rayovegano = pajaro.disparar();
			
		}
		
		//if (rayovegano.desplazar()) {
			
		//}
		//...
		
		}
		
		if(gameOver) {
		entorno.cambiarFont("System", 100, java.awt.Color.RED);
		entorno.escribirTexto("Has Perdido!", 110, 200);
		}
				
	}
	
	//las funciones pasoTubo significa que verifica si el tubo salio de la pantalla (solo hace eso, setearlo del otro lado de la pantalla
	// se hace en el if. no es tarea de este booleano hacer eso.
	boolean pasoTubo(Tubo tubo) {

		return (tubo.perfilDerecho() < 0);
	}
	
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}

}
