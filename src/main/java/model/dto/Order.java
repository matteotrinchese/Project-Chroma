package model.dto;

import model.dto.enums.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order implements Serializable {

    private int ID;
    private int userID;
    private Timestamp orderDate;
    private BigDecimal totalAmount;
    private int shippingAddress; // Composition: holds the full shipping address object
    private int billingAddress;  // Composition: holds the full billing address object
    private OrderStatus status; // Uses the type-safe Enum

    public Order(){}
    public Order(int ID, int userID, Timestamp orderDate, BigDecimal totalAmount, int shippingAddress, int billingAddress, OrderStatus status) {
        this.ID = ID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.status = status;
    }


    public int getID(){ return ID; }
    public void setID(int ID){ this.ID = ID; }
    public int getUserID(){ return userID; }
    public void setUserID(int userID){ this.userID = userID; }
    public Timestamp getOrderDate(){ return orderDate; }
    public void setOrderDate(Timestamp orderDate){ this.orderDate = orderDate; }
    public BigDecimal getTotalAmount(){ return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount){ this.totalAmount = totalAmount; }
    public int getShippingAddress(){ return shippingAddress; }
    public void setShippingAddress(int shippingAddress){ this.shippingAddress = shippingAddress; }
    public int getBillingAddress(){ return billingAddress; }
    public void setBillingAddress(int billingAddress){ this.billingAddress = billingAddress; }
    public OrderStatus getStatus(){ return status; }
    public void setStatus(OrderStatus status){ this.status = status; }
    public void setStatus(String status){this.status = OrderStatus.fromString(status);}
}

