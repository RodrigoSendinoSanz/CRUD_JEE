package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import es.curso.modelo.entidad.CompactDisc;

public class DaoCD {
	//simulamos en una lista estatica static se comparte con todos los objetos
	private static List<CompactDisc> listaCD;
	
	//Los bloques estaticos son bloques de codigo que se ejecutan antes de arrancar cualquier aplicacion
	static {
		listaCD = new ArrayList<CompactDisc>();
		CompactDisc cd = new CompactDisc();
		
		cd.setArtista("Van Morrison");
		cd.setTitulo("Tupelo Honey");
		cd.setCiudad("UK");
		
		listaCD.add(cd);
		
		cd = new CompactDisc();
		cd.setArtista("Jorn Hoel");
		cd.setTitulo("Soulsville");
		cd.setCiudad("Norway");
		
		listaCD.add(cd);
		
		cd = new CompactDisc();
		cd.setArtista("Joe Cocker");
		cd.setTitulo("Unchain my heart");
		cd.setCiudad("USA");
		
		listaCD.add(cd);
	}
	
	public List<CompactDisc> listar() {
		return listaCD;
	}
	
	public boolean add(CompactDisc cd) {
		return listaCD.add(cd);
	}
}
