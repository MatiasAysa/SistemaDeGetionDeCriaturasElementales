package ar.edu.unlam.pb2.reporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unlam.pb2.criatura.Criatura;
import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;
import ar.edu.unlam.pb2.maestro.MaestroElemental;

public class ModuloReporte {
	
	private List<MaestroElemental> maestros;

    public ModuloReporte(List<MaestroElemental> maestros) {
        this.maestros = maestros;
    }
    
    public List<Criatura> listarCriaturasDeTodos() {
        List<Criatura> resultado = new ArrayList<>();

        for (MaestroElemental m : this.maestros) {
            for (Criatura c : m.getCriaturas().values()) { 
                resultado.add(c);
            }
        }

        return resultado;
    }

    
    public Criatura obtenerConMayorEnergia() {
        List<Criatura> todas = listarCriaturasDeTodos();

        if (todas.isEmpty()) {
            return null;
        }

        Criatura mayor = todas.get(0);

        for (Criatura c : todas) {
            if (c.getEnergia() > mayor.getEnergia()) {
                mayor = c;
            }
        }

        return mayor;
    }
    
    public MaestroElemental maestroConMasTransformadas() {

        if (maestros.isEmpty()) {
            return null;
        }

        MaestroElemental mejor = maestros.get(0);
        int maxTransformadas = contarTransformadas(mejor);

        for (MaestroElemental m : maestros) {
            int cant = contarTransformadas(m);

            if (cant > maxTransformadas) {
                mejor = m;
                maxTransformadas = cant;
            }
        }

        return mejor;
    }

    private int contarTransformadas(MaestroElemental m) {
        int contador = 0;

        for (Criatura c : m.getCriaturas().values()) {
            if (c.estaTransformado()) {
                contador++;
            }
        }

        return contador;
    }
    
    public Map<AfinidadesElementales, Integer> cantidadPorAfinidad() {

        Map<AfinidadesElementales, Integer> mapa = new HashMap<>();

        List<Criatura> todas = listarCriaturasDeTodos();

        for (Criatura c : todas) {

        	AfinidadesElementales clave = c.getElemento();

            // si no está, lo creo
            if (!mapa.containsKey(clave)) {
                mapa.put(clave, 1);
            } else {
                // si está, incremento
                Integer actual = mapa.get(clave);
                mapa.put(clave, actual + 1);
            }
        }

        return mapa;
    }


}
