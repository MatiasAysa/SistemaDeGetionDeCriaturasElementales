package ar.edu.unlam.pb2.reporte;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pb2.criatura.Criatura;
import ar.edu.unlam.pb2.criatura.CriaturaAncestral;
import ar.edu.unlam.pb2.criatura.CriaturaDomesticada;
import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;
import ar.edu.unlam.pb2.maestro.MaestroElemental;

public class ModuloReporteTest {
	
    private MaestroElemental maestro1;
    private MaestroElemental maestro2;
    private Criatura criatura1;
    private Criatura criatura2;
    private Criatura criatura3;
    private ModuloReporte reporte;

	@BeforeEach
	public void setUp() throws Exception {
		maestro1 = new MaestroElemental("Aqua", 20, AfinidadesElementales.AGUA);
		maestro2 = new MaestroElemental("Ignis", 30, AfinidadesElementales.FUEGO);

		criatura1 = new CriaturaDomesticada("Pepe", 100, AfinidadesElementales.AGUA);
		criatura2 = new CriaturaDomesticada("Lolo", 150, AfinidadesElementales.FUEGO);
        criatura3 = new CriaturaAncestral("Ances", 180, AfinidadesElementales.AIRE);

        maestro1.agregarCriatura(criatura1);
        maestro1.agregarCriatura(criatura2); 
        maestro2.agregarCriatura(criatura3); 

        List<MaestroElemental> lista = new ArrayList<>();
        lista.add(maestro1);
        lista.add(maestro2);

        reporte = new ModuloReporte(lista);
	}

	@Test
	public void queListeTodasLasCriaturasDeTodosLosMaestros() {
	    List<Criatura> lista = reporte.listarCriaturasDeTodos();

	    assertEquals(3, lista.size());
	    assertTrue(lista.contains(criatura1));
	    assertTrue(lista.contains(criatura2));
	    assertTrue(lista.contains(criatura3));
	}

	@Test
	public void queObtengaLaCriaturaConMayorEnergia() {
	    Criatura mayor = reporte.obtenerConMayorEnergia();

	    assertEquals(criatura3, mayor);
	    assertEquals(180, (int) mayor.getEnergia());
	}

	@Test
	public void queEncuentreAlMaestroConMasCriaturasTransformadas() {
		criatura1.setTransformado(true);
		criatura3.setTransformado(true);
	    criatura2.setTransformado(true);

	    MaestroElemental result = reporte.maestroConMasTransformadas();

	    assertEquals(maestro1, result);
	}

	@Test
	public void queCuenteCantidadDeCriaturasPorAfinidad() {
	    Map<AfinidadesElementales, Integer> mapa = reporte.cantidadPorAfinidad();

	    assertEquals(Integer.valueOf(1), mapa.get(AfinidadesElementales.AGUA));
	    assertEquals(Integer.valueOf(1), mapa.get(AfinidadesElementales.FUEGO));
	    assertEquals(Integer.valueOf(1), mapa.get(AfinidadesElementales.AIRE));
	}

}

























