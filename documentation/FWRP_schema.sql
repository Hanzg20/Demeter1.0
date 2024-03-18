DROP DATABASE IF EXISTS FWRP;
CREATE DATABASE FWRP;
USE FWRP;

-- Set SQL mode and foreign key checks
SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO';
SET FOREIGN_KEY_CHECKS = 0;

-- Drop tables if they exist
DROP TABLE IF EXISTS `Location`;
DROP TABLE IF EXISTS `Item_type`;
DROP TABLE IF EXISTS `role_type`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `sysfunction`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `user_function`;
DROP TABLE IF EXISTS `subscription`;
DROP TABLE IF EXISTS `notification`;
DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `item_listing`;
DROP TABLE IF EXISTS `Transaction_type`;
DROP TABLE IF EXISTS `Transaction`;

-- Create tables

CREATE TABLE IF NOT EXISTS `Location` (
  `Location_id` INT NOT NULL AUTO_INCREMENT,
  `Location_name` VARCHAR(50) NOT NULL,
  `Address` VARCHAR(255) NULL,
  PRIMARY KEY (`Location_id`)
);

CREATE TABLE IF NOT EXISTS `Item_type` (
  `Item_type_id` INT(5) NOT NULL,
  `Item_type_name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Item_type_id`)
);

CREATE TABLE IF NOT EXISTS `role_type` (
  `Role_type_id` INT(2) NOT NULL,
  `Role_type_name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Role_type_id`)
);

CREATE TABLE IF NOT EXISTS `role` (
  `Role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Role_name` VARCHAR(100) NULL DEFAULT NULL,
  `Role_type` INT(2) NOT NULL,
  PRIMARY KEY (`Role_id`),
  INDEX `fk_role_role_type1_idx` (`Role_type`),
  CONSTRAINT `fk_role_role_type1` FOREIGN KEY (`Role_type`) REFERENCES `role_type` (`Role_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `sysfunction` (
  `function_id` INT(11) NOT NULL AUTO_INCREMENT,
  `function_name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`function_id`)
);

