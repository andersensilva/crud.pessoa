CREATE TABLE ENDERECO(ID INT PRIMARY KEY AUTO_INCREMENT, LOGRADOURO VARCHAR(50) NOT NULL,  CEP VARCHAR(30), NUMERO VARCHAR(30), CIDADE VARCHAR(30), PESSOA_ID INT, ENDERECO_PRINCIPAL BOOLEAN DEFAULT false) ;

CREATE SEQUENCE endereco_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999999
  START 1
  CACHE 1;
