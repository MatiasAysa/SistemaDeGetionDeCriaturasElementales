package ar.edu.unlam.pb2.trasformacion;

import ar.edu.unlam.pb2.criatura.Criatura;

public abstract class TransformacionDecorador implements Transformacion {
	protected Transformacion anterior;

    public TransformacionDecorador(Transformacion otra) {
        this.anterior = otra;
    }

    @Override
    public void aplicarTransformacion(Criatura criatura) {
        if (anterior != null) {
        	anterior.aplicarTransformacion(criatura);
        }
    }
}
