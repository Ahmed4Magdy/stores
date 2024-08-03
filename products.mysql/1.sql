CREATE TABLE stores( 

IDstores int NOT NULL AUTO_INCREMENT,
NAME    varchar(50),
CODE varchar(3),

primary key(IDstores)


);

CREATE TABLE items( 

IDitems int NOT NULL AUTO_INCREMENT,
NAME    varchar(50),
CODE varchar(3),

primary key(IDitems)


);






CREATE TABLE stores_items( 

  IDstores int NOT NULL AUTO_INCREMENT,
  IDitems int NOT NULL AUTO_INCREMENT,
 PRIMARY KEY (IDstores,IDitems),
 FOREIGN KEY (IDitems)  REFERENCES items (IDstore) ON DELETE CASCADE,
 FOREIGN KEY (IDstore) REFERENCES stores (IDstores) ON DELETE CASCADE
 );
 

