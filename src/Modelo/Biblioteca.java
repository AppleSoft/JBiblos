package Modelo;

import Utils.HibernateUtil;
import java.util.List;
import java.util.Observable;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import HBM.*;

public class Biblioteca extends Observable {

    
    private Usuario usuarioActivo;
    private Catalogo alberga;
    private ListaUsuarios contiene;
    
    
    public Biblioteca() {
        alberga = new Catalogo();
        contiene = new ListaUsuarios();
    }

    public Usuario login(String dni, String clave) throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            //List usuarios = BD.executeHQLQuery("from Usuario u where u.dni=" + dni + " and u.clave='" + clave + "'");
            usuarioActivo = (Usuario) session.load(Usuario.class, Integer.parseInt(dni));
            System.out.println("BD:" + usuarioActivo.getClave() + ", clave:" + clave);
            if (usuarioActivo.getClave().equals(clave) == false) {
                System.out.println("Fallo en clave");
                throw new Exception("Usuario " + dni + " clave no válido");
            }
            session.getTransaction().commit();
            session.close();
            setChanged();
            notifyObservers();

        } catch (ObjectNotFoundException ex) {
            System.err.println("Login (" + dni + " / " + clave + ") clave no valida");
            throw new Exception("Usuario " + dni + " no válido");
        }
        return usuarioActivo;


    }


    public Catalogo getAlberga() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            alberga.init(session.createQuery("from Titulo").list());

            session.getTransaction().commit();
            //session.close();
            setChanged();
            notifyObservers();

        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
        }
        return alberga;
    }

    public ListaUsuarios getUsuarios() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            contiene.init(session.createQuery("from Usuario").list());

            session.getTransaction().commit();
            //setChanged();
            //notifyObservers();

        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
        }
        return contiene;
    }
    
    public List<Dewey> getCategoriasDewey() {
        List<Dewey> listaCategoriasDewey = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            listaCategoriasDewey = session.createQuery("from Dewey").list();

            session.getTransaction().commit();
            //session.close();

        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
        }
        return listaCategoriasDewey;
    }
}