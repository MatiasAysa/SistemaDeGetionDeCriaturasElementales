package ar.edu.unlam.pb2.trasformacion;

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
        
    }
	
	public void revertirAfinidadTemporal(Criatura criatura) {
        criatura.setElemento(guardarAfinidad);
	}

}
