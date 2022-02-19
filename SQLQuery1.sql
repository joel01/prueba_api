create database pokemon;
use pokemon;

create database pokemon;

CREATE TABLE pokemon (
    IDPOK int NOT NULL PRIMARY KEY,
    NOMPOK nvarchar (255) NOT NULL,
	APOPOK nvarchar (255) NOT NULL,
    EXPBASPOK decimal(6,2) NOT NULL,
    ALTPOK decimal(6,2) NOT NULL,
	PESPOK decimal(6,2) NOT NULL,
	IMGFROPOK varbinary(max) NOT NULL,
	IMGATRPOK varbinary(max) NOT NULL
);


CREATE TABLE pokemon (
    IDPOK int NOT NULL,
    NOMPOK nvarchar (255) NOT NULL,
	APOPOK nvarchar (255) NOT NULL,
    EXPBASPOK decimal(6,2) NOT NULL,
    ALTPOK decimal(6,2) NOT NULL,
	PESPOK decimal(6,2) NOT NULL,
	IMGFROPOK varbinary(max) NOT NULL,
	IMGATRPOK varbinary(max) NOT NULL
);
select * from pokemon

DROP TABLE pokemon;


CREATE TABLE pokemon(
    IDPOK int PRIMARY KEY,
    NOMPOK nvarchar,
	APOPOK nvarchar,
    EXPBASPOK decimal,
    ALTPOK decimal,
	PESPOK decimal,
	IMGFROPOK nvarchar,
	IMGATRPOK nvarchar
	);


	CREATE TABLE pokemon (
    IDPOK int NOT NULL,
    NOMPOK nvarchar (255) NOT NULL,
	APOPOK nvarchar (255) NOT NULL,
    EXPBASPOK decimal(6,2) NOT NULL,
    ALTPOK decimal(6,2) NOT NULL,
	PESPOK decimal(6,2) NOT NULL,
	IMGFROPOK nvarchar (255) NOT NULL,
	IMGATRPOK nvarchar (255) NOT NULL
	);


	CREATE TABLE pokemon(
    IDPOK int NOT NULL PRIMARY KEY,
    NOMPOK nvarchar (255) NOT NULL,
	APOPOK nvarchar (255) NOT NULL,
    EXPBASPOK int NOT NULL,
    ALTPOK int NOT NULL,
	PESPOK int NOT NULL,
	IMGFROPOK nvarchar (255) NOT NULL,
	IMGATRPOK nvarchar (255) NOT NULL
	);