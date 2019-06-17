package com.enfor.myapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String title;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 2048, message = "Многа букав!")
    private String text;

    @Length(max = 255, message = "Многа букав!")
    private String tag;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfCrash;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private Status status;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car1_id")
    private Car car1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car2_id")
    private Car car2;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "street1_id")
    private Street street1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "street2_id")
    private Street street2;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "road_obj_id")
    private TypeOfRoadObj typeOfRoadObj;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Message() {
    }

    public Message(String text, String tag, User author) {
        this.author = author;
        this.text = text;
        this.tag = tag;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public User getAuthor() {
        return author;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfCrash() {
        return dateOfCrash;
    }

    public void setDateOfCrash(Date dateOfCrash) {
        this.dateOfCrash = dateOfCrash;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Car getCar1() {
        return car1;
    }

    public void setCar1(Car car1) {
        this.car1 = car1;
    }

    public Car getCar2() {
        return car2;
    }

    public void setCar2(Car car2) {
        this.car2 = car2;
    }

    public Street getStreet1() {
        return street1;
    }

    public void setStreet1(Street street1) {
        this.street1 = street1;
    }

    public Street getStreet2() {
        return street2;
    }

    public void setStreet2(Street street2) {
        this.street2 = street2;
    }

    public TypeOfRoadObj getTypeOfRoadObj() {
        return typeOfRoadObj;
    }

    public void setTypeOfRoadObj(TypeOfRoadObj typeOfRoadObj) {
        this.typeOfRoadObj = typeOfRoadObj;
    }
}
