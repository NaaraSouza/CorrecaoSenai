package br.com.senai.Naara.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //REFERE-SE A ENTIDADE
public class Despesas {
	
//Os atributos primitivos não podem ser nulos
	
private String data;
private String descricao;
private Double valor;
private Boolean edit;


@Id// PARA TRAZER UM ID AUTOMÁTICO
@GeneratedValue // serve para falar que o campo mapeado será gerado automaticamente pelo banco de dados
	
private Integer id;


public Despesas(String data, String descricao, Double valor) {
	super();
	this.data = data;
	this.descricao = descricao;
	this.valor = valor;

}

public Despesas() {
	
	
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}
public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public Double getValor() {
	return valor;
}
public void setValor(Double valor) {
	this.valor = valor;
}
public Boolean getEdit() {
	return edit;
}
public void setEdit(Boolean edit) {
	this.edit = edit;
}


	
}
