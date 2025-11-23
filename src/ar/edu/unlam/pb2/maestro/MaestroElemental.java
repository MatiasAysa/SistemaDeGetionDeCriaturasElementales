package ar.edu.unlam.pb2.maestro;

import java.util.HashMap;

import ar.edu.unlam.pb2.criatura.Criatura;
import ar.edu.unlam.pb2.enumeradores.AfinidadesElementales;

public class MaestroElemental {
	private String nombre;
	private Integer maestria;
	private AfinidadesElementales afinidad;
	private HashMap <String,Criatura> criaturas = new HashMap<>();

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
	
	public void entrenarCriatura(String nombreCriatura){
        Criatura c = criaturas.get(nombreCriatura);
        try {
            if (this.maestria < 10) { 
                throw new MaestriaInsuficienteException("Nivel de maestria insuficiente");
            }else {
            	this.maestria -= 5;
                c.entrenar();
            }
        }catch(MaestriaInsuficienteException e){
        	 System.out.println("Error: " + e.getMessage());
        	 //Se puede hacer otra coso?
        }finally {
        	System.out.println("Se completo el entrenamiento");
        }

        //if (c == null) return; posible para agregar

    }

    public void pacificar(String nombreCriatura) {
        Criatura c = criaturas.get(nombreCriatura);
        c.pacificar();
    }
	
	public HashMap<String, Criatura> getCriaturas() {
		return criaturas;
	}
	
	
	
	
}
