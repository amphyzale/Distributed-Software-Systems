package com.enforcer.DAO;

public class Pet {
    private long id;
    private String name;
    private int age;
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPetOwnerId() {
        return petOwnerId;
    }

    public void setPetOwnerId(long petOwnerId) {
        this.petOwnerId = petOwnerId;
    }

    private long petOwnerId;
}
