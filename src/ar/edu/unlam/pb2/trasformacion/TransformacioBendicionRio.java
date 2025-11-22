package ar.edu.unlam.pb2.trasformacion;

import ar.edu.unlam.pb2.criatura.Criatura;

public class TransformacioBendicionRio extends TransformacionDecorador {

	public TransformacioBendicionRio(Transformacion otro) {
		super(otro);
	}
	
	@Override
    public void aplicarTransformacion(Criatura criatura) {
        super.aplicarTransformacion(criatura);
        
        Integer energiaModificada = criatura.getEnergia() * 2;
        if(energiaModificada > 180) {
        	energiaModificada = 180;
        	criatura.setEnergia(energiaModificada);
        }
    }

}
