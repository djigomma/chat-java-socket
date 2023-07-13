package sn.groupeisi.dao;

import sn.groupeisi.entity.Membre;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.groupeisi.config.HibernateUtil;
import sn.groupeisi.entity.Membre;

import javax.persistence.TypedQuery;
import java.util.List;

public class MembreImpl implements IMembre{
    private Session session;
    private Transaction transaction;
    public MembreImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public int create(Membre membre) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.save(membre);
            transaction.commit();
            ok = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Membre> getAll() {
        return session.createCriteria(Membre.class).list();

    }

    @Override
    public Membre get(int id) {
        return session.get(Membre.class, id);
    }
    public Membre findName(String userName) {
        String queryString = "SELECT m FROM Membre m WHERE m.membre = :userName" ;
        TypedQuery<Membre> query = session.createQuery(queryString, Membre.class);
        query.setParameter("userName", userName);
        List<Membre> membres = query.getResultList();
        return membres.isEmpty() ? null : membres.get(0);
    }
}
