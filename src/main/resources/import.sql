INSERT INTO Persona (nombre, apellido) VALUES ('Josue', 'Lopez');
INSERT INTO Empleado (persona_id, salario) VALUES (last_insert_id(), 560.7);
INSERT INTO Usuario (empleado_id, username, password, categoria) VALUES (last_insert_id(), 'josue97', 'sniper2297', 1);

INSERT INTO Persona (nombre, apellido) VALUES ('Shoji', 'Uri Delgado');
INSERT INTO Empleado (persona_id, salario) VALUES (last_insert_id(), 800);
INSERT INTO Usuario (empleado_id, username, password, categoria) VALUES (last_insert_id(), 'shinololicon', 'lolisrules', 1);

INSERT INTO organizacion (nombre_organizacion) VALUES ('Lobos');
INSERT INTO grupo (nombre_grupo, organizacion_id) VALUES ('Rojos',1);

INSERT INTO Persona (nombre, apellido) VALUES ('Esmelda', 'Salmeron Palacios');
INSERT INTO Cliente (persona_id, cedula) VALUES (last_insert_id(), '0012207971005B');
INSERT INTO titular (id, direccion_trabajo, nombre_trabajo, salario, telefono_trabajo, cliente_id) VALUES ('00001',null,null,1000,null,1);
INSERT INTO alumno (id, nivel, activo, cliente_id) VALUES ('00001',1,true,1);

INSERT INTO persona (nombre,apellido) values ('Ingrid','Trujillo');
INSERT INTO empleado (salario,persona_id) values (800,last_insert_id());
INSERT INTO asesor (empleado_id, grupo_id) VALUES (last_insert_id(),1);

#Insertando valores a la tabla plan
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1360,220,95,12);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1370,200,90,13);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1380,180,80,15);

insert into forma (descripcion) values ('Efectivo');
insert into estrategia (descripcion) values ('Facebook');