CREATE TABLE IF NOT EXISTS USERS(
  USERNAME VARCHAR(50) NOT NULL PRIMARY KEY,
  PASSWORD VARCHAR(50) NOT NULL,
  NAME VARCHAR(50) NOT NULL,
  LASTNAME VARCHAR(50) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  ENABLED BOOLEAN NOT NULL,
  ADDRESS VARCHAR(255),
  CITY VARCHAR(255),
  ZIPCODE VARCHAR(255)
);

CREATE UNIQUE INDEX ON USERS(USERNAME);

CREATE TABLE IF NOT EXISTS AUTHORITIES (
  USERNAME VARCHAR(50) NOT NULL,
  AUTHORITY VARCHAR(50) NOT NULL,
  CONSTRAINT FK_AUTHORITIES_USERS FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME)
);

CREATE UNIQUE INDEX IF NOT EXISTS IX_AUTH_USERNAME ON AUTHORITIES (USERNAME,AUTHORITY);

CREATE TABLE IF NOT EXISTS CATEGORIES (
  ID LONG NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(255) NOT NULL,
  DELETED BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ITEMS (
  ID LONG NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(255) NOT NULL,
  PRICE DOUBLE NOT NULL,
  SHORT_DESCRIPTION VARCHAR(255) NOT NULL,
  FULL_DESCRIPTION VARCHAR(255) NOT NULL,
  DELETED BOOLEAN NOT NULL DEFAULT FALSE,
  CATEGORY_ID LONG NOT NULL,
  CONSTRAINT FK_ITEM_CATEGORY FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORIES(ID)
);

CREATE TABLE IF NOT EXISTS ORDERS (
    ID LONG NOT NULL PRIMARY KEY AUTO_INCREMENT,
    SUMMARY DOUBLE NOT NULL,
    DELETED BOOLEAN NOT NULL DEFAULT FALSE,
    DATE DATE NOT NULL,
    STATE INTEGER NOT NULL,
    USER_ID VARCHAR(255),
    CUSTOMER_NAME VARCHAR(50) NOT NULL,
    CUSTOMER_LASTNAME VARCHAR(50) NOT NULL,
    CUSTOMER_EMAIL VARCHAR(100) NOT NULL,
    CUSTOMER_ADDRESS VARCHAR(255),
    CUSTOMER_CITY VARCHAR(255),
    CUSTOMER_ZIPCODE VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS ORDERITEMS (
  ID LONG NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(255) NOT NULL,
  PRICE DOUBLE NOT NULL,
  QUANITY LONG NOT NULL,
  SHORT_DESCRIPTION VARCHAR(255) NOT NULL,
  FULL_DESCRIPTION VARCHAR(255) NOT NULL,
  DELETED BOOLEAN NOT NULL DEFAULT FALSE,
  CATEGORY_ID LONG NOT NULL,
  ORDER_ID LONG NOT NULL,
  CONSTRAINT FK_CATEGORY FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORIES(ID),
  CONSTRAINT FK_ORDER FOREIGN KEY(ORDER_ID) REFERENCES ORDERS(ID)
);

CREATE TABLE IF NOT EXISTS CITY (
    ID LONG NOT NULL PRIMARY KEY AUTO_INCREMENT,
    DELETED BOOLEAN NOT NULL DEFAULT FALSE,
    CITY VARCHAR(255),
    ZIPCODE VARCHAR(255)
);

ALTER TABLE ITEMS ADD ORDER_ID LONG;
ALTER TABLE PUBLIC.ITEMS ADD FOREIGN KEY(ORDER_ID) REFERENCES PUBLIC.ORDERS(ID);
ALTER TABLE PUBLIC.ORDERS ADD FOREIGN KEY(USER_ID) REFERENCES PUBLIC.USERS(USERNAME);