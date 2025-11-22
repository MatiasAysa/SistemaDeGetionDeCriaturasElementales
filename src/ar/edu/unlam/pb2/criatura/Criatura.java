package ar.edu.unlam.pb2.criatura;

public abstract class Criatura {
	protected String nombre;
	protected Integer nivelEnergia;
	protected AfinidadesElementales elemento;
	protected Boolean tranquilo;
	
	public Criatura(String nombre,Integer energia,AfinidadesElementales elemento,Boolean tranquilo) {
		this.nombre = nombre;
		this.nivelEnergia = energia;
		this.elemento = elemento;
		this.tranquilo = tranquilo;
	}
	
	
	
	
	
}
