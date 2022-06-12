package br.com.senai.Naara.jpa.ejbbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.Naara.application.model.Produtos;

@Stateless //Utilizado quando você tem uma classe que representa apenas um serviço, mas sem precisar guardar informações.


public class ProdMercadoBean {
	
	@PersistenceContext //é um local onde ficam armazenados os objetos (entidades) que estão sendo manipulados pelo EntityManager corrente
	
	private EntityManager em; //EntityManager= Provê APIs para criar consultas, buscando objetos, sincronizando objetos, e inserindo objetos no banco de dados
	
	public List<ProdMercadoBean> listar() {
		return em.createQuery("SELECT c FROM prodmercado c", ProdMercadoBean.class).getResultList();
		
		//obs Naara: createQuery = usado para consultar o armazenamento de dados usando consultas de linguagem de consulta Java Persistence.
	}
}

