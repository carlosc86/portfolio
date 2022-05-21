-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PORTFOLIO
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PORTFOLIO
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PORTFOLIO` ;
USE `PORTFOLIO` ;

-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Personas` (
  `idPersona` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Visitantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Visitantes` (
  `idVisitante` INT NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `Personas_idPersona` INT NOT NULL,
  PRIMARY KEY (`idVisitante`, `Personas_idPersona`),
  INDEX `fk_Visitantes_Personas1_idx` (`Personas_idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_Visitantes_Personas1`
    FOREIGN KEY (`Personas_idPersona`)
    REFERENCES `PORTFOLIO`.`Personas` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Mensajes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Mensajes` (
  `idMensaje` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `fecha` DATE NOT NULL,
  `leido` TINYINT NOT NULL,
  `cuerpo` MEDIUMTEXT NOT NULL,
  `Visitantes_idVisitante` INT NOT NULL,
  PRIMARY KEY (`idMensaje`, `Visitantes_idVisitante`),
  INDEX `fk_Mensajes_Visitantes1_idx` (`Visitantes_idVisitante` ASC) VISIBLE,
  CONSTRAINT `fk_Mensajes_Visitantes1`
    FOREIGN KEY (`Visitantes_idVisitante`)
    REFERENCES `PORTFOLIO`.`Visitantes` (`idVisitante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Privilegios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Privilegios` (
  `idPrivilegio` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idPrivilegio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Usuarios` (
  `idUsuario` INT NOT NULL,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `privilegios` VARCHAR(45) NOT NULL,
  `fechaUltimoAcceso` DATE NULL,
  `Personas_idPersona` INT NOT NULL,
  `Privilegios_idPrivilegio` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `Personas_idPersona`, `Privilegios_idPrivilegio`),
  UNIQUE INDEX `nombreUsuario_UNIQUE` (`nombreUsuario` ASC) VISIBLE,
  INDEX `fk_Usuarios_Personas_idx` (`Personas_idPersona` ASC) VISIBLE,
  INDEX `fk_Usuarios_Privilegios1_idx` (`Privilegios_idPrivilegio` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_Personas`
    FOREIGN KEY (`Personas_idPersona`)
    REFERENCES `PORTFOLIO`.`Personas` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_Privilegios1`
    FOREIGN KEY (`Privilegios_idPrivilegio`)
    REFERENCES `PORTFOLIO`.`Privilegios` (`idPrivilegio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
PACK_KEYS = DEFAULT;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`TiposMedioContacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`TiposMedioContacto` (
  `idTipoMedioContacto` INT NOT NULL,
  `empresa` VARCHAR(45) NOT NULL,
  `urlIcono` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`idTipoMedioContacto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`MediosContacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`MediosContacto` (
  `idMedioContacto` INT NOT NULL,
  `link` VARCHAR(100) NOT NULL,
  `Usuarios_idUsuario` INT NOT NULL,
  `TiposMedioContacto_idTipoMedioContacto` INT NOT NULL,
  PRIMARY KEY (`idMedioContacto`, `TiposMedioContacto_idTipoMedioContacto`, `Usuarios_idUsuario`),
  INDEX `fk_MediosContacto_Usuarios1_idx` (`Usuarios_idUsuario` ASC) VISIBLE,
  INDEX `fk_MediosContacto_TiposMedioContacto1_idx` (`TiposMedioContacto_idTipoMedioContacto` ASC) VISIBLE,
  CONSTRAINT `fk_MediosContacto_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuario`)
    REFERENCES `PORTFOLIO`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MediosContacto_TiposMedioContacto1`
    FOREIGN KEY (`TiposMedioContacto_idTipoMedioContacto`)
    REFERENCES `PORTFOLIO`.`TiposMedioContacto` (`idTipoMedioContacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Secciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Secciones` (
  `idSeccion` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `texto` VARCHAR(1024) NULL,
  `urlImagen` VARCHAR(45) NULL,
  `colorFondo` VARCHAR(9) NULL,
  `colorTexto` VARCHAR(9) NULL,
  `Usuarios_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idSeccion`, `Usuarios_idUsuario`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  INDEX `fk_Secciones_Usuarios1_idx` (`Usuarios_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Secciones_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuario`)
    REFERENCES `PORTFOLIO`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Instituciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Instituciones` (
  `idInstitucion` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `urlIcono` VARCHAR(75) NULL,
  PRIMARY KEY (`idInstitucion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Estudios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Estudios` (
  `idEstudio` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `fechaInicio` DATE NULL,
  `fechaFin` DATE NULL,
  `Usuarios_idUsuario` INT NOT NULL,
  `Instituciones_idInstitucion` INT NOT NULL,
  PRIMARY KEY (`idEstudio`, `Usuarios_idUsuario`, `Instituciones_idInstitucion`),
  INDEX `fk_Estudios_Usuarios1_idx` (`Usuarios_idUsuario` ASC) VISIBLE,
  INDEX `fk_Estudios_Instituciones1_idx` (`Instituciones_idInstitucion` ASC) VISIBLE,
  CONSTRAINT `fk_Estudios_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuario`)
    REFERENCES `PORTFOLIO`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estudios_Instituciones1`
    FOREIGN KEY (`Instituciones_idInstitucion`)
    REFERENCES `PORTFOLIO`.`Instituciones` (`idInstitucion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Habilidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Habilidades` (
  `idHabilidad` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(100) NULL,
  `porcentaje` INT NOT NULL,
  `Usuarios_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idHabilidad`, `Usuarios_idUsuario`),
  INDEX `fk_Habilidades_Usuarios1_idx` (`Usuarios_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Habilidades_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuario`)
    REFERENCES `PORTFOLIO`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Empresas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Empresas` (
  `idEmpresa` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `urlLogo` VARCHAR(45) NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`TiposTrabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`TiposTrabajo` (
  `idTipoTrabajo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoTrabajo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Trabajos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Trabajos` (
  `idTrabajo` INT NOT NULL,
  `puesto` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `Usuarios_idUsuario` INT NOT NULL,
  `Empresas_idEmpresa` INT NOT NULL,
  `TiposTrabajo_idTipoTrabajo` INT NOT NULL,
  PRIMARY KEY (`idTrabajo`, `Usuarios_idUsuario`, `Empresas_idEmpresa`, `TiposTrabajo_idTipoTrabajo`),
  INDEX `fk_Trabajos_Usuarios1_idx` (`Usuarios_idUsuario` ASC) VISIBLE,
  INDEX `fk_Trabajos_Empresas1_idx` (`Empresas_idEmpresa` ASC) VISIBLE,
  INDEX `fk_Trabajos_TiposTrabajo1_idx` (`TiposTrabajo_idTipoTrabajo` ASC) VISIBLE,
  CONSTRAINT `fk_Trabajos_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuario`)
    REFERENCES `PORTFOLIO`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trabajos_Empresas1`
    FOREIGN KEY (`Empresas_idEmpresa`)
    REFERENCES `PORTFOLIO`.`Empresas` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trabajos_TiposTrabajo1`
    FOREIGN KEY (`TiposTrabajo_idTipoTrabajo`)
    REFERENCES `PORTFOLIO`.`TiposTrabajo` (`idTipoTrabajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`Proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`Proyectos` (
  `idProyecto` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(1024) NOT NULL,
  `fecha` DATE NULL,
  `url` VARCHAR(45) NULL,
  `Usuarios_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idProyecto`, `Usuarios_idUsuario`),
  INDEX `fk_Proyectos_Usuarios1_idx` (`Usuarios_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Proyectos_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuario`)
    REFERENCES `PORTFOLIO`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PORTFOLIO`.`ImagenesProyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PORTFOLIO`.`ImagenesProyecto` (
  `idImagenProyecto` INT NOT NULL,
  `urlImagen` VARCHAR(75) NOT NULL,
  `pieImagen` VARCHAR(100) NULL,
  `Proyectos_idProyecto` INT NOT NULL,
  PRIMARY KEY (`idImagenProyecto`, `Proyectos_idProyecto`),
  INDEX `fk_ImagenesProyecto_Proyectos1_idx` (`Proyectos_idProyecto` ASC) VISIBLE,
  CONSTRAINT `fk_ImagenesProyecto_Proyectos1`
    FOREIGN KEY (`Proyectos_idProyecto`)
    REFERENCES `PORTFOLIO`.`Proyectos` (`idProyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
