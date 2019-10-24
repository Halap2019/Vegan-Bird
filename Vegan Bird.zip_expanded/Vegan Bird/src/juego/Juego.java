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

	private Tubo[] tubos1;

	private Tubo[] tubos2;

	private boolean gameOver;

	//...

	public Juego() {

		
		entorno = new Entorno(this, "Vegan Bird - grupo 11 - v1", 800, 600);

		//inicializar lo que haga falta para el juego

		pajaro = new Pajaro (entorno.ancho()/4, entorno.alto()/2,30);

		//este otra parte es para crear alimentos

		alimento = new Alimento (entorno.ancho(), entorno.alto(), 20);

		//...

		rayovegano = new Vegibean (pajaro.getX(),pajaro.getY(),15,30,0);

		
		//aca estan creados los tubos de la parte de arriba
 
		this.tubos1 = new Tubo[6];

		this.tubos1[0] = new Tubo(1000, 0, 100, 350,0);
		this.tubos1[1] = new Tubo(3000, 0, 100, 500,0);
		this.tubos1[2] = new Tubo(5000, 0, 100, 200,0);
		this.tubos1[3] = new Tubo(7000, 0, 100, 350,0);
		this.tubos1[4] = new Tubo(9000, 0, 100, 200,0);
		this.tubos1[5] = new Tubo(11000,0, 100, 500,0);
		
		//...

		// aca estan creado los tubos de la parte de abajo

		this.tubos2 = new Tubo[6];

		this.tubos2[0] = new Tubo(1000, entorno.alto(), 100, 350,0);
		this.tubos2[1] = new Tubo(3000, entorno.alto(), 100, 500,0);
		this.tubos2[2] = new Tubo(5000, entorno.alto(), 100, 200,0);
		this.tubos2[3] = new Tubo(7000, entorno.alto(), 100, 350,0);
		this.tubos2[4] = new Tubo(9000, entorno.alto(), 100, 200,0);
		this.tubos2[5] = new Tubo(11000, entorno.alto(), 100, 500,0);

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

		
			tubos1[0].dibujar(entorno);
			tubos1[0].mover();

		
			tubos2[0].dibujar(entorno);
			tubos2[0].mover();


			if (rayovegano != null) {

			rayovegano.dibujar(entorno);
			rayovegano.mover();

			}


		//se hace un foreach del ArrayList de tubos para dibujarlos, desplazarlos, reposicionarlos al final de la pantalla

		// y verificar la colicion con el pajaro.

		
			int conteo=0;
			
			while(conteo<=10) {
				int acu=0;
				while(acu <= tubos1.length-1) {
					tubos1[acu].dibujar(entorno);
					tubos1[acu].mover();
				
					tubos2[acu].dibujar(entorno);
					tubos2[acu].mover();
					acu ++;
					
					
				}
				if(pajaro.chocasteConUn(tubos1[acu-1]) || pajaro.chocasteConUn(tubos2[acu-1])|| pajaro.estaFuera(entorno)) {

					gameOver= true;

				}
				conteo ++;

			}

			/*if (i<=6){

				i=0;

			}

		}*/

		//procesamiento de un instante de tiempo

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