package Modelo;

import Utils.HibernateUtil;
import java.util.Observable;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

public class ContenedorUsuarios extends Observable {

    private Usuarios listaUsuarios;

    public ContenedorUsuarios() {
        listaUsuarios= new Usuarios();
    }


    public Usuarios getListaUsuarios() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            listaUsuarios.init(session.createQuery("from Usuario").list());

            session.getTransaction().commit();
            setChanged();
            notifyObservers();

        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
        }
        return listaUsuarios;
    }
}