package br.com.senai.Naara.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.Naara.application.model.Despesas;

@Stateless
public class ComandosBean {

	//É o que gerencia o banco de Dados
	
		@PersistenceContext
		private EntityManager em;
		
		//Métodos que influenciam no Banco de Dados
		
		public void inserir(Despesas despesas) {
			em.persist(despesas);
		}
		
		public void atualizar(Despesas despesas) {
			em.merge(despesas);
		}
		
		public void excluir(Despesas despesas) {
			despesas = carregar(despesas.getId());
			em.remove(despesas);
		}
		
		public Despesas carregar(int id) {
			return em.find(Despesas.class, id);
		}

	
	
}
