use planilla;
CREATE TABLE puesto(
	codigo_puesto VARCHAR(10) NOT NULL,
    nombre_puesto VARCHAR(50),
    PRIMARY KEY(codigo_puesto)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;
CREATE TABLE departamento(
	codigo_departamento VARCHAR(10) NOT NULL,
    nombre_departamento VARCHAR(50),
    PRIMARY KEY(codigo_departamento)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
CREATE TABLE concepto(
	codigo_concepto VARCHAR(10) NOT NULL,
    nombre_concepto VARCHAR(50),
    efecto_concepto VARCHAR(20),
    PRIMARY KEY(codigo_concepto)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
CREATE TABLE empleado(
	codigo_empleado VARCHAR(10) NOT NULL,
    nombre_empleado VARCHAR(50),
    sueldo_empleado FLOAT(10),
    codigo_puesto VARCHAR(10) NOT NULL,
    codigo_departamento VARCHAR(10) NOT NULL,
    PRIMARY KEY(codigo_empleado),
    CONSTRAINT FK_puestoempleado FOREIGN KEY (codigo_puesto) REFERENCES puesto (codigo_puesto),
    CONSTRAINT FK_departamentoempleado FOREIGN KEY (codigo_departamento) REFERENCES departamento (codigo_departamento)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;
CREATE TABLE usuarios(
	codigo_usuario VARCHAR(10) NOT NULL,
    nombre_usuario VARCHAR(50),
    clave_usuario VARCHAR(20),
    estado_usuario VARCHAR(20),
    codigo_empleado VARCHAR(10) NOT NULL,
    PRIMARY KEY(codigo_usuario),
    CONSTRAINT FK_codigoempleado FOREIGN KEY (codigo_empleado) REFERENCES empleado (codigo_empleado)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
CREATE TABLE encabezado_nomina(
	codigo_nomina VARCHAR(10) NOT NULL,
    fecha_inicial_nomina VARCHAR(10),
    fecha_final_nomina VARCHAR(10),
	valor_nomina FLOAT(20),
    PRIMARY KEY(codigo_nomina)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;
CREATE TABLE detalle_nomina(
	codigo_nomina VARCHAR(10) NOT NULL,
    codigo_empleado VARCHAR(10) NOT NULL,
    codigo_concepto VARCHAR(10) NOT NULL,
    valor_nomina_detalle FLOAT(20),
    PRIMARY KEY(codigo_nomina,codigo_empleado,codigo_concepto),
	CONSTRAINT FK_empleadoencabezadonomina FOREIGN KEY (codigo_empleado) REFERENCES empleado (codigo_empleado),
    CONSTRAINT FK_conceptoencabezadonomina FOREIGN KEY (codigo_concepto) REFERENCES concepto (codigo_concepto),
    CONSTRAINT FK_encabezadodetallenomina FOREIGN KEY (codigo_nomina) REFERENCES encabezado_nomina (codigo_nomina)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