CREATE TABLE IF NOT EXISTS `user` (
  `User_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NULL DEFAULT NULL,
  `Role_id` INT(11) NOT NULL,
  `Email` VARCHAR(50) NULL DEFAULT NULL,
  `Password` VARCHAR(50) NULL DEFAULT NULL,
  `Create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  PRIMARY KEY (`User_id`),
  INDEX `Role_Role_ID_idx` (`Role_id`),
  CONSTRAINT `Role_Role_ID` FOREIGN KEY (`Role_id`) REFERENCES `role` (`Role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `user_function` (
  `function_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  INDEX `function_id` (`function_id`),
  INDEX `fk_user_function_role1_idx` (`role_id`),
  PRIMARY KEY (`role_id`, `function_id`),
  CONSTRAINT `user_function_ibfk_2` FOREIGN KEY (`function_id`) REFERENCES `sysfunction` (`function_id`),
  CONSTRAINT `fk_user_function_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`Role_id`)
);

CREATE TABLE IF NOT EXISTS `subscription` (
  `subs_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11),
  `Notific_method` VARCHAR(3),
  `Item_location` VARCHAR(60),
  `Item_price` DECIMAL(10,2),
  `Item_type` INT(5) NOT NULL,
  PRIMARY KEY (`subs_id`),
  INDEX `user_id` (`user_id`),
  INDEX `fk_sub_Item_type1_idx` (`Item_type`),
  CONSTRAINT `fk_sub_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sub_Item_type1` FOREIGN KEY (`Item_type`) REFERENCES `Item_type` (`Item_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `notification` (
  `noti_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11),
  `message` TEXT,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  `status` CHAR(3),
  PRIMARY KEY (`noti_id`),
  INDEX `user_id` (`user_id`),
  CONSTRAINT `fk_notification_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Drop Table item if exists
DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `Item_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Item_name` VARCHAR(100) NULL DEFAULT NULL,
  `Unit` VARCHAR(50) NULL DEFAULT NULL,
  `Location_id` INT NOT NULL,
  `Create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `User_id` INT(11) NOT NULL,
  `Item_type` INT(5) NOT NULL,
  `Quantity` INT(11) NULL DEFAULT NULL,
  `Expir_date` DATE NULL DEFAULT NULL,
  `Price` DECIMAL(10,2) NULL,
  `Status` CHAR(3) NULL DEFAULT NULL,
  `Status_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`Item_id`,`Location_id`,`Item_type`),
  INDEX `fk_item_Item_type1_idx` (`Item_type`),
  INDEX `fk_item_user1_idx` (`User_id`),
  INDEX `fk_item_Location1_idx` (`Location_id`),
  CONSTRAINT `fk_item_Item_type1` FOREIGN KEY (`Item_type`) REFERENCES `Item_type` (`Item_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_user1` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_Location1` FOREIGN KEY (`Location_id`) REFERENCES `Location` (`Location_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);




-- Drop Table item_listing if exists
DROP TABLE IF EXISTS `item_listing`;
CREATE TABLE IF NOT EXISTS `item_listing` (
  `Listing_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Item_id` INT(11) NULL DEFAULT NULL,
  `Is_donation` TINYINT(1) NULL DEFAULT NULL,
  `Discount_rate` DECIMAL(10,2) NULL DEFAULT NULL,
  `Listing_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`Listing_id`),
  INDEX `item_id` (`Item_id`),
  CONSTRAINT `fk_item_listing_item1` FOREIGN KEY (`Item_id`) REFERENCES `item` (`Item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Drop Table Transaction_type if exists
DROP TABLE IF EXISTS `Transaction_type`;
CREATE TABLE IF NOT EXISTS `Transaction_type` (
  `Tran_type_id` INT(11) NOT NULL,
  `Tran_type_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Tran_type_id`)
);

-- Drop Table Transaction if exists
DROP TABLE IF EXISTS `Transaction`;

-- Create Table Transaction
CREATE TABLE IF NOT EXISTS `Transaction` (
  `Tran_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Tran_type_id` INT(11) NOT NULL,
  `Listing_id` INT(11) NULL DEFAULT NULL,
  `User_id` INT(11) NULL DEFAULT NULL,
  `Quantity` INT(11) NULL,
  `Tran_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`Tran_id`),
  INDEX `listing_id` (`Listing_id`),
  INDEX `user_id` (`User_id`),
  INDEX `fk_Transaction_Transaction_type1_idx` (`Tran_type_id`),
  CONSTRAINT `claimedfooditems_ibfk_1` FOREIGN KEY (`Listing_id`) REFERENCES `item_listing` (`Listing_id`),
  CONSTRAINT `claimedfooditems_ibfk_2` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`),
  CONSTRAINT `fk_Transaction_Transaction_type1` FOREIGN KEY (`Tran_type_id`) REFERENCES `Transaction_type` (`Tran_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Drop Table notification if exists
DROP TABLE IF EXISTS `notification`;

-- Create Table notification
CREATE TABLE IF NOT EXISTS `notification` (
  `Tran_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Tran_type_id` INT(11) NOT NULL,
  `Listing_id` INT(11) NULL DEFAULT NULL,
  `User_id` INT(11) NULL DEFAULT NULL,
  `Quantity` INT(11) NULL,
  `Tran_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`Tran_id`),
  INDEX `listing_id` (`Listing_id`),
  INDEX `user_id` (`User_id`),
  INDEX `fk_Transaction_Transaction_type1_idx` (`Tran_type_id`),
  CONSTRAINT `claimedfooditems_ibfk_1` FOREIGN KEY (`Listing_id`) REFERENCES `item_listing` (`Listing_id`),
  CONSTRAINT `claimedfooditems_ibfk_2` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`),
  CONSTRAINT `fk_Transaction_Transaction_type1` FOREIGN KEY (`Tran_type_id`) REFERENCES `Transaction_type` (`Tran_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

---- Test data========================================================
-- Insert test data into Location table
INSERT INTO Location (Location_name, Address) VALUES
('Ottawa Central Market', '123 Main St, Ottawa'),
('Ottawa Community Kitchen', '456 Elm St, Ottawa'),
('Ottawa Food Bank', '789 Oak St, Ottawa');

-- Insert test data into role_type table
INSERT INTO role_type (Role_type_id, Role_type_name) VALUES
(1, 'Items Provider'),
(2, 'Consumer'),
(3, 'Charitable Organization');


-- Insert test data into role table for Food Supplier
INSERT INTO role (Role_name, Role_type) VALUES
('Retailer', 1),
('Food Manufacturer', 1),
('Farmer', 1),
('Consumer', 2),
('Charitable Organization', 3);

-- Insert test data into sysfunction table
INSERT INTO sysfunction (function_name) VALUES
('Users Registration'),
('Inventory Management'),
('Surplus Food Identification'),
('Listing Surplus Food Items'),
('Claim Food'),
('Update Inventory'),
('Purchase'),
('Subscription');

-- Insert test data into user table
INSERT INTO user (Name, Role_id, Email, Password) VALUES
('John Doe', 1, 'john@example.com', 'password'),
('Alice Smith', 2, 'alice@example.com', 'password'),
('Charity Foundation', 3, 'charity@example.com', 'password');

-- Insert test data into user_function table
INSERT INTO user_function (function_id, role_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 2),
(6, 2),
(7, 2),
(8, 3);

-- Insert test data into subscription table
INSERT INTO subscription (user_id, Notific_method, Item_location, Item_price, Item_type) VALUES
(1, 'SMS', 'Ottawa Central Market', 10.50, 1),
(2, 'Email', 'Ottawa Community Kitchen', 15.75, 2),
(3, 'Push', 'Ottawa Food Bank', 20.00, 3);

-- Insert test data into notification table
INSERT INTO notification (user_id, message, status) VALUES
(1, 'Your registration was successful.', 'Yes'),
(2, 'Your subscription has been confirmed.', 'Yes'),
(3, 'New surplus food items available for pickup.', 'No');

-- Insert test data into item table
INSERT INTO item (Item_name, Unit, Location_id, User_id, Item_type, Quantity, Expir_date, Price, Status) VALUES
('Apples', 'kg', 1, 1, 1, 50, '2024-06-01', 5.50, 'A'),  -- Available
('Bread', 'loaf', 2, 2, 2, 20, '2024-06-02', 8.75, 'N'),  -- Nearing expiration 
('Canned Soup', 'can', 3, 3, 3, 30, '2024-06-03', 12.00, 'S'), -- S-Sold
('Rice', 'kg', 1, 1, 1, 50, '2024-06-01', 10.50, 'E'); -- Excess of demand


-- Insert test data into item_listing table
INSERT INTO item_listing (Item_id, Is_donation, Discount_rate, Listing_date) VALUES
(1, 0, 0.10, '2024-06-01'),
(2, 1, NULL, '2024-06-02'),
(4, 0, 0.20, '2024-06-03');

INSERT INTO Transaction_type (Tran_type_id, Tran_type_name ) VALUES 
(1, 'Purchase'),
(2, 'Claim'),
(3, 'others');

INSERT INTO Transaction_type (Tran_type_id, Tran_type_name ) VALUES 
(1, 'Purchase'),
(2, 'Claim'),
(3, 'others');

INSERT INTO Transaction(Tran_ID, Tran_type_id, Listing_id, User_id, Quantity, Tran_date) VALUES
(1,1, 1, 1, 5, '2024-06-01'),
(2,2, 2, 2, 10, '2024-06-02'),
(3,3, 3, 3, 15, '2024-06-03');
