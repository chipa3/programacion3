CREATE database Hojacalculo;
use Hojacalculo;
CREATE TABLE Usuario(
	ID_Usuario VARCHAR(10) NOT NULL,
    NombreUsuario VARCHAR(50),
	Password VARCHAR(45),
	Usuario VARCHAR(50),
    last_session datetime,
    PRIMARY KEY(ID_Usuario)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
CREATE TABLE Registros(
	ID_Registros VARCHAR(10) NOT NULL,
    Registros VARCHAR(255),
    PRIMARY KEY(ID_Registros)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;