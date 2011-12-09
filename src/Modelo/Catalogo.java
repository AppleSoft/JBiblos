package Modelo;
import java.util.*;
import HBM.*;

public class Catalogo {

    private HashMap<TituloId, Titulo> catalogo;

    public Catalogo() {
        //super();
        catalogo = new HashMap<TituloId, Titulo>();
    }

    public void alta(Titulo titulo) {
        throw new UnsupportedOperationException();
    }

    public void baja(TituloId codDewey) {
        throw new UnsupportedOperationException();
    }

    public void modificar(Titulo titulo) {
        throw new UnsupportedOperationException();
    }

    public Map<TituloId, Titulo> getCatalogo() {
        return catalogo;
    }

    public void init(List<Titulo> catalogo) {
        for (Titulo titulo : catalogo) {
            this.catalogo.put(titulo.getId(), titulo);
        }
    }
}