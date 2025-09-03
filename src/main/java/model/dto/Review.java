package model.dto;

import java.io.Serializable;

public class Review implements Serializable {

    private int ID;
    private int userID;
    private int productID;
    private String title;
    private String description;
    private int rating;


    public Review(){}
    public Review(int ID, int userID, int productID, String title, String description, int rating) {
        this.ID = ID;
        this.userID = userID;
        this.productID = productID;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public int getID() { return this.ID; }
    public void setID(int ID) { this.ID = ID; }
    public int getUserID() { return this.userID; }
    public void setUserID(int userID) { this.userID = userID; }
    public int getProductID() { return this.productID; }
    public void setProductID(int productID) { this.productID = productID; }
    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
    public int getRating() { return this.rating; }
    public void setRating(int rating) { this.rating = rating; }
}
