package ar.edu.unlam.pb2.criatura;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class CriaturaSalvaje extends Criatura{

	public CriaturaSalvaje(String nombre, Integer energia, AfinidadesElementales elemento, Boolean inestable) {
		super(nombre, energia, elemento, inestable);
	}

	@Override
	public void entrenar() {
		this.energia += 50;
        if (energia > 200) {
            throw new EnergiaDesbordadaException("La criatura salvaje supero los 200 puntos de energia");
        }
		
	}

	@Override
	public void pacificar() {
		this.inestable = false;
	}
}
