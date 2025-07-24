DROP DATABASE IF EXISTS Chroma;
CREATE DATABASE Chroma;
USE Chroma;


CREATE TABLE User (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    Username            VARCHAR(255) NOT NULL,
    Email               VARCHAR(255) NOT NULL UNIQUE,
    PasswordHash        VARCHAR(255) NOT NULL,
    Role                ENUM('Customer', 'Admin') DEFAULT 'Customer' NOT NULL,
    CreatedAt           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    LastLogin           TIMESTAMP NULL
);

CREATE TABLE Address (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    Street              TEXT NOT NULL,
    AdditionalInfo      TEXT,
    City                VARCHAR(100) NOT NULL,
    PostalCode          VARCHAR(20) NOT NULL,
    Region              VARCHAR(100),
    Country             VARCHAR(100) NOT NULL
);

CREATE TABLE UserAddress(
    AddressID           INT NOT NULL,
    UserID              INT NOT NULL,
    AddressType         ENUM('Shipping', 'Billing') NOT NULL,
    Name                VARCHAR(255) NOT NULL,
    Surname             VARCHAR(255) NOT NULL,
    Phone               VARCHAR(15) NOT NULL,
    IsDefault           BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (AddressID, UserID, AddressType),
    FOREIGN KEY (UserID) REFERENCES User(ID) ON DELETE CASCADE,
    FOREIGN KEY (AddressID) REFERENCES Address(ID) ON DELETE CASCADE
);

CREATE TABLE PaymentMethod (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    UserID              INT NOT NULL,
    Number              VARCHAR(4) NOT NULL,
    Expiration          DATE NOT NULL,
    Name                VARCHAR(255) NOT NULL,
    IsDefault           BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (UserID) REFERENCES User(ID) ON DELETE CASCADE
);

# CREATE TABLE Product (
#     #TODO
# );