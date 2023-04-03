-- MySQL Script generated by MySQL Workbench
-- Mon 27 Mar 2023 12:36:16 AM EDT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PMS
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PMS` ;

-- -----------------------------------------------------
-- Schema PMS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PMS` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `PMS` ;

-- -----------------------------------------------------
-- Table `PMS`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PMS`.`USER` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NOT NULL,
  `fullName` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `PMS`.`PROJECT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PMS`.`PROJECT` (
  `projectID` INT NOT NULL AUTO_INCREMENT,
  `projectName` VARCHAR(50) NULL DEFAULT NULL,
  `projectDescription` VARCHAR(500) NULL,
  `PROJECT_projectID` INT NULL,
  `ownerID` INT NOT NULL,
  PRIMARY KEY (`projectID`, `ownerID`),
  INDEX `fk_PROJECT_PROJECT1_idx` (`PROJECT_projectID` ASC) VISIBLE,
  INDEX `fk_PROJECT_USER1_idx` (`ownerID` ASC) VISIBLE,
  CONSTRAINT `fk_PROJECT_PROJECT1`
    FOREIGN KEY (`PROJECT_projectID`)
    REFERENCES `PMS`.`PROJECT` (`projectID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROJECT_USER1`
    FOREIGN KEY (`ownerID`)
    REFERENCES `PMS`.`USER` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `PMS`.`TASK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PMS`.`TASK` (
  `taskID` INT NOT NULL AUTO_INCREMENT,
  `taskName` VARCHAR(50) NULL DEFAULT NULL,
  `taskDescription` VARCHAR(250) NULL DEFAULT NULL,
  `taskStatus` VARCHAR(20) NULL DEFAULT NULL,
  `projectID` INT NOT NULL,
  PRIMARY KEY (`taskID`, `projectID`),
  INDEX `projectID` (`projectID` ASC) VISIBLE,
  CONSTRAINT `TASK_ibfk_1`
    FOREIGN KEY (`projectID`)
    REFERENCES `PMS`.`PROJECT` (`projectID`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;