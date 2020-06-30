INSERT INTO visitante(dni, nombrecompleto, empresa) VALUES
	('11111111H', 'usuario prueba uno', 'LinkeIT1'),
	('22222222N', 'usuario prueba dos', 'LinkeIT2'),
	('33333333J', 'usuario prueba tres', 'LinkeIT3');
  
	
INSERT INTO registro_visitas (dni, fechaentrada, fechasalida, tipovisita) VALUES
	('11111111H', '2020-06-12 09:00:00', '2020-06-12 10:00:00', 'CLIENTE'),
	('22222222N', '2020-06-12 10:00:00', '2020-06-12 10:00:00', 'COMERCIAL'),
	('22222222N', '2000-06-12 10:00:00', '2000-06-12 10:00:00', 'COMERCIAL'),
	('22222222N', '2020-06-11 10:00:00', '2020-06-11 10:00:00', 'OTROS');

INSERT INTO registro_visitas (dni, fechaentrada, tipovisita) VALUES
	('33333333J', '2020-06-12 10:00:00', 'OTROS');
