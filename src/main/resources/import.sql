INSERT INTO Persona (nombre, apellido) VALUES ('Josue', 'Lopez');
INSERT INTO Empleado (persona_id, salario) VALUES (last_insert_id(), 560.7);
INSERT INTO Usuario (empleado_id, username, password, categoria) VALUES (last_insert_id(), 'josue97', 'sniper2297', 1);

INSERT INTO Persona (nombre, apellido) VALUES ('Shoji', 'Uri Delgado');
INSERT INTO Empleado (persona_id, salario) VALUES (last_insert_id(), 800);
INSERT INTO Usuario (empleado_id, username, password, categoria) VALUES (last_insert_id(), 'shinololicon', 'lolisrules', 1);

INSERT INTO Persona (nombre, apellido) VALUES ('Esmelda', 'Salmeron Palacios');
INSERT INTO Empleado (persona_id, salario) VALUES (last_insert_id(), 560.7);
INSERT INTO Usuario (empleado_id, username, password, categoria) VALUES (last_insert_id(), 'esmelda', 'holabbuwu', 0);

#Insertando valores a la tabla plan
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1360,220,95,12);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1370,200,90,13);
INSERT INTO Plan (valor_total,inscripcion,costo_mensual,cantidad_meses) VALUES(1380,180,80,15);