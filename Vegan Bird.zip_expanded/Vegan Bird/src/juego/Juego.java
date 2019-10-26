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
	//allahuk akbar
	//variables y métodos propios de cada grupo

	private Entorno entorno;

	private Pajaro pajaro;

	private Alimento alimento;

	private Vegibean rayovegano;

	private Tubo[] tubosArriba;

	private Tubo[] tubosAbajo;

	private boolean gameOver;

	private Image Fondo;
	//...

	public Juego() {

		
		entorno = new Entorno(this, "Vegan Bird - grupo 11 - v1", 800, 600);
		
		Fondo = Herramientas.cargarImagen("flappy bird escena.png");

		//inicializar lo que haga falta para el juego

		pajaro = new Pajaro (entorno.ancho()/8, entorno.alto()/2,30);

		//este otra parte es para crear alimentos

		alimento = new Alimento (entorno.ancho(), entorno.alto(), 20);

		//...

		rayovegano = new Vegibean (pajaro.getX(),pajaro.getY(),15,30,0);

		
		//aca estan creados los tubos de la parte de arriba
 
		this.tubosArriba = new Tubo[6];

		this.tubosArriba[0] = new Tubo(entorno.ancho(), 0, 100, 350,0);
		this.tubosArriba[1] = new Tubo(1000, 0, 100, 500,0);
		this.tubosArriba[2] = new Tubo(1200, 0, 100, 200,0);
		this.tubosArriba[3] = new Tubo(1400, 0, 100, 350,0);
		this.tubosArriba[4] = new Tubo(1600, 0, 100, 400,0);
		this.tubosArriba[5] = new Tubo(1800,0, 100, 300,0);
		
		//...

		// aca estan creado los tubos de la parte de abajo

		this.tubosAbajo = new Tubo[6];

		this.tubosAbajo[0] = new Tubo(entorno.ancho(), entorno.alto(), 100, 350,0);
		this.tubosAbajo[1] = new Tubo(1000, entorno.alto(), 100, 300,0);
		this.tubosAbajo[2] = new Tubo(1200, entorno.alto(), 100, 400,0);
		this.tubosAbajo[3] = new Tubo(1400, entorno.alto(), 100, 300,0);
		this.tubosAbajo[4] = new Tubo(1600, entorno.alto(), 100, 200,0);
		this.tubosAbajo[5] = new Tubo(1800, entorno.alto(), 100, 500,0);

		//...	

		this.gameOver = false;

		//...

		//inicia el juego

		entorno.iniciar();

	}


	public void tick() {

		// aqui va el escenario

		
		//Se engloba el juego con un booleano de juego terminado para verificar que las condiciones de perder o ganar se cumplan.

		if(!gameOver) {

	   	//se inicia dibujando al pajaro y dejandolo caer

			pajaro.dibujar(entorno);
			pajaro.caer();

			alimento.dibujar (entorno);
			alimento.mover();
		
			tubosArriba[0].dibujar(entorno);
			tubosArriba[0].mover();
		
			tubosAbajo[0].dibujar(entorno);
			tubosAbajo[0].mover();

			if (rayovegano != null) {
			rayovegano.dibujar(entorno);
			rayovegano.mover();
			}

			
			int acumulador=0;

			while(acumulador <= tubosArriba.length-1) {
				tubosArriba[acumulador].dibujar(entorno);
				tubosArriba[acumulador].mover();
				
				tubosAbajo[acumulador].dibujar(entorno);
				tubosAbajo[acumulador].mover();
			
				acumulador ++;
			
				
			}
			

			for (int i=0; i<tubosArriba.length; i++) {
				if(pajaro.chocasteConUn(tubosArriba[i]) || pajaro.chocasteConUn(tubosAbajo[i])|| pajaro.estaFuera(entorno)) {
					gameOver= true;
				}
			}

			if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
				pajaro.volar();
			}

			if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
				rayovegano = pajaro.disparar();
			}

		}

		if(gameOver) {
			entorno.cambiarFont("System", 100, java.awt.Color.RED);
			entorno.escribirTexto("Has Perdido!", 110, 200);
		}

}

	@SuppressWarnings("unused")
	public static void main(String[] args){
		Juego juego = new Juego();
	}
}