package br.com.senai.naarasouza.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import br.com.senai.naarasouza.jpa.model.Despesa;

@SuppressWarnings("serial") 
@Named("tabela")
@SessionScoped 
public class PageBean implements Serializable{
	
	private List<Despesa> despesas = new ArrayList<>();
	private ListDataModel <Despesa> despesa = new ListDataModel<>(despesas);
	
	String date;
	String desc;
	Double valor;


	Boolean back = false; 

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor1) {
		valor = valor1;
	}

	
	////////////////////////////////

	public String inserir() {
		
		Despesa d = new Despesa(); //instância da despesa
		d.setEdit(true);
		despesas.add(d);
		return null;
	}
	
	public String excluir(Despesa despesa) {
		
		despesas.remove(despesa);
		
		return null;
	}
	
	public String editar(Despesa despesa) {
		despesa.setEdit(true); 
		
		return null;
	}
	
	public String gravar (Despesa despesa) {
		despesa.setEdit(false);
		
		return null;
	}
	
	public List<Despesa> getDespesas() {
		return despesas;
	}
	
	////////////////////////////////////////
				//Teste//

	public Boolean getBack() {
		return back;
	}

	public void setBack(Boolean back) {
		this.back = back;
	}

}
