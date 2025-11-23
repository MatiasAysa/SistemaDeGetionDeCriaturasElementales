package ar.edu.unlam.pb2.criatura;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public abstract class Criatura {
	protected String nombre;
	protected Integer energia;
	protected AfinidadesElementales elemento;
	protected Boolean inestable;
	protected Boolean transformado;
	private Integer limiteEnergiaTerrestre = 0;

	public Criatura(String nombre,Integer energia,AfinidadesElementales elemento,Boolean inestable) {
		this.nombre = nombre;
		this.energia = validarEnergiaDentroLosMargenesGenerales(energia);
		this.elemento = elemento;
		this.inestable = inestable;
	}
	
	public Integer validarEnergiaDentroLosMargenesGenerales(Integer energia) {
		if(energia > 200) {
			return energia = 200;
		}else if(energia < 0){
			return energia = 0; 
		}
		return energia;
	}
	
	public abstract void entrenar();
	public abstract void pacificar();	
	
	public void setEnergia(Integer energia) {
		if (energia < limiteEnergiaTerrestre) {
			this.energia = 50;
		}else {
			this.energia = validarEnergiaDentroLosMargenesGenerales(energia);
		}
	}
	
	public void ganarEnergia(Integer energia) {
		this.energia = validarEnergiaDentroLosMargenesGenerales(this.energia + energia);
	}
	
	public void perderEnergia(Integer energia) {
		this.energia = validarEnergiaDentroLosMargenesGenerales(this.energia - energia);
	}
	
	public String getNombre() {
		return nombre;
	}

	public Integer getEnergia() {
		return energia;
	}

	public AfinidadesElementales getElemento() {
		return elemento;
	}

	public Boolean getInestable() {
		return inestable;
	}
	
	public void modificarInestableCriatura(Boolean inestable) {
		this.inestable = inestable;
	}
	
	public void setLimiteEnergiaTerrestre(Integer limiteEnergiaTerrestre) {
		this.limiteEnergiaTerrestre = limiteEnergiaTerrestre;
	}
	
	public void setElemento(AfinidadesElementales elemento) {
		this.elemento = elemento;
	}
	
	public Boolean estaTransformado() {
		return this.transformado;
	}
	
}
