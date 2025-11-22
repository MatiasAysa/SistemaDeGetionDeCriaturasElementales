package ar.edu.unlam.pb2.criatura;

public enum AfinidadesElementales {
	AGUA("Agua"),FUEGO("Fuego"),AIRE("Aire"),TIERRA("Tierra");
	
	private String nombreElemento ;
	
	private AfinidadesElementales(String nombre) {
		this.nombreElemento = nombre;
	}
	
	public String getNombreElemento() {
		return nombreElemento;
	}

}
