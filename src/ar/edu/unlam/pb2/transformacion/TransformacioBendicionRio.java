package ar.edu.unlam.pb2.transformacion;

import ar.edu.unlam.pb2.criatura.Criatura;

public class TransformacioBendicionRio extends TransformacionDecorador {

	public TransformacioBendicionRio(Transformacion otro) {
		super(otro);
	}
	
	@Override
    public void aplicarTransformacion(Criatura criatura) {
        criatura.setTransformado(true);
        Integer energiaModificada = criatura.getEnergia() * 2;
        if(energiaModificada > 180) {
        	energiaModificada = 180;
        	criatura.setEnergia(energiaModificada);
        	return;
        }
    	criatura.setEnergia(energiaModificada);
    }

}
