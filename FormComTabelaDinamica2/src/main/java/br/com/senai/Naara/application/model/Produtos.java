package br.com.senai.Naara.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//Método que faz a união/junção das tabelas
@Entity //é utilizada para informar que uma classe também é uma entidade.

public class Produtos {
	
	@Id // é utilizada também para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária da respectiva tabela no banco de dados.
	@GeneratedValue // serve para falar que o campo mapeado será gerado automaticamente pelo banco de dados
	
	//declarando variáveis
	private Integer id;
	private String nome;
	private Double valor;
	
	
	//fazendo os getters e setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
