package ar.edu.unlam.pb2.criatura;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class CriaturaTest {
/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
*/
	@Test
	public void queLaEnergiaInicialNoSeaNegativa() {
	    Criatura c = new CriaturaDomesticada("Lolo", -50, AfinidadesElementales.AGUA);
	    
	    assertEquals(Integer.valueOf(0), c.getEnergia());
	}
	
	@Test
	public void queCriaturaAncestralTengaMinimo100EnergiaDespuesDeEntrenar() {
		Criatura c = new CriaturaAncestral("Ances", 20, AfinidadesElementales.TIERRA);

	    c.entrenar();

	    assertTrue("La energía mínima de un ancestral entrenado debe ser 100",
	               c.getEnergia() >= 100);
	}
	@Test
	public void queCrearuraDomesticadaSume30AlEntrenar() {
		Criatura c = new CriaturaDomesticada("Domestica", 50, AfinidadesElementales.AIRE);

	    c.entrenar();

	    assertEquals(Integer.valueOf(80), c.getEnergia());
	}
	
	@Test
	public void queCriaturaSalvajeSePacifique() {
	    CriaturaSalvaje c = new CriaturaSalvaje("Tiger", 80, AfinidadesElementales.FUEGO);

	    assertTrue(c.getInestable()); // salvaje arranca inestable

	    c.pacificar();

	    assertFalse(c.getInestable());
	}
}
