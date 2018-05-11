--Insertamos las personas y asignamos su tipo (admin o usuario)
/*Administradores*/
INSERT INTO PERSONA VALUES ('53981435S','Daniel','Barragues','Julian de Apraiz','18','6C','Vitoria-Gasteiz','01012','Espana','admin','674563897');
INSERT INTO PERSONA VALUES ('90878656R','Unai','Puelles','Avenida Gasteiz','38','4I','Vitoria-Gasteiz','01008','Espana','admin','634298463');
INSERT INTO PERSONA VALUES ('62346572H','Alejandro','Diaz de Otalora','Cercas Bajas','4','1C','Vitoria-Gasteiz','01003','Espana','admin','623142984');
INSERT INTO PERSONA VALUES ('00000000A','Admin Master',' ',' ',' ',' ',' ','0000',' ','admin',' ');

/*Duenos*/
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('34576287U','Paco','Ortiz','Juntas Generales','34','6C','Vitoria-Gasteiz','01012','España','784938237');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('38274230I','Manuel','Santidrian','Dato','14','8I','Vitoria-Gasteiz','01010','España','765438234');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('91823490O','Zuriñe','Arriba','Basoa','25','4C','Vitoria-Gasteiz','01009','España','653987675');

INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('56345632Y','Jon', 'Lazcao', 'Avenida Los Huetos', '122','7D','Bilbao','08098','España','678945674');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('52437265I','Alvaro', 'Sanchez', 'Avenida La Reina', '12','3D','Bilbao','08093','España','765482733');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('67456938W','Sebastian', 'Hidalga', 'General Guipuzkoa', '52','9D','Donostia','07098','España','673546728');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('87653149P','Manuela', 'Salgado', 'Avenida General', '33','7C','Bilbao','08018','España','765847398');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('78567456A','Antonia', 'Lopez', 'Avenida Los Huetos', '8','4I','Bilbao','08020','España','671262342');

/*Usuarios*/
INSERT INTO PERSONA VALUES ('12367487H','Marta', 'Santiago','Venezuela','24','6C','Vitoria-Gasteiz','01012','España','usuario','678549803');
INSERT INTO PERSONA VALUES ('90898776D','Sara', 'Martinez','Colombia','24','6C','Vitoria-Gasteiz','01012','España','usuario','645734543');


--Insertamos los duenos en la tabla
INSERT INTO DUENO VALUES ('34576287U');
INSERT INTO DUENO VALUES ('38274230I');
INSERT INTO DUENO VALUES ('91823490O');
INSERT INTO DUENO VALUES ('56345632Y');
INSERT INTO DUENO VALUES ('52437265I');
INSERT INTO DUENO VALUES ('67456938W');
INSERT INTO DUENO VALUES ('87653149P');
INSERT INTO DUENO VALUES ('78567456A');

--Creamos las cuentas
INSERT INTO CUENTA VALUES ('barraguesh','12345Abcde','53981435S');
INSERT INTO CUENTA VALUES ('unaipuelles','12345Abcde','90878656R');
INSERT INTO CUENTA VALUES ('alexddo','12345Abcde','62346572H');
INSERT INTO CUENTA VALUES ('a','a','00000000A');
INSERT INTO CUENTA VALUES ('sandstorm','12345Abcde','34576287U');
INSERT INTO CUENTA VALUES ('fnatic','12345Abcde','38274230I');
INSERT INTO CUENTA VALUES ('AlCapo','12345Abcde','91823490O');
INSERT INTO CUENTA VALUES ('jonlaz','12345Abcde','56345632Y');
INSERT INTO CUENTA VALUES ('alvaros','12345Abcde','52437265I');
INSERT INTO CUENTA VALUES ('sebashi','12345Abcde','67456938W');
INSERT INTO CUENTA VALUES ('manu','12345Abcde','87653149P');
INSERT INTO CUENTA VALUES ('antoniaa','12345Abcde','78567456A');
INSERT INTO CUENTA VALUES ('Destroll3r','12345Abcde','12367487H');
INSERT INTO CUENTA VALUES ('KingBronx','12345Abcde','90898776D');

