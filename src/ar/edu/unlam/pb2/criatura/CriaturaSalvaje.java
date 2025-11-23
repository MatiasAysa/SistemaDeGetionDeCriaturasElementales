package ar.edu.unlam.pb2.criatura;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class CriaturaSalvaje extends Criatura{

	public CriaturaSalvaje(String nombre, Integer energia, AfinidadesElementales elemento) {
		super(nombre, energia, elemento, true);
	}

	@Override
	public void entrenar() {
		int aumento = (int) (Math.random() * 41) + 60;
		this.energia += aumento;
        if (energia > 200) {
            throw new EnergiaDesbordadaException("La criatura salvaje supero los 200 puntos de energia");
        }
	}

	@Override
	public void pacificar() {
		this.inestable = false;
	}
}
