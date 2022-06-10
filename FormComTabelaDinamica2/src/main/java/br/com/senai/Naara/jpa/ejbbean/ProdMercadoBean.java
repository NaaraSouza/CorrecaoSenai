package br.com.senai.Naara.jpa.ejbbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.Naara.application.model.Produtos;

@Stateless

public class ProdMercadoBean {
	
	@PersistenceContext
	
	private EntityManager em;
	
	public List<ProdMercadoBean> listar() {
		return em.createQuery("SELECT c FROM prodmercado c", ProdMercadoBean.class).getResultList();
	}
}

