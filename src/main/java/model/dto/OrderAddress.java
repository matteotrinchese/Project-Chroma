package model.dto;

import java.io.Serializable;

public class OrderAddress implements Serializable {

    private int ID;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String name;
    private String surname;


    public OrderAddress(){}
    public OrderAddress(int ID, String street, String city, String state, String postalCode, String country, String name, String surname) {
        this.ID = ID;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.name = name;
        this.surname = surname;
    }


    public int getID() { return this.ID; }
    public void setID(int ID) { this.ID = ID; }
    public String getStreet() { return this.street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return this.city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return this.state; }
    public void setState(String state) { this.state = state; }
    public String getPostalCode() { return this.postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public String getCountry() { return this.country; }
    public void setCountry(String country) { this.country = country; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return this.surname; }
    public void setSurname(String surname) { this.surname = surname; }
}
