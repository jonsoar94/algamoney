CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Jonatan José Soares', 'Avenida 21 de Janeiro', '3180', 'Casa', 'Centro', '89107-000', 'Pomerode', 'Santa Catarina', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Renan R. Konell', 'Dr. Wunderwald', '480', 'Casa', 'Wunderwald', '89107-000', 'Pomerode', 'Santa Catarina', false);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Stefani H. Rusch', 'Avenida 21 de Janeiro', '3180', 'Casa', 'Centro', '89107-000', 'Pomerode', 'Santa Catarina', true);