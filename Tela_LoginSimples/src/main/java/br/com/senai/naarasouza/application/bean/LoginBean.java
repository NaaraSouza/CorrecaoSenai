package br.com.senai.naarasouza.application.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



@Named
@RequestScoped
public class LoginBean implements Serializable {

	private String nome;
	private String senha;
	
	@PostConstruct // @PostConstruct tem que ser publica e ter um retorno do tipo void
	public void onCreate() {
		System.out.println("Bean criado");
	}
	
	@PreDestroy //@PreDestroy ciclo de vida de um bean gerenciado pelo CDI 
	public void onDestroy() {
		System.out.println("Bean será Destruido");
	}
	
	public String doLogin() {
		if("abc".equals(nome) && "123".equals(senha)) {
			return "sucesso";
		}
		return null;
	}
	
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
