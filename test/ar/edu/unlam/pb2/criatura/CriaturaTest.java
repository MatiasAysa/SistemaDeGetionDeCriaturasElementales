package ar.edu.unlam.pb2.criatura;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class CriaturaTest {

	@Test
	public void queLaEnergiaInicialNoSupere200() {
		Criatura criatura = new CriaturaDomesticada("Pepe", 350, AfinidadesElementales.FUEGO);
		
	    assertEquals(Integer.valueOf(200), criatura.getEnergia());
	}


	@Test
	public void queLaEnergiaInicialNoSeaNegativa() {
	    Criatura criatura = new CriaturaDomesticada("Lolo", -50, AfinidadesElementales.AGUA);
	    
	    assertEquals(Integer.valueOf(0), criatura.getEnergia());
	}
	
	@Test
	public void queCriaturaAncestralTengaMinimo100EnergiaDespuesDeEntrenar() {
		Criatura criatura = new CriaturaAncestral("Ances", 20, AfinidadesElementales.TIERRA);

	    criatura.entrenar();
	    Integer energia = criatura.getEnergia();
	    
	    assertEquals(Integer.valueOf(100), energia);
	}
	
	@Test
	public void queCrearuraDomesticadaSume30AlEntrenar() {
		Criatura criatura = new CriaturaDomesticada("Domestica", 50, AfinidadesElementales.AIRE);

		criatura.entrenar();

	    assertEquals(Integer.valueOf(80), criatura.getEnergia());
	}
	
	@Test
	public void queCriaturaSalvajeSePacifique() {
		Criatura criatura = new CriaturaSalvaje("Tiger", 80, AfinidadesElementales.FUEGO);

	    criatura.pacificar();

	    assertFalse(criatura.getInestable());
	}
	

	@Test
	public void queCriaturaSalvajeEntreneSinLanzarExcepcionCuandoNoSuperaElMaximo() {
		Criatura criatura = new CriaturaSalvaje("Wild", 50, AfinidadesElementales.AGUA);

	    criatura.entrenar();

	    assertTrue(criatura.getEnergia() > 50);
	    assertTrue(criatura.getEnergia() <= 150);
	}
	/* VERSION EN JUnit5 
	@Test
    public void queCriaturaSalvajeLanceExcepcionSiSuperaLaEnergiaMaxima() {
        assertThrows(EnergiaDesbordadaException.class, () -> {
            Criatura criatura = new CriaturaSalvaje("Wild", 180, AfinidadesElementales.AGUA);
            criatura.entrenar();
        });

    }
    
    */
	
	/*
	 En Junit4
	 @Test(expected = EnergiaDesbordadaException.class) 
	 public void queCriaturaSalvajeLanceExcepcionSiSuperaLaEnergiaMaxima() { 
	 Criatura c= new CriaturaSalvaje("Wild", 180, AfinidadesElementales.AGUA); c.entrenar();
	 }
	 */

}


















