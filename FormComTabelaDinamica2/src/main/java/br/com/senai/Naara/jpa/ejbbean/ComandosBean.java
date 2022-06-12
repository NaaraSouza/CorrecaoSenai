package br.com.senai.Naara.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.Naara.application.model.Despesas;

@Stateless //Utilizado quando você tem uma classe que representa apenas um serviço, mas sem precisar guardar informações.
public class ComandosBean {

	//É o que gerencia o banco de Dados
	
		@PersistenceContext //é um local onde ficam armazenados os objetos (entidades) que estão sendo manipulados pelo EntityManager corrente
		private EntityManager em; // EntityManager= Provê APIs para criar consultas, buscando objetos, sincronizando objetos, e inserindo objetos no banco de dados
		
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
