package com.enfor.myapp.CDI;

import com.enfor.myapp.beans.OwnerBean;
import com.enfor.myapp.model.Owner;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class OwnerCDI implements Serializable {

    private int id;
    private String name;
    private Date birthDate;
    private String address;
    private int iq;

    private boolean createSuccess;

    @EJB
    private OwnerBean ownerBean;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void createOwner(){
        createSuccess = ownerBean.createOwner(name, birthDate, address, iq);
    }

    public List<Owner> getAllOwners(){
        return ownerBean.getAllOwners();
    }
}
