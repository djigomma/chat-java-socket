package sn.groupeisi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.groupeisi.config.HibernateUtil;
import sn.groupeisi.entity.Commentaire;

import java.util.List;

public class CommentaireImpl implements ICommentaire{
    private Session session;
    private Transaction transaction;
    public CommentaireImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public int create(Commentaire commentaire) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.save(commentaire);
            transaction.commit();
            ok = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Commentaire> getAll() {
        return null;
    }

    @Override
    public Commentaire get(int id) {
        return null;
    }

}
