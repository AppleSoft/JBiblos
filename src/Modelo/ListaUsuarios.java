package Modelo;

import java.util.*;

public class ListaUsuarios {

    private HashMap<Integer, Usuario> listaUsuarios;

    public ListaUsuarios() {
        listaUsuarios = new HashMap<Integer, Usuario>();
    }

    public void alta(Usuario usuario) {
        
    }

    public void baja(int dni) {
        
    }

    public void modificar(int dni) {
        throw new UnsupportedOperationException();
    }

    public Map<Integer, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void init(List<Usuario> listaUsuarios) {
        for (Usuario usuario : listaUsuarios) {
            this.listaUsuarios.put((Integer) usuario.getDni(), usuario);
            System.out.println("dni: "+usuario.getDni()+" en el init de ListaUsuarios");
        }
    }
}