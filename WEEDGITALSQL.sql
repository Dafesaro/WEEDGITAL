-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Weedgital
-- -----------------------------------------------------
-- diseño de base datos para aplicación weedgital, proyecto del SENA

-- -----------------------------------------------------
-- Schema Weedgital
--
-- diseño de base datos para aplicación weedgital, proyecto del SENA
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Weedgital` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `Weedgital` ;

-- -----------------------------------------------------
-- Table `Weedgital`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Weedgital`.`Usuario` (
  `ID_usuario` INT NOT NULL AUTO_INCREMENT,
  `Cedula` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Fecha de nacimiento` DATE NOT NULL,
  `Mail` VARCHAR(45) NOT NULL,
  `Contaseña` VARCHAR(45) NOT NULL,
  `Rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Weedgital`.`Envio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Weedgital`.`Envio` (
  `ID_envio` INT NOT NULL AUTO_INCREMENT,
  `pais` VARCHAR(45) NOT NULL,
  `departamento` VARCHAR(45) NOT NULL,
  `Usuario_ID_usuario` INT NOT NULL,
  `ciudad/municipio` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_envio`),
  INDEX `fk_Compra_Usuario_idx` (`Usuario_ID_usuario` ASC) ,
  CONSTRAINT `fk_Compra_Usuario`
    FOREIGN KEY (`Usuario_ID_usuario`)
    REFERENCES `Weedgital`.`Usuario` (`ID_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Weedgital`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Weedgital`.`Productos` (
  ` ID_producto` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripción` VARCHAR(45) NOT NULL,
  `precio` INT NOT NULL,
  `Cantidad en stock` INT NOT NULL,
  PRIMARY KEY (` ID_producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Weedgital`.`Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Weedgital`.`Pedidos` (
  `ID_Pedidos` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `Usuario_ID_usuario` INT NOT NULL,
  `Envio_ID_envio` INT NOT NULL,
  PRIMARY KEY (`ID_Pedidos`),
  INDEX `fk_Pedidos_Usuario1_idx` (`Usuario_ID_usuario` ASC) ,
  INDEX `fk_Pedidos_Envio1_idx` (`Envio_ID_envio` ASC) ,
  CONSTRAINT `fk_Pedidos_Usuario1`
    FOREIGN KEY (`Usuario_ID_usuario`)
    REFERENCES `Weedgital`.`Usuario` (`ID_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedidos_Envio1`
    FOREIGN KEY (`Envio_ID_envio`)
    REFERENCES `Weedgital`.`Envio` (`ID_envio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Weedgital`.`Pagoyenvio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Weedgital`.`Pagoyenvio` (
  `ID_Pago/envio` INT NOT NULL AUTO_INCREMENT,
  `formapago` VARCHAR(45) NOT NULL,
  `formaenvio` VARCHAR(45) NOT NULL,
  `Pedidos_ID_Pedidos` INT NOT NULL,
  PRIMARY KEY (`ID_Pago/envio`),
  INDEX `fk_Pago/envio_Pedidos1_idx` (`Pedidos_ID_Pedidos` ASC) ,
  CONSTRAINT `fk_Pago/envio_Pedidos1`
    FOREIGN KEY (`Pedidos_ID_Pedidos`)
    REFERENCES `Weedgital`.`Pedidos` (`ID_Pedidos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Weedgital`.`Productos_has_Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Weedgital`.`Productos_has_Pedidos` (
  `Productos_ ID_producto` INT NOT NULL,
  `Pedidos_ID_Pedidos` INT NOT NULL,
  PRIMARY KEY (`Productos_ ID_producto`, `Pedidos_ID_Pedidos`),
  INDEX `fk_Productos_has_Pedidos_Pedidos1_idx` (`Pedidos_ID_Pedidos` ASC) ,
  INDEX `fk_Productos_has_Pedidos_Productos1_idx` (`Productos_ ID_producto` ASC) ,
  CONSTRAINT `fk_Productos_has_Pedidos_Productos1`
    FOREIGN KEY (`Productos_ ID_producto`)
    REFERENCES `Weedgital`.`Productos` (` ID_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_has_Pedidos_Pedidos1`
    FOREIGN KEY (`Pedidos_ID_Pedidos`)
    REFERENCES `Weedgital`.`Pedidos` (`ID_Pedidos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
