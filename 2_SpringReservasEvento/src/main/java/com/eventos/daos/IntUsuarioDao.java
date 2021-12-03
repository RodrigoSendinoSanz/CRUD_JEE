package com.eventos.daos;

import com.eventos.beans.Usuario;

public interface IntUsuarioDao {
	Usuario findById(int idusuario);
	int verificarDatos(String user, String pass);
}
