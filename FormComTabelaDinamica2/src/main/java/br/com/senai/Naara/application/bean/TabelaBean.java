package br.com.senai.Naara.application.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.senai.Naara.application.model.Despesas;
import br.com.senai.Naara.jpa.ejbbean.ComandosBean;


@SuppressWarnings("serial") 
@Named("tabela")
@SessionScoped
public class TabelaBean implements Serializable{
	
	private List<Despesas> despesas = new ArrayList<>();
	
	
	private String user;
	private String senha;
	
	String data1;
	String desc1;
	Double Valor1;
	String produtos;
	
	Boolean a = false; 

	private Despesas despesas1;
	
	@EJB
	private ComandosBean comandosBean;

	public String doLogin() {
		
		if("naara".equals(user) && "123".equals(senha)) {
			return "despesas";	
		}
		return null;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public Double getValor1() {
		return Valor1;
	}

	public void setValor1(Double valor1) {
		Valor1 = valor1;
	}
	
	public String getProdutos() {
		return produtos;
	}

	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}	
	
	

	public void gravarBanco(Despesas d) {
		comandosBean.inserir(d);
		
	}
	
	public void ExcluirBanco(Despesas d) {
		comandosBean.excluir(d);
		
	}
	public void EditarBanco(Despesas d) {
		comandosBean.atualizar(d);
		
	}
	
	
	
	public String inserir(String data,String desc,Double Valor) {
		
		Despesas d = new Despesas(data,desc,Valor);
		d.setEdit(true);
		
		a =true;
		
		despesas.add(d);
		data1 = null;
		desc1 = null;
		Valor1= null;
		
		gravarBanco(d);
		
		return null;

	}
	
	public String excluir(Despesas despesa) {
		
		despesas.remove(despesa);
		
		ExcluirBanco(despesa);
		return null;
	}
	
	public String editar(Despesas despesa) {
		
		despesa.setEdit(true); 
		EditarBanco(despesa);
		return null;
	}
	
	public String gravar (Despesas despesa) {
		despesa.setEdit(false);
		
		if(despesa.getId()==null) {
			comandosBean.inserir(despesa);
		}else {
			comandosBean.atualizar(despesa);
		}
		return null;
	}
	
	public List<Despesas> getDespesas() {
		
		return despesas;
	}
	
	public Despesas getDespesas1() {
		
		if(despesas1==null) {
			despesas1 = new Despesas();
		}
		return despesas1;
	}

	public Boolean getA() {
		return a;
	}

	public void setA(Boolean a) {
		this.a = a;
	}

	
	
}
