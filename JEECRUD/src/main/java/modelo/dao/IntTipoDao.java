package modelo.dao;

import java.util.List;


import modelo.beans.Tipo;

public interface IntTipoDao {
	
	Tipo findById(int id_tipo);
	List<Tipo> findAll();
		int altaTipo(Tipo tipo);
		int eliminarTipo(int id_tipo);
		

}
