INSERT INTO Persona (nombre, apellido) VALUES ('Josue', 'Lopez');
INSERT INTO Empleado (persona_id, salario) VALUES (last_insert_id(), 560.7);
INSERT INTO Usuario (empleado_id, username, password, categoria) VALUES (last_insert_id(), 'josue_lopez', 'pass123', 0);

INSERT INTO organizacion (nombre_organizacion) VALUES ('Lobos');
INSERT INTO grupo (nombre_grupo, organizacion_id) VALUES ('Rojos',1);
INSERT INTO grupo (nombre_grupo, organizacion_id) VALUES ('Egipcios',1);

INSERT INTO organizacion (nombre_organizacion) VALUES ('Panteras');
--INSERT INTO grupo (nombre_grupo, organizacion_id) VALUES ('',2);

INSERT INTO persona (nombre,apellido) values ('Grechiz','Rodriguez');
INSERT INTO empleado (salario,persona_id) values (800,last_insert_id());
INSERT INTO asesor (empleado_id, grupo_id) VALUES (last_insert_id(),1);

--Insertando valores a la tabla plan
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1320,360,240,4);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1330,310,170,6);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1340,300,130,8);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1350,240,111,10);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1360,220,95,12);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1370,200,90,13);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1380,180,80,15);

insert into forma (descripcion) values ('Efectivo');
insert into forma (descripcion) values ('Tarjeta');
insert into forma (descripcion) values ('Cheque');
insert into forma (descripcion) values ('Transferencia');

insert into estrategia (descripcion) values ('Facebook');
insert into estrategia (descripcion) values ('Canal 13');
insert into estrategia (descripcion) values ('Radio Restauracion');
insert into estrategia (descripcion) values ('Radio Maranatha');
--Insertando valores a los catalogos de la reserva
insert into tutor (nombre) values ('Julio');
insert into tutoria (descripcion) values ('Unit Review');
insert into unidad (descripcion) values ('Verbo to Be');
insert into nivel (descripcion) values ('Basico');