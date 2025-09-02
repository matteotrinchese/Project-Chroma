package model.dto;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private int ID;
    private int userID;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String name;
    private String surname;
    private String phone;
    private boolean isDefault;


    public Address () {}
    public Address (int ID, int userID, String street, String city, String state, String postalCode, String country, String name, String surname, String phone, boolean isDefault) {
        this.ID = ID;
        this.userID = userID;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.isDefault = isDefault;
    }

    public int getID() { return this.ID; }
    public void setID(int ID) { this.ID = ID; }
    public int getUserID() { return this.userID; }
    public void setUserID(int userID) { this.userID = userID; }
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
    public String getPhone() { return this.phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public boolean isDefault() { return this.isDefault; }
    public void setDefault(boolean isDefault) { this.isDefault = isDefault; }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + ID +
                ", userId=" + userID +
                ", street=" + street +
                ", city=" + city +
                ", postalCode=" +
                ", name=" + name +
                ", surname=" + surname +
                "}";
    }

    // Two Address objects are considered equal if they have the same ID.
    // TODO altre condizioni
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return ID == address.ID;
    }

    /**
     * Generates a hash code based on the unique ID of the address.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}

