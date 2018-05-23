/*AUTHOR UDA CORPORATION
*Alejandro Diaz de Otalora
*Luis Daniel Barragues
*Unai Puelles
*/

--Insertamos las personas y asignamos su tipo (admin o usuario)
/*Administradores*/
INSERT INTO PERSONA VALUES ('53981435S','Daniel','Barragues','Julian de Apraiz','18','6C','Vitoria-Gasteiz','01012','Espana','admin','674563897');
INSERT INTO PERSONA VALUES ('90878656R','Unai','Puelles','Avenida Gasteiz','38','4I','Vitoria-Gasteiz','01008','Espana','admin','634298463');
INSERT INTO PERSONA VALUES ('62346572H','Alejandro','Diaz de Otalora','Cercas Bajas','4','1C','Vitoria-Gasteiz','01003','Espana','admin','623142984');
INSERT INTO PERSONA VALUES ('00000000A','Admin Master',' ',' ',' ',' ',' ','0000',' ','admin',' ');

/*Duenos*/
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('34576287U','Paco','Ortiz','Juntas Generales','34','6C','Vitoria-Gasteiz','01012','Espana','784938237');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('38274230I','Manuel','Santidrian','Dato','14','8I','Vitoria-Gasteiz','01010','Espana','765438234');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('91823490O','Zuri','Arriba','Basoa','25','4C','Vitoria-Gasteiz','01009','Espana','653987675');

INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('56345632Y','Jon', 'Lazcao', 'Avenida Los Huetos', '122','7D','Bilbao','08098','Espana','678945674');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('52437265I','Alvaro', 'Sanchez', 'Avenida La Reina', '12','3D','Bilbao','08093','Espana','765482733');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('67456938W','Sebastian', 'Hidalga', 'General Guipuzkoa', '52','9D','Donostia','07098','Espana','673546728');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('87653149P','Manuela', 'Salgado', 'Avenida General', '33','7C','Bilbao','08018','Espana','765847398');
INSERT INTO PERSONA(dni, nombre, apellido, calle, nro, piso, ciudad, cp, pais, tlfo) VALUES ('78567456A','Antonia', 'Lopez', 'Avenida Los Huetos', '8','4I','Bilbao','08020','Espana','671262342');

/*Usuarios*/
INSERT INTO PERSONA VALUES ('12367487H','Marta', 'Santiago','Venezuela','24','6C','Vitoria-Gasteiz','01012','Espana','usuario','678549803');
INSERT INTO PERSONA VALUES ('90898776D','Sara', 'Martinez','Colombia','24','6C','Vitoria-Gasteiz','01012','Espana','usuario','645734543');


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
INSERT INTO CUENTA VALUES ('barraguesh','?@ABCOpqrs/','53981435S');
INSERT INTO CUENTA VALUES ('unaipuelles','?@ABCOpqrs/','90878656R');
INSERT INTO CUENTA VALUES ('alexddo','?@ABCOpqrs/','62346572H');
INSERT INTO CUENTA VALUES ('a','O','00000000A');
INSERT INTO CUENTA VALUES ('sandstorm','?@ABCOpqrs/','34576287U');
INSERT INTO CUENTA VALUES ('fnatic','?@ABCOpqrs/','38274230I');
INSERT INTO CUENTA VALUES ('AlCapo','?@ABCOpqrs/','91823490O');
INSERT INTO CUENTA VALUES ('jonlaz','?@ABCOpqrs/','56345632Y');
INSERT INTO CUENTA VALUES ('alvaros','?@ABCOpqrs/','52437265I');
INSERT INTO CUENTA VALUES ('sebashi','?@ABCOpqrs/','67456938W');
INSERT INTO CUENTA VALUES ('manu','?@ABCOpqrs/','87653149P');
INSERT INTO CUENTA VALUES ('antoniaa','?@ABCOpqrs/','78567456A');
INSERT INTO CUENTA VALUES ('Destroll3r','?@ABCOpqrs/','12367487H');
INSERT INTO CUENTA VALUES ('KingBronx','?@ABCOpqrs/','90898776D');

