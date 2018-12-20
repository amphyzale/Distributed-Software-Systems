package com.enfor.myapp.OwnerService;

import com.enfor.myapp.dao.OwnerDAO;
import com.enfor.myapp.model.Owner;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerDAO ownerDAO;

    public void setOwnerDAO(OwnerDAO ownerDAO) {
        this.ownerDAO = ownerDAO;
    }

    @Override
    @Transactional
    public void addOwner(Owner owner) {
        this.ownerDAO.addOwner(owner);
    }

    @Override
    @Transactional
    public void updateOwner(Owner owner) {
        this.ownerDAO.updateOwner(owner);
    }

    @Override
    @Transactional
    public void deleteOwner(int ownerId) {
        this.ownerDAO.deleteOwner(ownerId);
    }

    @Override
    @Transactional
    public Owner getOwnerById(int ownerId) {
        return this.ownerDAO.getOwnerById(ownerId);
    }

    @Override
    @Transactional
    public List<Owner> listAllOwners() {
        return this.ownerDAO.listAllOwners();
    }
}