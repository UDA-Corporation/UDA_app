

--
-- Base de datos: mydb


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla calendario
--
DROP TABLE CALENDARIO;
CREATE TABLE calendario (
  cod NUMBER(11) NOT NULL PRIMARY KEY,
  partido_cod NUMBER(11) NOT NULL,
  CONSTRAINT CAL_PK PRIMARY KEY (cod, partido_cod)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla dueno
--
DROP TABLE DUENO;
CREATE TABLE dueno (
  dni varchar(9) NOT NULL,
  nombre varchar(45) NOT NULL,
  apellido varchar(45) NOT NULL,
  calle varchar(20) NOT NULL,
  num varchar(3) NOT NULL,
  piso varchar(3) NOT NULL,
  ciudad varchar(45) NOT NULL,
  cp varchar(9) NOT NULL,
  pais varchar(45) NOT NULL,
  equipo_cod NUMBER(11) NOT NULL,
  CONSTRAINT DUENO_PK PRIMARY KEY (dni, equipo_cod)
  );

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla equipo
--

CREATE TABLE equipo (
  cod NUMBER(11) NOT NULL,
  Nombre varchar(20) NOT NULL,
  Descripcion varchar(45) NOT NULL,
  CONSTRAINT EQUIPO_PK PRIMARY KEY (cod)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla jugador
--

CREATE TABLE jugador (
  cod NUMBER(11) NOT NULL,
  nombre varchar(20) NOT NULL,
  apellido varchar(20) NOT NULL,
  nickname varchar(15) NOT NULL,
  sueldo NUMBER(11) NOT NULL,
  calle varchar(45) NOT NULL,
  num varchar(3) NOT NULL,
  piso varchar(3) NOT NULL,
  ciudad varchar(45) NOT NULL,
  cp varchar(9) NOT NULL,
  pais varchar(45) NOT NULL,
  equipo_cod NUMBER(11) NOT NULL,
  CONSTRAINT JUGADOR_PK PRIMARY KEY (cod, equipo_cod)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla local
--

CREATE TABLE local (
  equipo_cod number(11) NOT NULL,
  partido_cod number(11) NOT NULL,
  CONSTRAINT LOCAL_PK PRIMARY KEY (equipo_cod, partido_cod)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla partido
--

CREATE TABLE partido (
  cod number(11) NOT NULL,
  lugar varchar(45) NOT NULL,
  codGanador number(11),
  empate BOOLEAN,
  fecha DATE NOT NULL,
  CONSTRAINT PARTIDO_PK PRIMARY KEY (cod)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla visitante
--

CREATE TABLE visitante (
  equipo_cod number(11) NOT NULL,
  partido_cod number(11) NOT NULL,
  CONSTRAINT VISITANTE_PK PRIMARY KEY (equipo_cod, partido_cod)
);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla calendario
--
ALTER TABLE calendario
  ADD CONSTRAINT fk_Calendario_Partido1 FOREIGN KEY (partido_cod) REFERENCES partido (cod) ON DELETE CASCADE;

--
-- Filtros para la tabla dueno
--
ALTER TABLE dueno
  ADD CONSTRAINT fk_Dueno_equipo1 FOREIGN KEY (equipo_cod) REFERENCES equipo (cod) ON DELETE CASCADE;

--
-- Filtros para la tabla jugador
--
ALTER TABLE jugador
  ADD CONSTRAINT fk_Jugador_equipo FOREIGN KEY (equipo_cod) REFERENCES equipo (cod) ON DELETE CASCADE;

--
-- Filtros para la tabla local
--
ALTER TABLE local
  ADD CONSTRAINT fk_equipo_has_Partido1_equipo1 FOREIGN KEY (equipo_cod) REFERENCES equipo (cod) ON DELETE CASCADE,
  ADD CONSTRAINT fk_equipo_has_Partido1_Partido1 FOREIGN KEY (partido_cod) REFERENCES partido (cod) ON DELETE CASCADE;

--
-- Filtros para la tabla visitante
--
ALTER TABLE visitante
  ADD CONSTRAINT fk_equipo_has_Partido_equipo1 FOREIGN KEY (equipo_cod) REFERENCES equipo (cod) ON DELETE CASCADE,
  ADD CONSTRAINT fk_equipo_has_Partido_Partido1 FOREIGN KEY (partido_cod) REFERENCES partido (cod) ON DELETE CASCADE;
ROLLBACK;

