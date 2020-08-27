CREATE DATABASE `custo_produtos`;

CREATE TABLE `custo_produtos`.`mp` (
  `idMP` INT NOT NULL AUTO_INCREMENT,
  `codigoMP` VARCHAR(10) NULL,
  `descricaoMP` VARCHAR(45) NULL,
  `custoMP` FLOAT(10,2) NULL,
  PRIMARY KEY (`idMP`));

/* "Importar Excel para tabela `custo_produtos`.`mp` - Importação dos Dados via CSV" */

SET GLOBAL local_infile = 1;

LOAD DATA LOCAL INFILE 'C:\\Users\\vep08.FESTPANDOMAIN\\Desktop\\Tabela_MP.csv'
INTO TABLE custo_produtos.mp
CHARACTER SET latin1
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
(idMP, codigoMP, descricaoMP, custoMP);

/* "Exportar a tabela `custo_produtos`.`mp` via Excel - Exportação dos Dados via CSV" */

SELECT * FROM custo_produtos.mp 
INTO OUTFILE 'C:\\Temp\\teste.csv'
FIELDS ENCLOSED BY '"' 
TERMINATED BY ';' 
ESCAPED BY '"' 
LINES TERMINATED BY '\r\n'; 

CREATE TABLE `custo_produtos`.`recurso` (
  `idRecurso` INT NOT NULL AUTO_INCREMENT,
  `descricaoRecurso` VARCHAR(45) NULL,
  `custoRecurso` FLOAT(10,2) NULL,
  PRIMARY KEY (`idRecurso`));

CREATE TABLE `custo_produtos`.`receita` (
  `idReceita` INT NOT NULL AUTO_INCREMENT,
  `descricaoReceita` VARCHAR(45) NULL,
  `rendLiqReceita` FLOAT(10,2) NULL,
  `rendBrutoReceita` FLOAT(10,2) NULL,
  `perdaReceita` FLOAT(10,2) NULL,
  `custoReceita` FLOAT(10,2) NULL,
  `dataReceita` DATE NULL,
  PRIMARY KEY (`idReceita`));
  
  CREATE TABLE `custo_produtos`.`produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `descricaoProduto` VARCHAR(45) NULL,
  `baseCalcProduto` FLOAT(10,2) NULL,
  `gramaturaProduto` FLOAT(10,2) NULL,
  `rendBrutoProduto` FLOAT(10,2) NULL,
  `custoProduto` FLOAT(10,2) NULL,
  `dataProduto` DATE NULL,
  PRIMARY KEY (`idProduto`));
  
CREATE TABLE `custo_produtos`.`ingrediente` (
  `id_MP_Receita_PK` INT NOT NULL AUTO_INCREMENT,
  `idMP` INT NULL,
  `idReceita` INT NULL,
  `custoMP` FLOAT(10,2) NULL,
  `qtIngredienteBruto` FLOAT(10,2) NULL,
  `perdaIngrediente` FLOAT(10,2) NULL,
  `qtIngredienteLiquido` FLOAT(10,2) NULL,
  `custoIngrediente` FLOAT(10,2) NULL,
  `porcenIngrediente` FLOAT(10,2) NULL,
  PRIMARY KEY (`id_MP_Receita_PK`),
  INDEX `FK_INGREDIENTE_MP_idx` (`idMP` ASC) VISIBLE,
  INDEX `FK_INGREDIENTE_RECEITA_idx` (`idReceita` ASC) VISIBLE,
  CONSTRAINT `FK_INGREDIENTE_MP`
    FOREIGN KEY (`idMP`)
    REFERENCES `custo_produtos`.`mp` (`idMP`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_INGREDIENTE_RECEITA`
    FOREIGN KEY (`idReceita`)
    REFERENCES `custo_produtos`.`receita` (`idReceita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `custo_produtos`.`utilidade` (
  `id_Produto_Recurso_PK` INT NOT NULL AUTO_INCREMENT,
  `idProduto` INT NULL,
  `idRecurso` INT NULL,
  PRIMARY KEY (`id_Produto_Recurso_PK`),
  INDEX `FK_PRODUTO_UTILIDADE_idx` (`idProduto` ASC) VISIBLE,
  INDEX `FK_RECURSO_UTILIDADE_idx` (`idRecurso` ASC) VISIBLE,
  CONSTRAINT `FK_PRODUTO_UTILIDADE`
    FOREIGN KEY (`idProduto`)
    REFERENCES `custo_produtos`.`produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_RECURSO_UTILIDADE`
    FOREIGN KEY (`idRecurso`)
    REFERENCES `custo_produtos`.`recurso` (`idRecurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `custo_produtos`.`embalagem` (
  `id_Produto_MP_PK` INT NOT NULL AUTO_INCREMENT,
  `idProduto` INT NULL,
  `idMP` INT NULL,
  `custoMP` FLOAT(10,2) NULL,
  `qtEmbalagem` FLOAT(10,2) NULL,
  `custoEmbalagem` FLOAT(10,2) NULL,
  PRIMARY KEY (`id_Produto_MP_PK`),
  INDEX `FK_PRODUTO_EMBALAGEM_idx` (`idProduto` ASC) VISIBLE,
  INDEX `FK_MP_EMBALAGEM_idx` (`idMP` ASC) VISIBLE,
  CONSTRAINT `FK_PRODUTO_EMBALAGEM`
    FOREIGN KEY (`idProduto`)
    REFERENCES `custo_produtos`.`produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_MP_EMBALAGEM`
    FOREIGN KEY (`idMP`)
    REFERENCES `custo_produtos`.`mp` (`idMP`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `custo_produtos`.`teste` (
  `id_Produto_Receita_PK` INT NOT NULL AUTO_INCREMENT,
  `idProduto` INT NULL,
  `idReceita` INT NULL,
  `gramaturaTeste` FLOAT(10,2) NULL,
  PRIMARY KEY (`id_Produto_Receita_PK`),
  INDEX `FK_PRODUTO_TESTE_idx` (`idProduto` ASC) VISIBLE,
  INDEX `FK_RECEITA_TESTE_idx` (`idReceita` ASC) VISIBLE,
  CONSTRAINT `FK_PRODUTO_TESTE`
    FOREIGN KEY (`idProduto`)
    REFERENCES `custo_produtos`.`produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_RECEITA_TESTE`
    FOREIGN KEY (`idReceita`)
    REFERENCES `custo_produtos`.`receita` (`idReceita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);