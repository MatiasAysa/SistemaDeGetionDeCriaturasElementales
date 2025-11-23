package ar.edu.unlam.pb2.criatura;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class CriaturaDomesticada extends Criatura {

	public CriaturaDomesticada(String nombre, Integer energia, AfinidadesElementales elemento) {
		super(nombre, energia, elemento, false);
	}

	@Override
	public void entrenar() {
		this.energia += 30;
	}

	@Override
	public void pacificar() {
	}
	
	@Override
	public void modificarInestableCriatura(Boolean inestable) {
		this.inestable = false;
	}

}
