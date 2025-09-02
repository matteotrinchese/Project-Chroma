package model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Serializable {

    private int ID;
    private int categoryId;
    private String name;
    private String description;
    private BigDecimal price; // Best practice for currency
    private int vat;
    private int stockQuantity;
    private String imageURL;
    private boolean isAvailable;


    public Product() {}
    public Product(int ID, int categoryId, String name, String description, BigDecimal price, int vat, int stockQuantity, String imageURL, boolean isAvailable) {
        this.ID = ID;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
        this.stockQuantity = stockQuantity;
        this.imageURL = imageURL;
        this.isAvailable = isAvailable;
    }


    public int getID() { return this.ID; }
    public void setID(int ID) {}
    public int getCategoryId() { return this.categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return this.price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public int getVat() { return this.vat; }
    public void setVat(int vat) { this.vat = vat; }
    public int getStockQuantity() { return this.stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public String getImageURL() { return this.imageURL; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }
    public boolean isAvailable() { return this.isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + ID +
                ", name=" + name +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID == product.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
