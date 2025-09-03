package model.dto;

import java.io.Serializable;

public class WishlistItem implements Serializable {
    private int ID;
    private int wishlistID;
    private int productID;


    public WishlistItem(){}
    public WishlistItem(int ID, int wishlistID, int productID){
        this.ID = ID;
        this.wishlistID = wishlistID;
        this.productID = productID;
    }


    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public int getWishlistID() { return wishlistID; }
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }}