--Creamos los equipos
INSERT INTO EQUIPO VALUES (1,'DESTROY','Campeones de 2015. Equipo creado por el mejor ADC de toda la liga',0,0,'34576287U');
INSERT INTO EQUIPO VALUES (2,'FNATICX','Campeones de 2016. Los mas veteranos de la liga.',0,0,'38274230I');
INSERT INTO EQUIPO VALUES (3,'BIMBA','Aun no han sido campeones pero prometen dar espectaculo.',0,0,'91823490O');
INSERT INTO EQUIPO VALUES (4,'SERDON','Invatibles durante 5 años en counter strike',0,0,'56345632Y');
INSERT INTO EQUIPO VALUES (5,'HALWAY','Nuevos en el juego pero con promesas jovenes',0,0,'52437265I');
INSERT INTO EQUIPO VALUES (6,'UGAND','Estilo y skill juntas',0,0,'67456938W');
INSERT INTO EQUIPO VALUES (7,'XAMAZINGX','Promesas en el campo de batallas',0,0,'87653149P');
INSERT INTO EQUIPO VALUES (8,'THEAMAZONX','Nuevos, pero con corazon',0,0,'78567456A');

--Insertamos los jugadores
INSERT INTO JUGADOR VALUES ('53465723E','Gam3r',2000,'Javier', 'Andoniz','Cuba','24','5D','Vitoria-Gasteiz','01567','Espana','690123485',1);
INSERT INTO JUGADOR VALUES ('45362756R','Ocelote',1500,'Alfredo', 'Zulueta','El retiro','24','8D','Madrid','45029','Espana','638980123',1);
INSERT INTO JUGADOR VALUES ('42598767R','Maneinei',1600,'Manolo', 'Maneiro','La alamea','10','9C','Bilbao','02048','Espana','654987123',1);
INSERT INTO JUGADOR VALUES ('12398798T','DiCapio',1300,'Sergio', 'Fuentes','Peru','22','7C','Vitoria-Gasteiz','01034','Espana','645782345',1);
INSERT INTO JUGADOR VALUES ('78692876G','AlmanoZXx',1400,'Alvaro', 'Heras','Santiago','55','7D','Vitoria-Gasteiz','01012','Espana','654980342',1);
INSERT INTO JUGADOR VALUES ('12343212D','AlmanoZXx',1400,'Alvaro', 'Heras','Santiago','55','7D','Vitoria-Gasteiz','01012','Espana','654980342',1);
INSERT INTO JUGADOR VALUES ('90878676V','xXTheWilXx',1500,'Abi', 'Al-Hamad','Cuchilleria','15','6I','San Sebastian','01012','Espana','674534902',2);
INSERT INTO JUGADOR VALUES ('14267587H','xDamnx',2400,'Maria', 'Alpino','España','71','8C','Vitoria-Gasteiz','01012','Espana','654345678',2);
INSERT INTO JUGADOR VALUES ('98762836O','Laurix',1600,'Laura', 'Pineiro','America','43','5I','Vitoria-Gasteiz','01012','Espana','652987090',2);
INSERT INTO JUGADOR VALUES ('42536712G','Sandy',1500,'Sandy', 'Alvarado','Plaza Colon','34','3D','Vitoria-Gasteiz','01012','Espana','666787900',2);
INSERT INTO JUGADOR VALUES ('12398792H','DestroY',2100,'Jon', 'Ferreiro','Parque de las Conchas','32','2I','Jaen','01012','Espana','673444532',2);
INSERT INTO JUGADOR VALUES ('42356782U','DestroY',2100,'Jon', 'Ferreiro','Parque de las Conchas','32','2I','Jaen','01012','Espana','673444532',2);
INSERT INTO JUGADOR VALUES ('90988892O','GanYxX',2200,'Jorge', 'del Pino','America Latina','34','5D','Malaga','01012','Espana','654567889',3);
INSERT INTO JUGADOR VALUES ('02834737I','SerZulXx',2100,'Imanol', 'Alcampo','Alfonso XI','41','4C','Murcia','12034','Espana','765333888',3);
INSERT INTO JUGADOR VALUES ('01928376K','AlfoXX',1800,'Alfonso', 'Figaro','Juderia','11','3I','Vitoria-Gasteiz','01034','Espana','654999080',3);
INSERT INTO JUGADOR VALUES ('62817267P','P3DRX',1900,'Pedro', 'Diaz','Santo Tomas','34','10D','Madrid','45034','Espana','654777657',3);
INSERT INTO JUGADOR VALUES ('27261283S','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',3);
INSERT INTO JUGADOR VALUES ('98767542D','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',3);
INSERT INTO JUGADOR VALUES ('92737273E','GanYxX',2200,'Jorge', 'del Pino','America Latina','34','5D','Malaga','01012','Espana','654567889',4);
INSERT INTO JUGADOR VALUES ('72164712K','SerZulXx',2100,'Imanol', 'Alcampo','Alfonso XI','41','4C','Murcia','12034','Espana','765333888',4);
INSERT INTO JUGADOR VALUES ('82638764D','AlfoXX',1800,'Alfonso', 'Figaro','Juderia','11','3I','Vitoria-Gasteiz','01034','Espana','654999080',4);
INSERT INTO JUGADOR VALUES ('90274826I','P3DRX',1900,'Pedro', 'Diaz','Santo Tomas','34','10D','Madrid','45034','Espana','654777657',4);
INSERT INTO JUGADOR VALUES ('81738368C','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',4);
INSERT INTO JUGADOR VALUES ('72164928Z','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',4);
INSERT INTO JUGADOR VALUES ('21381263D','GanYxX',2200,'Jorge', 'del Pino','America Latina','34','5D','Malaga','01012','Espana','654567889',5);
INSERT INTO JUGADOR VALUES ('78124013P','SerZulXx',2100,'Imanol', 'Alcampo','Alfonso XI','41','4C','Murcia','12034','Espana','765333888',5);
INSERT INTO JUGADOR VALUES ('21489124S','AlfoXX',1800,'Alfonso', 'Figaro','Juderia','11','3I','Vitoria-Gasteiz','01034','Espana','654999080',5);
INSERT INTO JUGADOR VALUES ('12471823Q','P3DRX',1900,'Pedro', 'Diaz','Santo Tomas','34','10D','Madrid','45034','Espana','654777657',5);
INSERT INTO JUGADOR VALUES ('34172839T','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',5);
INSERT INTO JUGADOR VALUES ('23409137M','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',5);
INSERT INTO JUGADOR VALUES ('12312s21H','GanYxX',2200,'Jorge', 'del Pino','America Latina','34','5D','Malaga','01012','Espana','654567889',6);
INSERT INTO JUGADOR VALUES ('89079812F','SerZulXx',2100,'Imanol', 'Alcampo','Alfonso XI','41','4C','Murcia','12034','Espana','765333888',6);
INSERT INTO JUGADOR VALUES ('90127121Y','AlfoXX',1800,'Alfonso', 'Figaro','Juderia','11','3I','Vitoria-Gasteiz','01034','Espana','654999080',6);
INSERT INTO JUGADOR VALUES ('25814683X','P3DRX',1900,'Pedro', 'Diaz','Santo Tomas','34','10D','Madrid','45034','Espana','654777657',6);
INSERT INTO JUGADOR VALUES ('13471346L','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',6);
INSERT INTO JUGADOR VALUES ('14789877L','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',6);
INSERT INTO JUGADOR VALUES ('16734572X','GanYxX',2200,'Jorge', 'del Pino','America Latina','34','5D','Malaga','01012','Espana','654567889',7);
INSERT INTO JUGADOR VALUES ('78947323J','SerZulXx',2100,'Imanol', 'Alcampo','Alfonso XI','41','4C','Murcia','12034','Espana','765333888',7);
INSERT INTO JUGADOR VALUES ('98754234Y','AlfoXX',1800,'Alfonso', 'Figaro','Juderia','11','3I','Vitoria-Gasteiz','01034','Espana','654999080',7);
INSERT INTO JUGADOR VALUES ('78537253W','P3DRX',1900,'Pedro', 'Diaz','Santo Tomas','34','10D','Madrid','45034','Espana','654777657',7);
INSERT INTO JUGADOR VALUES ('86452869J','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',7);
INSERT INTO JUGADOR VALUES ('96739642G','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',7);
INSERT INTO JUGADOR VALUES ('82732736P','GanYxX',2200,'Jorge', 'del Pino','America Latina','34','5D','Malaga','01012','Espana','654567889',8);
INSERT INTO JUGADOR VALUES ('21767127K','SerZulXx',2100,'Imanol', 'Alcampo','Alfonso XI','41','4C','Murcia','12034','Espana','765333888',8);
INSERT INTO JUGADOR VALUES ('12778962D','AlfoXX',1800,'Alfonso', 'Figaro','Juderia','11','3I','Vitoria-Gasteiz','01034','Espana','654999080',8);
INSERT INTO JUGADOR VALUES ('18788927T','P3DRX',1900,'Pedro', 'Diaz','Santo Tomas','34','10D','Madrid','45034','Espana','654777657',8);
INSERT INTO JUGADOR VALUES ('12739122H','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',8);
INSERT INTO JUGADOR VALUES ('87921432J','SUDOSU',2000,'Mikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',8);

