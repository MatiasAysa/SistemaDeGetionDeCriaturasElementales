package ar.edu.unlam.pb2.maestro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;
import ar.edu.unlam.pb2.criatura.*;

public class MaestroElementalTest {
	private MaestroElemental maestro;
	private Criatura criaturaDomestica;
	
    @BeforeEach
    public void setUp() {
    	maestro = new MaestroElemental("Airo", 50, AfinidadesElementales.AIRE);
        criaturaDomestica = new CriaturaDomesticada("Toto", 100, AfinidadesElementales.AGUA);
        maestro.agregarCriatura(criaturaDomestica);
    }
	
	@Test
    public void queLaMaestriaNoSupere50() {
        MaestroElemental m = new MaestroElemental("Kai", 80, AfinidadesElementales.FUEGO);
        assertEquals(50, m.getMaestria()); 
    }

    @Test
    public void queLaMaestriaNoSeaMenorA1() {
        MaestroElemental m = new MaestroElemental("Luna", -10, AfinidadesElementales.TIERRA);
        assertEquals(1, m.getMaestria());
    }
    
    @Test
    public void queSePuedaAgregarCriaturaAlMaestro() {
    	Criatura c = new CriaturaDomesticada("Toto", 100, AfinidadesElementales.AGUA);

        maestro.agregarCriatura(c);

        assertTrue(maestro.getCriaturas().containsKey("Toto"));
        assertEquals(c, maestro.getCriaturas().get("Toto"));
    }

    @Test
    public void queEntreneCriaturaConMaestriaSuficiente() {
    	Criatura c = new CriaturaDomesticada("Benji", 50, AfinidadesElementales.FUEGO);
        maestro.agregarCriatura(c);

        maestro.entrenarCriatura("Benji");

        assertEquals(80, c.getEnergia());
    }
    
    @Test
    public void queNoPuedaEntrenarSiLaMaestriaEsInsuficiente() {
        MaestroElemental m = new MaestroElemental("Mizu", 5, AfinidadesElementales.AGUA);
        Criatura c = new CriaturaDomesticada("Pichi", 100, AfinidadesElementales.AGUA);

        m.agregarCriatura(c);
        m.entrenarCriatura("Pichi");

        assertEquals(100, c.getEnergia());
        assertEquals(5, m.getMaestria());
    }


	@Test
	public void quePrimeraTransformacionSeaBendicionDelRio() {
		maestro.transformarCriatura("Toto");

		assertTrue(criaturaDomestica.getTransformado());
		assertEquals(180, criaturaDomestica.getEnergia()); 
	}

	@Test
	public void queSegundaTransformacionSeaLlamaInternaEnCriaturaDeFuego() {
	    MaestroElemental maestro = new MaestroElemental("Aki", 40, AfinidadesElementales.FUEGO);
	    Criatura c = new CriaturaDomesticada("Firu", 50, AfinidadesElementales.FUEGO);
	    maestro.agregarCriatura(c);

	    maestro.transformarCriatura("Firu");
	    assertEquals(100, c.getEnergia());
	    
	    maestro.transformarCriatura("Firu");
	    
	    assertEquals(130, c.getEnergia());
	    assertTrue(c.getTransformado());
	}


	@Test
	public void queTerceraTransformacionSeaVinculoTerrestre() {
		maestro.transformarCriatura("Toto");
		maestro.transformarCriatura("Toto");
		maestro.transformarCriatura("Toto");

		assertTrue(criaturaDomestica.getTransformado());
		criaturaDomestica.setEnergia(10);
		assertEquals(50, criaturaDomestica.getEnergia());
	}

	@Test
	public void queCuartaTransformacionSeaAscensoDelViento() {
		maestro.transformarCriatura("Toto");
		maestro.transformarCriatura("Toto");
		maestro.transformarCriatura("Toto");
		maestro.transformarCriatura("Toto");

		assertEquals(AfinidadesElementales.AIRE, criaturaDomestica.getElemento());
		assertTrue(criaturaDomestica.getTransformado());
	}

	@Test
	public void queNoSePuedaTransformarMasDeCuatroVeces() {
		maestro.transformarCriatura("Toto");
		maestro.transformarCriatura("Toto");
		maestro.transformarCriatura("Toto");
		maestro.transformarCriatura("Toto");

		Integer energiaAntes = criaturaDomestica.getEnergia();
		maestro.transformarCriatura("Toto");
		assertEquals(energiaAntes, criaturaDomestica.getEnergia());
	}

    
    
}
