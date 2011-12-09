package Modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Usuarios extends Observable{

    private HashMap<Integer, Usuario> usuarios;

    public Usuarios() {
        usuarios = new HashMap<Integer, Usuario>();
    }

    public void alta(Usuario usuario) {
        usuarios.put(usuario.getDni(), usuario);
    }

    public void baja(Usuario usuario) {
        usuarios.remove(usuario.getDni());
    }

    public void modificar(Usuario usuario) {
        throw new UnsupportedOperationException();
    }

    public Map<Integer, Usuario> getListaUsuarios() {
        return usuarios;
    }

    public void init(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            this.usuarios.put(usuario.getDni(), usuario);
        }
    }
    
}
