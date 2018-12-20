package com.enfor.myapp.OwnerService;

import com.enfor.myapp.model.Owner;

import java.util.List;

public interface OwnerService {
    void addOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(int ownerId);
    Owner getOwnerById(int ownerId);
    List<Owner> listAllOwners();
}
