package br.com.sena.naarasouza.jpa.jsfbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.naarasouza.jpa.model.Despesa;




@Stateless
public class DespesasBean implements Serializable{
	
	private List<Despesa> despesas = new ArrayList<>();
	private ListDataModel <Despesa> despesa = new ListDataModel<>(despesas);
	

	@PersistenceContext
	private EntityManager em;
	
//	public void inserir(Despesa despesa) {
//		em.persist(despesa);
//	}
//	
	
	public String inserir() {
		
		Despesa d = new Despesa(); //instância da despesa
		d.setEdit(true);
		despesas.add(d);
		return null;
	}
	

	
	public void atualizar(Despesa despesa) {
		em.merge(despesa);
	}
	
	public void excluir(Despesa despesa) {
		despesa = carregar(despesa.getId());
		em.remove(despesa);
	}
	
	public Despesa carregar(int id) {
		return em.find(Despesa.class, id);
	}
}




