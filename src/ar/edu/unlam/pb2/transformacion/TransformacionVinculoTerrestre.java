package ar.edu.unlam.pb2.transformacion;

import ar.edu.unlam.pb2.criatura.Criatura;

public class TransformacionVinculoTerrestre extends TransformacionDecorador {

	public TransformacionVinculoTerrestre(Transformacion otro) {
		super(otro);
	}
	
	@Override
    public void aplicarTransformacion(Criatura criatura) {
        criatura.setLimiteEnergiaTerrestre(50);
    }

}
