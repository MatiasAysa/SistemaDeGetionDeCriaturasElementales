package ar.edu.unlam.pb2.criatura;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public abstract class Criatura {
	protected String nombre;
	protected Integer energia;
	protected AfinidadesElementales elemento;
	protected Boolean inestable;
	
	public Criatura(String nombre,Integer energia,AfinidadesElementales elemento,Boolean inestable) {
		this.nombre = nombre;
		this.energia = otorgarNivelEnergia(energia);
		this.elemento = elemento;
		this.inestable = inestable;
	}
	
	private Integer otorgarNivelEnergia(Integer energia) {
		if(energia > 200) {
			return energia = 200;
		}else if(energia < 0){
			return energia = 0; 
		}
		return energia;
	}
	
	public abstract void entrenar();
	public abstract void pacificar();	
	
	public String getNombre() {
		return nombre;
	}

	public Integer getNivelEnergia() {
		return energia;
	}

	public AfinidadesElementales getElemento() {
		return elemento;
	}

	public Boolean getInestable() {
		return inestable;
	}
	
	
}
