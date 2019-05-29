package com.enfor.myapp.CDI;

import com.enfor.myapp.model.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;


public class OwnerDAOImpl implements OwnerDAO {


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Owner> listAllOwners() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Owner> ownerList = session.createQuery("from Owner").list();

        return ownerList;
    }

    @Override
    public Owner getOwnerById(int ownerId) {
        Session session = this.sessionFactory.getCurrentSession();
        Owner owner = (Owner) session.get(Owner.class, new Integer(ownerId));
        return owner;
    }

    @Override
    public void addOwner(Owner owner) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(owner);

    }

    @Override
    public void updateOwner(Owner owner) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(owner);

    }

    @Override
    public void deleteOwner(int ownerId) {
        Session session = this.sessionFactory.getCurrentSession();
        Owner owner = (Owner) session.load(Owner.class, ownerId);

        if (owner != null) {
            session.delete(owner);
        }

    }
}
