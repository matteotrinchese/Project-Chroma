package model.dto;

import java.io.Serializable;

public class CartItem implements Serializable {
    private int ID;
    private int cartID;
    private int productID;
    private int productQuantity;


    public CartItem(){}
    public CartItem(int ID, int cartID, int productID, int productQuantity) {
        this.ID = ID;
        this.cartID = cartID;
        this.productID = productID;
        this.productQuantity = productQuantity;
    }


    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public int getCartID() { return cartID; }
    public void setCartID(int cartID) { this.cartID = cartID; }
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }
    public int getProductQuantity() { return productQuantity; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }
}
