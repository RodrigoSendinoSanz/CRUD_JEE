package com.eventos.daos;

import com.eventos.beans.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UsuarioDaoImpl implements IntUsuarioDao {
    private List<Usuario> lista;

    public UsuarioDaoImpl() {
        lista = new ArrayList<>();
        cargarDatos();
    }

    public void cargarDatos() {
		lista.add(new Usuario(1,"admin", "12345", "Rodrigo", "Sendino Sanz", "Burgos", 1, new Date()));
		lista.add(new Usuario(2,"clie1", "1234", "Ana", "Saniz", "Almeria", 0, new Date()));
		lista.add(new Usuario(3,"juan", "1234", "Juan", "Jose Ramirez", "Madrid", 1, new Date()));

    }



    public Usuario findById(int idUsuario) {
        for (Usuario usuario : lista) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }


    public int verificarDatos(String user, String pass) {
        int id = 0;
        for (Usuario usuario : lista) {
            if (user.equals(usuario.getUsername()) && pass.equals(usuario.getPassword())) {
                id = usuario.getIdUsuario();
                break;
            }
        }

        return id;
    }

}
