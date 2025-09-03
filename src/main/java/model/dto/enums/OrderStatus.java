package model.dto.enums;

public enum OrderStatus {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    public static OrderStatus fromString(String statusString) {
        if (statusString != null) {
            // We can iterate through the enum values to find a match
            for (OrderStatus status : OrderStatus.values()) {
                if (statusString.equalsIgnoreCase(status.name())) {
                    return status;
                }
            }
        }
        // If the string is null or no match is found, default to Pending.
        return PENDING;
    }
}
