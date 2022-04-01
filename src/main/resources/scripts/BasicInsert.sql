INSERT INTO `store`.`endereco` (`id_endereco`, `numero`, `quadra`, `rua`, `bairro`, `cidade`, `cep`) VALUES ('1', '08', '20', 'rua dos canarios', 'Helio Ponce de Arruda', 'Cuiaba', '29918224');
INSERT INTO `store`.`endereco` (`id_endereco`, `numero`, `quadra`, `rua`, `bairro`, `cidade`, `cep`) VALUES ('2', '72', '12', 'rua das calopsitas', 'Borda do Mundo', 'Varze Grande', '59022520');
INSERT INTO `store`.`endereco` (`id_endereco`, `numero`, `quadra`, `rua`, `bairro`, `cidade`, `cep`) VALUES ('3', '19', '33', 'rua violetas', 'florais cuiaba', 'Rondonopolis', '68510523');

INSERT INTO `store`.`cliente` (`id_cliente`, `nome`, `cpf`, `telefone`, `endereco`) VALUES ('1', 'Julia Maria', '07257025169', '992728989', '3');
INSERT INTO `store`.`cliente` (`id_cliente`, `nome`, `cpf`, `telefone`, `endereco`) VALUES ('2', 'Felipe', '02665693151', '992580116', '1');

INSERT INTO `store`.`fornecedor` (`nome_fornecedor`, `endereco`, `cnpj`) VALUES ('Abacaxi', 1, '89201735000197'); 
INSERT INTO `store`.`fornecedor` (`nome_fornecedor`, `endereco`, `cnpj`) VALUES ('Caju', 1, '16764981000183');