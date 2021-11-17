package modelo.dao;


import java.util.ArrayList;
import java.util.List;

import modelo.beans.Tipo;

public class TipoListImpl implements IntTipoDao {

	private List<Tipo> lista;
	
	public TipoListImpl() {
		lista = new ArrayList<Tipo>();	
		cargarDatos();
	}
	
	private void cargarDatos() {
		
		lista.add(new Tipo(1, "Boda", "Boda servicio estandar"));
		lista.add(new Tipo(2, "Boda VIP","Boda servicio especial"));
		lista.add(new Tipo(3, "Despedida de soltero","Evento despedida de soltero"));
		lista.add(new Tipo(4, "Eventos empresas","Evento para empresas"));
		lista.add(new Tipo(5, "Cumple","Evento para cumples"));
	}

	@Override
	public Tipo findById(int id_tipo) {
		Tipo aux = new Tipo();
		aux.setId_tipo(id_tipo);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public List<Tipo> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public int altaTipo(Tipo tipo) {
		if (lista.contains(tipo))
			return 0;
		else
			return lista.add(tipo)?1:0;
	}

	@Override
	public int eliminarTipo(int id_tipo) {
		Tipo aux = new Tipo();
		aux.setId_tipo(id_tipo);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return 0;
		else
			return (lista.remove(pos) !=null)?1:0;
	}
}
