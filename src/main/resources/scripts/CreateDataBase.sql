drop database if exists store;
create database store;

use store;

drop table if exists produto;
create table produto (
    id_produto bigint primary key auto_increment,
    nome_produto varchar(50),
    codigo_produto varchar(6) not null,
    preco_compra decimal(5,2) not null,
    preco_venda decimal(5,2) not null,
    descricao varchar(100) not null,
    tamanho varchar(10),
    cor varchar(20),
    quantidade_estoque bigint not null,
    data_entrada date not null,
    fornecedor bigint not null
);

drop table if exists fornecedor; 
create table fornecedor (
    id_fornecedor bigint primary key auto_increment,
    nome_fornecedor varchar(50) not null,
    cnpj varchar(14) unique not null ,
    endereco bigint
);

drop table if exists movimentos;
create table movimentos (
    id_movimentos bigint primary key auto_increment,
    data_saida date not null,
    total_quantidade bigint not null,
    total_valor decimal(6,2) not null,
    produto bigint,
    cliente bigint
);

drop table if exists cliente;
create table cliente (
    id_cliente bigint primary key auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) unique not null,
    telefone varchar(16) not null,
    endereco bigint
);

drop table if exists endereco;
create table endereco (
    id_endereco bigint primary key auto_increment,
    numero bigint not null,
    quadra varchar(50) not null,
    rua varchar(50) not null,
    bairro varchar(50) not null,
    cidade varchar(50) not null,
    cep varchar(8) not null
);
 
alter table produto add constraint fk_produto_fornecedor
    foreign key (fornecedor)
    references fornecedor (id_fornecedor)
    on delete restrict;
 
alter table fornecedor add constraint fk_fornecedores_enderecos
    foreign key (endereco)
    references endereco (id_endereco)
    on delete restrict;
 
alter table movimentos add constraint fk_movimentos_produto
    foreign key (produto)
    references produto (id_produto)
    on delete restrict;
 
alter table movimentos add constraint fk_movimentos_cliente
    foreign key (cliente)
    references cliente (id_cliente)
    on delete restrict;
 
alter table cliente add constraint fk_movimentos_endereco
    foreign key (endereco)
    references endereco (id_endereco)
    on delete restrict;
