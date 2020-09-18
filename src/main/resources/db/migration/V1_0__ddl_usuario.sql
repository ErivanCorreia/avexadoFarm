CREATE SCHEMA avexado;

CREATE TABLE avexado.t_usuario (
	id BIGSERIAL not null,
	email VARCHAR(128) not null,
	login VARCHAR(32) not null,
	senha VARCHAR(64) not null,
	CONSTRAINT pk_t_usuario PRIMARY KEY(id)
);

CREATE TABLE avexado.t_perfil_usuario (
    id_usuario INTEGER NOT NULL,
    perfil VARCHAR(128) NOT NULL,
    CONSTRAINT fk_t_perfil_usuario_id_usuario FOREIGN KEY(id_usuario) REFERENCES avexado.t_usuario(id)
);
