package model.dto;

import model.dto.enums.Role;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

    private int ID;
    private String username;
    private String email;
    private String hashPassword;
    private Role role;
    private Timestamp createdAt;
    private Timestamp lastLogin;
    private boolean isActive;

    public User () {}

    public User (int ID, String username, String email, String hashPassword, Role role,  Timestamp createdAt, Timestamp lastLogin, boolean isActive) {
        this.ID = ID;
        this.username = username;
        this.email = email;
        this.hashPassword = hashPassword;
        this.role = role;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
    }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getHashPassword() { return hashPassword; }
    public void setHashPassword(String hashPassword) { this.hashPassword = hashPassword; }
    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }
    public void setRole(String role) { this.role = Role.fromString(role); }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public Timestamp getLastLogin() { return lastLogin; }
    public void setLastLogin(Timestamp lastLogin) { this.lastLogin = lastLogin; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + ID +
                ", username=" + username +
                ", email=" + email +
                ", role=" + role +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        // Two user objects are considered equal if they have the same ID.
        return ID == user.ID;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(ID);
    }
}