--Creamos los equipos
INSERT INTO EQUIPO VALUES (1,'D3STROY','Campeones de 2015. Equipo creado por el mejor ADC de toda la liga',0,0,'34576287U');
INSERT INTO EQUIPO VALUES (2,'FNATICX','Campeones de 2016. Los mas veteranos de la liga.',0,0,'38274230I');
INSERT INTO EQUIPO VALUES (3,'BIMBA','Aun no han sido campeones pero prometen dar espectaculo.',0,0,'91823490O');
INSERT INTO EQUIPO VALUES (4,'sERDOn','Invatibles durante 5 años en counter strike',0,0,'56345632Y');
INSERT INTO EQUIPO VALUES (5,'HalWay','Nuevos en el juego pero con promesas jovenes',0,0,'52437265I');
INSERT INTO EQUIPO VALUES (6,'uGAnD','Estilo y skill juntas',0,0,'67456938W');
INSERT INTO EQUIPO VALUES (7,'xAMAZINGx','Promesas en el campo de batallas',0,0,'87653149P');
INSERT INTO EQUIPO VALUES (8,'tHeamazonX','Nuevos, pero con corazon',0,0,'78567456A');

--Insertamos los jugadores
INSERT INTO JUGADOR VALUES ('53465723E','Gam3r',2000,'Javier', 'Andoniz','Cuba','24','5D','Vitoria-Gasteiz','01567','España','690123485',1);
INSERT INTO JUGADOR VALUES ('45362756R','Ocelote',1500,'Alfredo', 'Zulueta','El retiro','24','8D','Madrid','45029','España','638980123',1);
INSERT INTO JUGADOR VALUES ('42598767R','Maneinei',1600,'Manolo', 'Maneiro','La alamea','10','9C','Bilbao','02048','España','654987123',1);
INSERT INTO JUGADOR VALUES ('12398798T','DiCapio',1300,'Sergio', 'Fuentes','Peru','22','7C','Vitoria-Gasteiz','01034','España','645782345',1);
INSERT INTO JUGADOR VALUES ('78692876G','AlmanoZXx',1400,'Alvaro', 'Heras','Santiago','55','7D','Vitoria-Gasteiz','01012','España','654980342',1);
INSERT INTO JUGADOR VALUES ('90878676V','xXTheWilXx',1500,'Abi', 'Al-Hamad','Cuchilleria','15','6I','San Sebastian','01012','España','674534902',2);
INSERT INTO JUGADOR VALUES ('14267587H','xDamnx',2400,'Maria', 'Alpino','España','71','8C','Vitoria-Gasteiz','01012','España','654345678',2);
INSERT INTO JUGADOR VALUES ('98762836O','Laurix',1600,'Laura', 'Pineiro','America','43','5I','Vitoria-Gasteiz','01012','España','652987090',2);
INSERT INTO JUGADOR VALUES ('42536712G','Sandy',1500,'Sandy', 'Alvarado','Plaza Colon','34','3D','Vitoria-Gasteiz','01012','España','666787900',2);
INSERT INTO JUGADOR VALUES ('12398792H','DestroY',2100,'Jon', 'Ferreiro','Parque de las Conchas','32','2I','Jaen','01012','España','673444532',2);
INSERT INTO JUGADOR VALUES ('90988892O','GanYxX',2200,'Jorge', 'del Pino','America Latina','34','5D','Malaga','01012','España','654567889',3);
INSERT INTO JUGADOR VALUES ('02834737I','SerZulXx',2100,'Imanol', 'Alcampo','Alfonso XI','41','4C','Murcia','12034','España','765333888',3);
INSERT INTO JUGADOR VALUES ('01928376K','AlfoXX',1800,'Alfonso', 'Figaro','Juderia','11','3I','Vitoria-Gasteiz','01034','España','654999080',3);
INSERT INTO JUGADOR VALUES ('62817267P','P3DRX',1900,'Pedro', 'Diaz','Santo Tomas','34','10D','Madrid','45034','España','654777657',3);
INSERT INTO JUGADOR VALUES ('27261283S','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','España','678554345',3);

COMMIT;