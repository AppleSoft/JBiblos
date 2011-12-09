import Controlador.Controlador;
import Modelo.Biblioteca;
import Vista.IVista;
import Vista.VistaGrafica;

public class JBiblos {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        IVista vista = new VistaGrafica();
        Controlador controlador = new Controlador(biblioteca);
        vista.setControlador(controlador);
        vista.setModelo(biblioteca);
        vista.arranca();
    }
}