package com.enfor.myapp.beans;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ExampleBean implements Serializable {
    private String string = "CDI Bean here";

    private String login;
    private String pass;
    private boolean logget;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isLogget() {
        return logget;
    }

    public void setLogget(boolean logget) {
        this.logget = logget;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void doLogin() {
        logget = true;
    }
}
