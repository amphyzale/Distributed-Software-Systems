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

    //TODO tags
    @Length(max = 255, message = "Многа букав!")
    private String tag;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

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

}
