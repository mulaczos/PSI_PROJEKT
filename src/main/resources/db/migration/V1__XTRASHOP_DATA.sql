
INSERT INTO CATEGORIES(NAME) VALUES ('Home&Garden');
INSERT INTO CATEGORIES(NAME) VALUES ('Electronic');
INSERT INTO CATEGORIES(NAME) VALUES ('Fashion');
INSERT INTO CATEGORIES(NAME) VALUES ('Business');
INSERT INTO CATEGORIES(NAME) VALUES ('Music');

INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('deskorolka', 250, 1,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('hulajnoga', 7, 1,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('kamień', 55, 1,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('nożyczki', 87, 2,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('ania', 52, 2,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('kwiatek', 22, 2,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('stół', 432, 3,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('krzesło', 50, 3,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('żelazko', 32, 3,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('antryj', 234, 3,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('małpa', 11, 4,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('adam', 11, 4,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('japko', 558, 4,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('laptop', 437, 4,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('telefon', 332, 4,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('wiosło', 34, 5,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('koło', 722, 5,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('rzutnik', 54, 5,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('okulary', 654, 5,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('masło', 2, 5,'This text is full description' , 'This is a short description');
INSERT INTO ITEMS(NAME, PRICE, CATEGORY_ID, FULL_DESCRIPTION, SHORT_DESCRIPTION) VALUES ('magaryna', 32, 5,'This text is full description' , 'This is a short description');

INSERT INTO USERS(USERNAME, PASSWORD, ENABLED, NAME, LASTNAME, EMAIL, ZIPCODE, ADDRESS, CITY ) VALUES ('admin', 'admin', TRUE,'administrator','adminek', 'admin@domain.com','12-345', 'ADDRESS', 'Kraków');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES ('admin', 'ADMIN');
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED, NAME, LASTNAME, EMAIL, ZIPCODE, ADDRESS, CITY ) VALUES ('mod', 'mod', TRUE,'mod','mod', 'mod@domain.com','00-001', 'ADDRESS', 'Warszawa');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES ('mod', 'MODERATOR');
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED, NAME, LASTNAME, EMAIL, ZIPCODE, ADDRESS, CITY ) VALUES ('user', 'user', TRUE,'user','user', 'user@domain.com','41-908', 'ADDRESS', 'Bytom');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES ('user', 'USER');

INSERT INTO CITY(ZIPCODE, CITY) VALUES ('00-001', 'Warszawa');
INSERT INTO CITY(ZIPCODE, CITY) VALUES ('12-345', 'Kraków');
INSERT INTO CITY(ZIPCODE, CITY) VALUES ('41-908', 'Bytom');
INSERT INTO CITY(ZIPCODE, CITY) VALUES ('22-222', 'Katowice');
INSERT INTO CITY(ZIPCODE, CITY) VALUES ('33-333', 'Bydgoszcz');