package com.enfor.myapp.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date birthDate;
    @Column(name = "address")
    private String address;
    @Column(name = "iq")
    private int iq;

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

    public void setBirthDate(String birthDate) {
        try {
            this.birthDate = new SimpleDateFormat( "yyyy-MM-dd" ).parse( birthDate );
        } catch (ParseException e) {
            System.out.println("Date is incorrect");
        }
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

    public Owner(int id) {
        this.id = id;
    }

    public Owner(int id, String name, Date birthDate, String address, int iq) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.iq = iq;
    }

    public Owner() {
    }

    public Owner(String name, Date birthDate, String address, int iq) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", iq=" + iq +
                '}';
    }
}

