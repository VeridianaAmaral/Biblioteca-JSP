create table usuario(
	id bigserial not null,
	ativo boolean,
	cpf CHARACTER varying(30),
	data_nascimento date,
	email character VARYING(50),
	login CHARACTER VARYING(50),
	nome CHARACTER VARYING(255),
	password CHARACTER varying(50),
	CONSTRAINT usuario_pkey PRIMARY key (id)					
);