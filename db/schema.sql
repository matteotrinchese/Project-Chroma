CREATE DATABASE IF NOT EXISTS Chroma;
USE Chroma;


DROP TABLE IF EXISTS User;
CREATE TABLE User (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    Username            VARCHAR(255) NOT NULL,
    Email               VARCHAR(255) NOT NULL UNIQUE,
    PasswordHash        VARCHAR(255) NOT NULL,
    Role                ENUM('Customer', 'Admin') DEFAULT 'Customer' NOT NULL,
    CreatedAt           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    LastLogin           TIMESTAMP NOT NULL,
    isActive            BOOLEAN NOT NULL NULL DEFAULT TRUE
);


DROP TABLE IF EXISTS Address;
CREATE TABLE Address (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    UserID              INT NOT NULL,
    Street              VARCHAR(255) NOT NULL,
    City                VARCHAR(100) NOT NULL,
    State               VARCHAR(100),
    PostalCode          VARCHAR(20) NOT NULL,
    Country             VARCHAR(50) NOT NULL,
    Name                VARCHAR(255) NOT NULL,
    Surname             VARCHAR(255) NOT NULL,
    Phone               VARCHAR(15) NOT NULL,
    -- Type                ENUM ('Shipping', 'Billing') NOT NULL,
    isDefault           BOOLEAN NOT NULL DEFAULT FALSE,

    FOREIGN KEY (UserID) REFERENCES User(ID)
                     ON DELETE CASCADE -- Quando un utente viene eliminato vengono eliminati anche i suoi indirizzi
                     ON UPDATE CASCADE
);


-- TODO PaymentMethods


DROP TABLE IF EXISTS Category;
CREATE TABLE Category (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    Name                VARCHAR(50) NOT NULL UNIQUE
);


DROP TABLE IF EXISTS Product;
CREATE TABLE Product (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    CategoryID          INT NOT NULL,
    Name                VARCHAR(255) NOT NULL,
    Description         TEXT,
    Price               DECIMAL(10, 2) NOT NULL,
    VAT                 INT NOT NULL,
    StockQuantity       INT NOT NULL DEFAULT 0,
    ImageURL            VARCHAR(255),
    isAvailable         BOOLEAN NOT NULL DEFAULT TRUE, -- Impostando FALSE si ottiene una eliminazione soft del prodotto

    FOREIGN KEY (CategoryID) REFERENCES Category (ID)
                     ON DELETE RESTRICT -- Impedisce di cancellare una categoria se ha prodotti associati
                     ON UPDATE CASCADE
);


-- Snapshot immutabile degli indirizzi utilizzati in un ordine
DROP TABLE IF EXISTS OrderAddress;
CREATE TABLE OrderAddress (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    Street              VARCHAR(255) NOT NULL,
    City                VARCHAR(100) NOT NULL,
    State               VARCHAR(100),
    PostalCode          VARCHAR(20) NOT NULL,
    Country             VARCHAR(50) NOT NULL,
    Name                VARCHAR(255) NOT NULL,
    Surname             VARCHAR(255) NOT NULL
    -- Type                ENUM ('Shipping', 'Billing') NOT NULL
);


DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order` (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    UserID              INT,
    OrderDate           DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    TotalAmount         DECIMAL (10, 2) NOT NULL,
    ShippingAddressID   INT NOT NULL,
    BillingAddressID    INT NOT NULL,
    Status              ENUM ('Pending', 'Processing', 'Shipped', 'Delivered', 'Cancelled') DEFAULT 'Pending',

    FOREIGN KEY (UserID) REFERENCES User (ID)
                    ON DELETE RESTRICT  -- Impedisce l'eliminazione di un utente se ha ordini associati
                    ON UPDATE CASCADE,
    FOREIGN KEY (ShippingAddressID) REFERENCES OrderAddress(ID)
                    ON DELETE RESTRICT -- Impedisce la cancellazione di uno snapshot di un indirizzo se utilizzato in un ordine
                    ON UPDATE CASCADE,
    FOREIGN KEY (BillingAddressID) REFERENCES OrderAddress(ID)
                    ON DELETE RESTRICT
                    ON UPDATE CASCADE
);


DROP TABLE IF EXISTS OrderProduct;
CREATE TABLE OrderProduct (
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    OrderID             INT NOT NULL,
    ProductID           INT,
    Name                VARCHAR(255) NOT NULL,
    Price               DECIMAL(10, 2) NOT NULL,
    VAT                 INT NOT NULL,
    Quantity            INT NOT NULL CHECK (Quantity > 0),

    FOREIGN KEY (OrderID) REFERENCES `Order`(ID)
                          ON DELETE CASCADE
                          ON UPDATE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product (ID)
                          ON DELETE SET NULL -- Se un prodotto viene eliminato vengono mantenuti i dati essenziali per la fattura
                          ON UPDATE CASCADE
);


DROP TABLE IF EXISTS Review;
CREATE TABLE Review(
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    UserID              INT,
    ProductID           INT NOT NULL,
    Title               VARCHAR(255) NOT NULL,
    Description         TEXT,
    Rating              TINYINT NOT NULL CHECK (Rating BETWEEN 1 AND 5),

    FOREIGN KEY (UserID) REFERENCES User(ID)
                                 ON DELETE SET NULL -- Impedisce l'eliminazione della recensione in caso in cui l'utente elimina l'account
                                 ON UPDATE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ID)
                                 ON DELETE RESTRICT -- Impedisce la cancellazione di un prodotto se presenta recensioni (L'eliminazione dei prodotti viene gestita con un soft-delete)
                                 ON UPDATE CASCADE
);


DROP TABLE IF EXISTS Cart;
CREATE TABLE Cart(
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    UserID              INT UNIQUE NOT NULL,

    FOREIGN KEY (UserID) REFERENCES User(ID)
                               ON DELETE CASCADE
                               ON UPDATE CASCADE
);


DROP TABLE IF EXISTS CartItem;
CREATE TABLE CartItem(
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    CartID              INT NOT NULL,
    ProductID           INT,
    Quantity            INT NOT NULL CHECK ( Quantity > 0 ),

    FOREIGN KEY (CartID) REFERENCES Cart(ID)
                                   ON DELETE CASCADE
                                   ON UPDATE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ID)
                                   ON DELETE SET NULL -- Quando un prodotto viene eliminato viene aggiornato il carrello dell'utente con "Prodotto non disponibile"
                                   ON UPDATE CASCADE
);


DROP TABLE IF EXISTS Whislist;
CREATE TABLE Wishlist(
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    UserID              INT UNIQUE NOT NULL,

    FOREIGN KEY (UserID) REFERENCES User(ID)
                                   ON DELETE CASCADE
                                   ON UPDATE CASCADE
);


DROP TABLE IF EXISTS WishlistItem;
CREATE TABLE WishlistItem(
    ID                  INT AUTO_INCREMENT PRIMARY KEY,
    WishlistID          INT NOT NULL,
    ProductID           INT,

    FOREIGN KEY (WishlistID) REFERENCES Wishlist(ID)
                                       ON DELETE CASCADE
                                       ON UPDATE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ID)
                                       ON DELETE SET NULL -- Quando un prodotto viene eliminato viene aggiornata la wishlist con "Prodotto non disponibile"
                                       ON UPDATE CASCADE
);