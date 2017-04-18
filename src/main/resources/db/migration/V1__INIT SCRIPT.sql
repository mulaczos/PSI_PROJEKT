create table if not exists users(
  username varchar(50) not null primary key,
  password varchar(50) not null,
  name varchar(50) not null,
  lastname varchar(50) not null,
  email varchar(100) not null,
  enabled boolean not null
);

create table if not exists authorities (
  username varchar(50) not null,
  authority varchar(50) not null,
  constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index if not exists ix_auth_username on authorities (username,authority);

INSERT INTO USERS(USERNAME, PASSWORD, ENABLED, NAME, LASTNAME, EMAIL) VALUES ('admin', 'admin', TRUE,'Administrator',' ', '');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES ('admin', 'ADMIN');