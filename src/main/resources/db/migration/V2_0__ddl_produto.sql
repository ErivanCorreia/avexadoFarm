CREATE TABLE avexado.t_produto (
	id BIGSERIAL not null,
	nome VARCHAR(128) not null,
	descricao VARCHAR(255),
	tipo VARCHAR(128) not null,
	CONSTRAINT pk_t_produto PRIMARY KEY(id)
);
