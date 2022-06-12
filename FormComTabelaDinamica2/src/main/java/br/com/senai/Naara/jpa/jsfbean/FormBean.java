package br.com.senai.Naara.jpa.jsfbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.senai.Naara.application.model.Despesas;
import br.com.senai.Naara.jpa.ejbbean.ComandosBean;



@Named("form") //É usado parfa fazer a Inversão de Controle e Injeção de Dependências.
@RequestScoped // Um objeto que contém como informações visíveis // Um objeto que contém um método

public class FormBean implements Serializable { // O implementa Serializable basicamente serve para habilitar que um objeto possa de uma determinada classe ter seu estado persistente pela API padrão do java
	
	@EJB //ajuda fazer ligação com o banco de dados
	private ComandosBean comandosBean;
	
	@Inject //nos permite definir um ponto de injeção que é injetado durante a instanciação do bean.
	private FacesContext context; //FacesContext contém todas as informações de estado por solicitação relacionadas ao processamento de uma única solicitação JavaServer Faces e à renderização da resposta correspondente.
	
	private UIComponent searchInputText; //UIComponent é a classe base para todos os componentes da interface do usuário no JavaServer Faces.
	
	private Integer tarefaId;
	
	private Despesas despesa1;
	
	public void gravarr(AjaxBehaviorEvent event) { //AjaxBehaviorEvent representa o comportamento do componente específico para Ajax
		if(despesa1.getId()==null) {
			comandosBean.inserir(despesa1);
		}	
	}
	
	public void pesquisar(AjaxBehaviorEvent event) {
		despesa1 = comandosBean.carregar(tarefaId);
		
		if(despesa1 == null) {
			context.addMessage(searchInputText.getClientId(context),
					new FacesMessage("Despesa não encontrada"));
		}
		tarefaId = null;		
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		comandosBean.excluir(despesa1);
		despesa1 = null;
	}
	public Despesas getDespesas() {
		if(despesa1==null) {
			despesa1 = new Despesas();
		}
		return despesa1;
	}

	public UIComponent getSearchInputText() {
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public Integer getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}
	
	
	
}
