package com.enfor.myapp.beans;

import com.enfor.myapp.OwnerService.OwnerService;
import com.enfor.myapp.OwnerService.OwnerServiceImpl;
import com.enfor.myapp.model.Owner;
import org.springframework.dao.DataAccessException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name="ownerBean")
@RequestScoped
public class OwnerBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    //Spring Customer Service is injected...
    @ManagedProperty(value="#{ownerService}")
    OwnerService ownerService;

    List<Owner> ownerList;

    private int id;
    private String name;
    private Date birthDate;
    private String address;
    private int iq;

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

    public void addOwner(Owner owner) {
        this.ownerService.addOwner(owner);
        try {
            FacesContext.getCurrentInstance().getExternalContext().dispatch("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteOwner(Owner owner) {
        this.ownerService.deleteOwner(owner.getId());
    }

    public void updateOwner(Owner owner) {
        this.ownerService.updateOwner(owner);
    }

    public List<Owner> ownerList(){
        return this.ownerService.listAllOwners();
    }

    public void reset() {
        this.setId(0);
        this.setName("");
        //this.setBirthDate();
        this.setAddress("");
        this.setIq(0);
    }

    public List<Owner> getOwnerList() {
        ownerList = new ArrayList<Owner>();
        ownerList.addAll(getOwnerService().listAllOwners());
        return ownerList;
    }

    public OwnerService getOwnerService() {
        return ownerService;
    }

    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

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
    public void setBirthDate(String birthDate) {
        try {
            this.birthDate = new SimpleDateFormat( "yyyy-MM-dd" ).parse( birthDate );
        } catch (ParseException e) {
            System.out.println("Date is incorrect");
        }
    }


}
