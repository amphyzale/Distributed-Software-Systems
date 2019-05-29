package com.enfor.myapp.CDI;

import com.enfor.myapp.model.Owner;

import java.util.List;

public interface OwnerDAO {

    List<Owner> listAllOwners();

    Owner getOwnerById(int ownerId);

    void addOwner(Owner owner);

    void updateOwner(Owner owner);

    void deleteOwner(int ownerId);

}
