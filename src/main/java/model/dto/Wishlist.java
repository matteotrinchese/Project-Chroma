package model.dto;

import java.io.Serializable;

public class Wishlist implements Serializable {
    private int ID;
    private int userID;


    public Wishlist(){}
    public Wishlist(int ID, int userID) {
        this.ID = ID;
        this.userID = userID;
    }


    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
}
