CREATE SCHEMA zeit CHARACTER SET utf8 COLLATE utf8_general_ci;

USE zeit;

CREATE TABLE usuarios (
	id_usuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(128) NOT NULL,
	email VARCHAR(128) NOT NULL,
	senha VARCHAR (200) NOT NULL
);

CREATE TABLE tarefas (
	id_tarefa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tarefa VARCHAR(100) NOT NULL,
    data_tarefa DATE,
    hora TIME,
    observacoes VARCHAR(250),
    is_concluido BOOLEAN NOT NULL,
    id_usuario INT NOT NULL,
    CONSTRAINT fk_tarefas_usuario FOREIGN KEY(id_usuario) REFERENCES usuarios(id_usuario)
);