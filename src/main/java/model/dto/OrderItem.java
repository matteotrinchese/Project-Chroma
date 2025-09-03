package model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {

    private int ID;
    private int orderID;
    private int productID;
    private String productName;
    private BigDecimal productPrice;
    private int productVAT;
    private int productQuantity;


    public OrderItem(){}
    public OrderItem(int ID, int orderID, int productID, String productName, BigDecimal productPrice, int productVAT, int productQuantity){
        this.ID = ID;
        this.orderID = orderID;
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productVAT = productVAT;
        this.productQuantity = productQuantity;
    }


    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public BigDecimal getProductPrice() { return productPrice; }
    public void setProductPrice(BigDecimal productPrice) { this.productPrice = productPrice; }
    public int getProductVAT() { return productVAT; }
    public void setProductVAT(int productVAT) { this.productVAT = productVAT; }
    public int getProductQuantity() { return productQuantity; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }
}
