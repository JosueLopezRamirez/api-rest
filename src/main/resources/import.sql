INSERT INTO Persona (nombre, apellido) VALUES ('Delmy', 'Cornelio');
INSERT INTO Empleado (persona_id,salario) VALUES (last_insert_id(),1000);
INSERT INTO Usuario (empleado_id, username, password, categoria) VALUES (last_insert_id(), 'delmy_cornelio', 'delmy123', 0);

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

call insert_tutor('Ana Janci');
call insert_tutor('Mario Zacasa');

call insert_tutoria('Conversation Club');
call insert_tutoria('Pronuntiation Workshop');
call insert_tutoria('Reading Workshop');
call insert_tutoria('Writing Workshop');

call insert_nivel('Intemedio');
call insert_nivel('Avanzado');

call insert_detalle_tutoria('2019-08-29','13:00:00',1,1,1,1);
call insert_detalle_tutoria('2019-08-29','14:00:00',1,2,2,1);
call insert_detalle_tutoria('2019-08-29','15:00:00',2,1,1,1);
call insert_detalle_tutoria('2019-08-29','16:00:00',2,3,3,1);
call insert_detalle_tutoria('2019-08-29','17:00:00',3,2,4,1);
call insert_detalle_tutoria('2019-08-30','07:00:00',2,3,3,1);
call insert_detalle_tutoria('2019-08-30','08:00:00',2,1,1,1);
call insert_detalle_tutoria('2019-08-30','09:00:00',3,3,2,1);
call insert_detalle_tutoria('2019-08-30','10:00:00',3,2,3,1);
call insert_detalle_tutoria('2019-08-30','11:00:00',1,2,4,1);

alter table cliente modify estado boolean default true;
-- -------------------------------------------------------------------------------
call insert_persona('Shoji Uri','Delgado');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('77201569',1);
call insert_correo('shoji_uri@gmail.com',1);
call insert_titular('00001',7000,'','','',1);
call insert_alumno('00001',1,true,1);
call insert_contrato('2019-08-25','00001','00001',1,3,4,6);
-- -------------------------------------------------------------------------------
call insert_persona('Jeffry Antonio','Mejia Ocampo');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('88856492',2);
call insert_correo('jeffry@gmail.com',2);
call insert_titular('00002',7000,'','','',2);
call insert_alumno('00002',1,true,2);
call insert_contrato('2019-08-25','00002','00002',1,3,4,7);
-- -------------------------------------------------------------------------------
call insert_persona('Stephanie del Rosario','Silva Aguilar');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('88775968',3);
call insert_correo('steph@gmail.com',3);
call insert_titular('00003',7000,'','','',3);
call insert_alumno('00003',1,true,3);
call insert_contrato('2019-08-23','00003','00003',1,2,3,5);
-- -------------------------------------------------------------------------------
call insert_persona('Michael Alejandro','Garcia Romero');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('88556981',4);
call insert_correo('michael@gmail.com',4);
call insert_titular('00004',7000,'','','',4);
call insert_alumno('00004',1,true,4);
call insert_contrato('2019-08-24','00004','00004',1,2,3,5);
-- -------------------------------------------------------------------------------
call insert_persona('Ana Maria','Aguilar');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('88326984',5);
call insert_correo('ana_maria@gmail.com',5);
call insert_titular('00005',8500,'','','',5);
call insert_alumno('00005',1,true,5);
call insert_contrato('2019-08-24','00005','00005',1,1,4,7);
-- -------------------------------------------------------------------------------
call insert_persona('Gerald José','Poveda Sánchez');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('77504896',6);
call insert_correo('geralsanchez@gmail.com',6);
call insert_titular('00006',8500,'','','',6);
call insert_alumno('00006',1,true,6);
call insert_contrato('2019-08-24','00006','00006',1,1,2,2);
-- -------------------------------------------------------------------------------
call insert_persona('Maria Esperanza','Mendoza Arce');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('82501496',7);
call insert_correo('maria@gmail.com',7);
call insert_titular('00007',9000,'','','',7);
call insert_alumno('00007',1,true,7);
call insert_contrato('2019-08-25','00007','00007',1,1,4,1);
-- -------------------------------------------------------------------------------
call insert_persona('Teresa Karina','Gaitan Hernandez');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('22252383',8);
call insert_correo('teresagaitan@gmail.com',8);
call insert_titular('00008',9000,'','','',8);
call insert_alumno('00008',1,true,8);
call insert_contrato('2019-08-25','00008','00008',1,1,4,3);
-- -------------------------------------------------------------------------------
call insert_persona('Paula Josefa','Guido Molina');
call insert_cliente('','',last_insert_id(),true);
call insert_telefono('87546328',9);
call insert_correo('paulaguido@gmail.com',9);
call insert_titular('00009',10000,'','','',9);
call insert_alumno('00009',1,true,9);
call insert_contrato('2019-08-26','00009','00009',1,1,2,1);
-- ----------------------------------------------------------------------------------
-- Alumnos que tienen reservas realizadas--------------------------------------------
-- ----------------------------------------------------------------------------------
call INSERT_RESERVA_TUTORIA('00001',1,false,false);
call INSERT_RESERVA_TUTORIA('00002',1,false,false);
call INSERT_RESERVA_TUTORIA('00003',1,false,false);
call INSERT_RESERVA_TUTORIA('00001',2,false,false);
call INSERT_RESERVA_TUTORIA('00003',2,false,false);
call INSERT_RESERVA_TUTORIA('00004',2,false,false);