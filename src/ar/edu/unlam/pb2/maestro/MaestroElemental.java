package ar.edu.unlam.pb2.maestro;

import java.util.HashMap;

import ar.edu.unlam.pb2.criatura.Criatura;
import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class MaestroElemental {
	private String nombre;
	private Integer maestria;
	private AfinidadesElementales elemento;
	private HashMap <String,Criatura> criaturas = new HashMap<>();
	
	public MaestroElemental(String nombre,Integer maestria,AfinidadesElementales elemento) {
		
	}
	
	public void agregarCriatura() {
		
	}
	
	public void entrenarCriatura() {
		// Entrenar una criatura: aumenta la energía según reglas del tipo de criatura.
	}
	
	public void pacificarCriatura() {
		// Pacificar una criatura inestable: mecanismo polimórfico. 
	}
	
	
	
	
	
}
