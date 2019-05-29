package com.enfor.myapp.beans;

import com.enfor.myapp.model.Owner;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
public class OwnerBean {

    @PersistenceContext(name = "myUnit")
    private EntityManager entityManager;



    public boolean createOwner(String name, Date birthDate, String address, int iq){
        Owner owner = new Owner();
        owner.setName(name);
        owner.setBirthDate(birthDate);
        owner.setAddress(address);
        owner.setIq(iq);
        entityManager.persist(owner);

        return true;
    }

    public List<Owner> getAllOwners(){
        Query query = entityManager.createQuery("select entity from Owner entity");
        return query.getResultList();
    }
}
