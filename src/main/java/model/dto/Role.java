package model.dto;

public enum Role
{
    CUSTOMER,
    ADMIN;

    // Convert a string from the database into the corresponding ENUM constant
    public static Role fromString(String roleString) {
        if (roleString != null) {
            // .equalsIgnoreCase makes the matching case-insensitive
            if (roleString.equalsIgnoreCase("Admin")) {
                return ADMIN;
            }
        }
        // If the string is null or doesn't match "Admin", we default to Customer.
        return CUSTOMER;
    }
}
