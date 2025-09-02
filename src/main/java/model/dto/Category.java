package model.dto;

import java.io.Serializable;

public class Category implements Serializable {

    private int ID;
    private String name;


    public Category() {}
    public Category(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }


    public int getID() { return this.ID; }
    public void setID(int ID) { this.ID = ID; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }


    @Override
    public String toString() {
        return  "Category{" + "ID=" + ID + ", name=" + name + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return ID == category.ID || name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(ID);
    }
}
