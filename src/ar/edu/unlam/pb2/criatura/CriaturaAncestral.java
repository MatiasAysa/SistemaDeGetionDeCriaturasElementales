package ar.edu.unlam.pb2.criatura;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class CriaturaAncestral extends Criatura{


	public CriaturaAncestral(String nombre, Integer energia, AfinidadesElementales elemento) {
		super(nombre, energia, elemento, false);
	}

	@Override
	public void entrenar() {
		this.energia += 10;
		
		if (energia < 100) {
			energia = 100;
		}
	}

	@Override
	public void pacificar() {}

}
