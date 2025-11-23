package ar.edu.unlam.pb2.transformacion;

import ar.edu.unlam.pb2.criatura.Criatura;
import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class TransformacionAscensoViento extends TransformacionDecorador {
	private AfinidadesElementales guardarAfinidad;
	
	public TransformacionAscensoViento(Transformacion otro) {
		super(otro);
	}
	
	@Override
    public void aplicarTransformacion(Criatura criatura) {
		guardarAfinidad = criatura.getElemento();
        criatura.setElemento(AfinidadesElementales.AIRE);
        criatura.setTransformado(true);
        
    }
	
	public void revertirAfinidadTemporal(Criatura criatura) {
        criatura.setElemento(guardarAfinidad);
	}

}
