import models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main( String[] args ) {
        insertEvento();
//        insertLocation();
//        insertPersona();
//        System.out.println(findPersona(1));
//        System.out.println(findEvento(5));
//        insertPartecipazione(2, 5);
    }

    public static void insertEvento() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        if (findLocation(1) != null){
            et.begin();

            Evento e = new Evento("Fiesta con i 4 Pagliacci", "1/12/2022", "Fiesta de fuego", TipoEvento.PUBBLICO, 500,
                    findLocation(1));

            em.persist(e);
            et.commit();

            em.close();
            emf.close();
        }

    }
    public static void RemoveEvento(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        if (findEvento(id) != null){
            et.begin();


            em.remove(findEvento(id));
            et.commit();

            em.close();
            emf.close();
        }

    }
    public static void RemovePersona(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        if (findPersona(id) != null){
            et.begin();


            em.remove(findPersona(id));
            et.commit();

            em.close();
            emf.close();
        }

    }
    public static void RemoveLocation(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        if (findLocation(id) != null){
            et.begin();


            em.remove(findLocation(id));
            et.commit();

            em.close();
            emf.close();
        }

    }
    public static void insertPersona() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Persona e = new Persona("gigino", "pippolotto", "4dellapocalisse@apo.it", "22/04/1886", Sesso.UOMO);

        em.persist(e);
        et.commit();

        em.close();
        emf.close();
    }
    public static void insertLocation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Location e = new Location("indianapolis", "Milano");

        em.persist(e);
        et.commit();

        em.close();
        emf.close();
    }
    public static Persona findPersona(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        Persona v = em.find(Persona.class, id);
        if(v != null) {
           return v;
        }

        em.close();
        emf.close();
        return null;
    }
    public static Evento findEvento(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        Evento v = em.find(Evento.class, id);
        if(v != null) {
            return v;
        }

        em.close();
        emf.close();
        return null;
    }
    public static Location findLocation(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        Location v = em.find(Location.class, id);
        if(v != null) {
            return v;
        }

        em.close();
        emf.close();
        return null;
    }
    public static void insertPartecipazione(int idP, int idE) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        if(findPersona(idP) == null ||  findEvento(idE) == null){
            System.out.println("not found");
        }else{
            et.begin();

            Partecipazione e = new Partecipazione(findPersona(idP), findEvento(idE), Stato.DA_CONFERMARE);

            em.persist(e);
            et.commit();

            em.close();
            emf.close();
        }
    }
}