/*Mismos jugadores sin equipos*/

INSERT INTO JUGADOR VALUES ('53465713E','XGam3r',2000,'xJavier', 'Andoniz','Cuba','24','5D','Vitoria-Gasteiz','01567','Espana','690123485',null);
INSERT INTO JUGADOR VALUES ('45362726R','XOcelote',1500,'xAlfredo', 'Zulueta','El retiro','24','8D','Madrid','45029','Espana','638980123',null);
INSERT INTO JUGADOR VALUES ('42598737R','xManeinei',1600,'xManolo', 'Maneiro','La alamea','10','9C','Bilbao','02048','Espana','654987123',null);
INSERT INTO JUGADOR VALUES ('12398748T','xDiCapio',1300,'xSergio', 'Fuentes','Peru','22','7C','Vitoria-Gasteiz','01034','Espana','645782345',null);
INSERT INTO JUGADOR VALUES ('78692856G','xAlmanoZXx',1400,'xAlvaro', 'Heras','Santiago','55','7D','Vitoria-Gasteiz','01012','Espana','654980342',null);
INSERT INTO JUGADOR VALUES ('90878666V','xxXTheWilXx',1500,'xAbi', 'Al-Hamad','Cuchilleria','15','6I','San Sebastian','01012','Espana','674534902',null);
INSERT INTO JUGADOR VALUES ('14267577H','xxDamnx',2400,'xMaria', 'Alpino','España','71','8C','Vitoria-Gasteiz','01012','Espana','654345678',null);
INSERT INTO JUGADOR VALUES ('98762886O','xLaurix',1600,'xLaura', 'Pineiro','America','43','5I','Vitoria-Gasteiz','01012','Espana','652987090',null);
INSERT INTO JUGADOR VALUES ('42536792G','xSandy',1500,'xSandy', 'Alvarado','Plaza Colon','34','3D','Vitoria-Gasteiz','01012','Espana','666787900',null);
INSERT INTO JUGADOR VALUES ('12398702H','xDestroY',2100,'xJon', 'Ferreiro','Parque de las Conchas','32','2I','Jaen','01012','Espana','673444532',null);
INSERT INTO JUGADOR VALUES ('90988812O','xGanYxX',2200,'xJorge', 'del Pino','America Latina','34','5D','Malaga','01012','Espana','654567889',null);
INSERT INTO JUGADOR VALUES ('02834727I','xSerZulXx',2100,'xImanol', 'Alcampo','Alfonso XI','41','4C','Murcia','12034','Espana','765333888',null);
INSERT INTO JUGADOR VALUES ('01928336K','xAlfoXX',1800,'xAlfonso', 'Figaro','Juderia','11','3I','Vitoria-Gasteiz','01034','Espana','654999080',null);
INSERT INTO JUGADOR VALUES ('62817247P','xP3DRX',1900,'xPedro', 'Diaz','Santo Tomas','34','10D','Madrid','45034','Espana','654777657',null);
INSERT INTO JUGADOR VALUES ('27261253S','xSUDOSU',2000,'xMikel', 'Alday','General Alava','54','4I','Madrid','45098','Espana','678554345',null);

COMMIT;
