package com.enfor.myapp.dao;

import com.enfor.myapp.model.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerDAOImpl implements OwnerDAO {

    private static final Logger logger = LoggerFactory.getLogger(OwnerDAOImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Owner> listAllOwners() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Owner> ownerList = session.createQuery("from Owner").list();

        for (Owner owner :
                ownerList) {
            logger.info("Owner list: " + owner);
        }
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
        logger.info("Owner successfully saved. Owner details: " + owner);

    }

    @Override
    public void updateOwner(Owner owner) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(owner);
        logger.info("Owner successfully updated. Owner details: " + owner);
    }

    @Override
    public void deleteOwner(int ownerId) {
        Session session = this.sessionFactory.getCurrentSession();
        Owner owner = (Owner) session.load(Owner.class, ownerId);

        if (owner != null) {
            session.delete(owner);
        }
        logger.info("Owner successfully deleted. Owner details: " + owner);
    }
}
