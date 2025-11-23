package ar.edu.unlam.pb2.interaccion;

import static org.junit.jupiter.api.Assertions.*;
import ar.edu.unlam.pb2.transformacion.*;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;
import ar.edu.unlam.pb2.transformacion.TransformacionPartida;
import ar.edu.unlam.pb2.criatura.*;
public class InteraccionTest {

	@Test
	public void queCompartenAfinidadGananEnergia() {
	    Interaccion inter = new InteraccionCriaturas();

	    Criatura criaturaA = new CriaturaDomesticada("Pepe", 50, AfinidadesElementales.AGUA);
	    Criatura criaturaB = new CriaturaDomesticada("Lolo", 70, AfinidadesElementales.AGUA);

	    inter.interaccionEntreCriaturas(criaturaA, criaturaB);

	    assertEquals(60, (int) criaturaA.getEnergia());
	    assertEquals(80, (int) criaturaB.getEnergia());
	}

	@Test
	public void queAfinidadesOpuestasQuedanInestables() {
	    Interaccion inter = new InteraccionCriaturas();

	    Criatura criaturaA = new CriaturaSalvaje("Wolf", 80, AfinidadesElementales.AGUA);
	    Criatura criaturaB = new CriaturaSalvaje("Fox", 90, AfinidadesElementales.FUEGO);

	    inter.interaccionEntreCriaturas(criaturaA, criaturaB);

	    assertTrue(criaturaA.getInestable());
	    assertTrue(criaturaB.getInestable());
	}

	@Test
	public void queDomesticadaPermaneceEstableAunqueAfinidadSeaOpuesta() {
	    Interaccion inter = new InteraccionCriaturas();

	    Criatura criaturaA = new CriaturaDomesticada("Luna", 60, AfinidadesElementales.AGUA);
	    Criatura criaturaB = new CriaturaSalvaje("Pyro", 90, AfinidadesElementales.FUEGO);

	    inter.interaccionEntreCriaturas(criaturaA, criaturaB);

	    assertFalse(criaturaA.getInestable());   
	    assertTrue(criaturaB.getInestable());    
	}

	@Test
	public void queCriaturaAncestralAumentaSuEnergiaYLaOtraPierde() {
	    Interaccion interaccion = new InteraccionCriaturas();

	    Criatura ancestral = new CriaturaAncestral("Anc", 100, AfinidadesElementales.FUEGO);
	    Criatura criatura = new CriaturaDomesticada("Dom", 120, AfinidadesElementales.AGUA);

	    interaccion.interaccionEntreCriaturas(ancestral, criatura);

	    assertEquals(120, (int) ancestral.getEnergia());   
	    assertEquals(105, (int) criatura.getEnergia());    
	}

	@Test
	public void queCriaturaAncestralSegundaAumentaEnergiaYLaOtraPierde() {
	    Interaccion inter = new InteraccionCriaturas();

	    Criatura criatura = new CriaturaDomesticada("Dom", 100, AfinidadesElementales.AIRE);
	    Criatura ancestral = new CriaturaAncestral("Anc", 150, AfinidadesElementales.TIERRA);

	    inter.interaccionEntreCriaturas(criatura, ancestral);

	    assertEquals(85, (int) criatura.getEnergia());   
	    assertEquals(170, (int) ancestral.getEnergia()); 
	}
	
	@Test
	public void queReviertaAfinidadTemporalCorrectamente() {
	    Criatura criaturaA = new CriaturaDomesticada("Domi", 120, AfinidadesElementales.FUEGO);
	    Transformacion transformacion = new TransformacionAscensoViento(new TransformacionPartida());

	    transformacion.aplicarTransformacion(criaturaA);

	    assertEquals(AfinidadesElementales.AIRE, criaturaA.getElemento());
	    assertTrue(criaturaA.getTransformado());

	    TransformacionAscensoViento tv = (TransformacionAscensoViento) transformacion;
	    tv.revertirAfinidadTemporal(criaturaA);

	    assertEquals(AfinidadesElementales.FUEGO, criaturaA.getElemento());
	}


}






























