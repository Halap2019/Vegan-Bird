package juego;


import java.awt.Image;
import java.util.ArrayList;

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
	//private Tubo tubo;
	//private Tubo tubo2;
	private Vegibean rayovegano;
	private Image gameover;
	private Tubo tuboSuperior1;
	private Tubo tuboSuperior2;
	private Tubo tuboSuperior3;
	private Tubo tuboInferior1;
	private Tubo tuboInferior2;
	private Tubo tuboInferior3;
	private ArrayList<Tubo> tubos;
	private boolean gameOver;
	//...
	
	public Juego() 
	{
		
		entorno = new Entorno(this, "Vegan Bird - grupo 11 - v1", 800, 600);
		
		
		//inicializar lo que haga falta para el juego
		pajaro = new Pajaro (entorno.ancho()/4, entorno.alto()/2,30);
		alimento = new Alimento (750, 250, 20);
		//tubo = new Tubo (750,0,60,150,34.5577);
		//tubo2 = new Tubo (750,600,60,500,0);
		rayovegano = new Vegibean (pajaro.getPosicionX(),pajaro.getPosicionY(),15,30,0);
		this.tuboSuperior1 = new Tubo(100, 40, 100, 350,34.5577);
		this.tuboSuperior2 = new Tubo(350, 40, 100, 500,34.5577);
		this.tuboSuperior3 = new Tubo(600, 40, 100, 200,34.5577);
		this.tuboInferior1 = new Tubo(100, 560, 100, 350,0);
		this.tuboInferior2 = new Tubo(350, 560, 100, 200,0);
		this.tuboInferior3 = new Tubo(600, 560, 100, 500,0);
		this.tubos = new ArrayList<Tubo>();
		this.tubos.add(this.tuboSuperior1);
		this.tubos.add(this.tuboSuperior2);
		this.tubos.add(this.tuboSuperior3);
		this.tubos.add(this.tuboInferior1);
		this.tubos.add(this.tuboInferior2);
		this.tubos.add(this.tuboInferior3);
		this.gameOver = false;
		//rayovegano = new Vegibean();
		
		
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
		pajaro.dibujar (entorno);
		pajaro.caer();
		
		alimento.dibujar (entorno);
		alimento.Avanzar();
		
		//se hace un foreach del ArrayList de tubos para dibujarlos, desplazarlos, reposicionarlos al final de la pantalla
		// y verificar la colicion con el pajaro.
		
		for (Tubo tub : tubos) {
			
			tub.dibujar(entorno);
			
			tub.desplazarTubo();
			
			if (pasoTubo(tub)) {
				
				tub.setPosicionX(850);
			}
			
			if(colisionPajaroTubo(this.pajaro, tub)) {
				gameOver= true;
			}
			
		}	
		
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
	//verifica si el pajaro y el tubo colisionan.
	boolean colisionPajaroTubo(Pajaro pajaro, Tubo tubo) {
		return (pajaro.perfilIzquierdo() <= tubo.perfilDerecho()
				&& pajaro.perfilDerecho() >= tubo.perfilIzquierdo()
				&& pajaro.perfilInferior() >= tubo.perfilSuperior()
				&& pajaro.perfilSuperior() <= tubo.perfilInferior());
	}
	
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}

}
