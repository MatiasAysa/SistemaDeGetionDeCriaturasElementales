package ar.edu.unlam.pb2.interaccion;

import ar.edu.unlam.pb2.criatura.Criatura;
import ar.edu.unlam.pb2.criatura.CriaturaAncestral;
import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class InteraccionCriaturas implements Interaccion{

	@Override
	public void interaccionEntreCriaturas(Criatura a, Criatura b) {
		interaccionCompartenAfinidad(a,b);
		interaccionOpuestaAfinidad(a,b);
		interaccionAncestral(a,b);

	}
	
	private void interaccionOpuestaAfinidad(Criatura a, Criatura b) {
		if((a.getElemento() == AfinidadesElementales.AGUA && 
				b.getElemento() == AfinidadesElementales.FUEGO) ||
				(a.getElemento() == AfinidadesElementales.FUEGO && 
				b.getElemento() == AfinidadesElementales.AGUA) ||
				(a.getElemento() == AfinidadesElementales.AIRE && 
				b.getElemento() == AfinidadesElementales.TIERRA) ||
				(a.getElemento() == AfinidadesElementales.TIERRA && 
				b.getElemento() == AfinidadesElementales.AIRE)
				) {
		    a.modificarInestableCriatura(true);
		    b.modificarInestableCriatura(true);
		}
	}
	
	private void interaccionCompartenAfinidad(Criatura a, Criatura b) {
		if(a.getElemento() == b.getElemento()) {
		    a.ganarEnergia(10);
		    b.ganarEnergia(10);
		}
	}
	
	private void interaccionAncestral(Criatura a, Criatura b) {//posible para exepcion
		if(a instanceof CriaturaAncestral) {
			a.ganarEnergia(20);
			b.perderEnergia(15);
		}else if(b instanceof CriaturaAncestral) {
			b.ganarEnergia(20);
			a.perderEnergia(15);
		}
	}
	

}




