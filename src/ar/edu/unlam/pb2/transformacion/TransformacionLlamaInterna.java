package ar.edu.unlam.pb2.transformacion;

import ar.edu.unlam.pb2.criatura.Criatura;
import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class TransformacionLlamaInterna extends TransformacionDecorador {

	public TransformacionLlamaInterna(Transformacion otro) {
		super(otro);
	}
	
	@Override
    public void aplicarTransformacion(Criatura criatura) {
        super.aplicarTransformacion(criatura);
        criatura.setTransformado(true);
        Integer energiaModificada;
        if(criatura.getElemento() == AfinidadesElementales.FUEGO) {
        	energiaModificada = criatura.getEnergia() + 30;
        	criatura.setEnergia(criatura.validarEnergiaDentroLosMargenesGenerales(energiaModificada));
        }else {
        	criatura.modificarInestableCriatura(true);
        }
        
    }

}
