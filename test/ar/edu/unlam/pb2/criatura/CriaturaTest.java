package ar.edu.unlam.pb2.criatura;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	public void queLaEnergiaInicialNoSupere200() {
		Criatura c = new CriaturaDomesticada("Pepe", 350, AfinidadesElementales.FUEGO);
		
	    assertEquals(Integer.valueOf(200), c.getEnergia());
	}


	@Test
	public void queLaEnergiaInicialNoSeaNegativa() {
	    Criatura c = new CriaturaDomesticada("Lolo", -50, AfinidadesElementales.AGUA);
	    
	    assertEquals(Integer.valueOf(0), c.getEnergia());
	}
	
	@Test
	public void queCriaturaAncestralTengaMinimo100EnergiaDespuesDeEntrenar() {
		Criatura c = new CriaturaAncestral("Ances", 20, AfinidadesElementales.TIERRA);

	    c.entrenar();
	    Integer energia = c.getEnergia();
	    
	    assertEquals(Integer.valueOf(100), energia);
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

	    c.pacificar();

	    assertFalse(c.getInestable());
	}
	
	/*
	 * En Junit4
	 * @Test(expected = EnergiaDesbordadaException.class) public void
	 * queCriaturaSalvajeLanceExcepcionSiSuperaLaEnergiaMaxima() { CriaturaSalvaje c
	 * = new CriaturaSalvaje("Wild", 180, AfinidadesElementales.AGUA); c.entrenar();
	 * }
	 */
	@Test
    public void queCriaturaSalvajeLanceExcepcionSiSuperaLaEnergiaMaxima() {
        assertThrows(EnergiaDesbordadaException.class, () -> {
            CriaturaSalvaje c = new CriaturaSalvaje("Wild", 180, AfinidadesElementales.AGUA);
            c.entrenar();
        });

    }

}
