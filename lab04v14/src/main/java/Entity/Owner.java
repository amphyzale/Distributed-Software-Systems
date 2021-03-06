package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Owner {
    private long id;
    private String name;
    private Date birthDate;
    private String address;
    private int iq;

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

    public Owner(long id) {
        this.id = id;
    }

    public Owner(long id, String name, Date birthDate, String address, int iq) {
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
}
