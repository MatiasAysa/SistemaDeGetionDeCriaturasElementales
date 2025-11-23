package ar.edu.unlam.pb2.maestro;

import java.util.HashMap;

import ar.edu.unlam.pb2.criatura.Criatura;
import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;
import ar.edu.unlam.pb2.transformacion.*; 

public class MaestroElemental {
	private String nombre;
	private Integer maestria;
	private AfinidadesElementales afinidad;
	private HashMap <String,Criatura> criaturas = new HashMap<>();
	private HashMap <String,Integer> transformacionesAplicadas = new HashMap<>();
	
	public MaestroElemental(String nombre, Integer maestria, AfinidadesElementales afinidad) {
		this.nombre = nombre;
		this.maestria = otorgarMaestria(maestria);
		this.afinidad = afinidad;
	}
	
	private Integer otorgarMaestria(Integer maestria) {
		if(maestria > 50) {
			return maestria = 50;
		}else if(maestria < 1){
			return maestria = 1; 
		}
		return maestria;
	}

	
    public void agregarCriatura(Criatura c) {
        criaturas.put(c.getNombre(), c);
    }
    
    public void transformarCriatura(String nombreCriatura) {
        Criatura criatura = criaturas.get(nombreCriatura);
        if (criatura == null) return;

        Integer nivel = transformacionesAplicadas.getOrDefault(nombreCriatura, 0);

        Transformacion t = new TransformacionPartida();

        switch (nivel) {
            case 0:
                t = new TransformacioBendicionRio(t);
                break;
            case 1:
                t = new TransformacionLlamaInterna(t);
                break;
            case 2:
                t = new TransformacionVinculoTerrestre(t);
                break;
            case 3:
                t = new TransformacionAscensoViento(t);
                break;
            default:
                return;
        }

        t.aplicarTransformacion(criatura);
        transformacionesAplicadas.put(nombreCriatura, nivel + 1);
    }

	
	public void entrenarCriatura(String nombreCriatura){
        Criatura c = criaturas.get(nombreCriatura);
        try {
            if (this.maestria < 10) { 
                throw new MaestriaInsuficienteException("Nivel de maestria insuficiente");
            }else {
                c.entrenar();
            }
        }catch(MaestriaInsuficienteException e){
        	 System.out.println("Error: " + e.getMessage());
        }finally {
        	System.out.println("Todo salio bien,el entrenamiento fue exitoso");
        }
    }

    public void pacificar(String nombreCriatura) {
        Criatura c = criaturas.get(nombreCriatura);
        c.pacificar();
    }
	
	public HashMap<String, Criatura> getCriaturas() {
		return criaturas;
	}
	
	public String getNombre() {
		return nombre;
	}

	public AfinidadesElementales getAfinidad() {
		return afinidad;
	}
	
	public Integer getMaestria() {
		return maestria;
	}
	
	
	
	
}
