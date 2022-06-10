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



@Named("form")
@RequestScoped
public class FormBean implements Serializable {
	
	@EJB
	private ComandosBean comandosBean;
	
	@Inject
	private FacesContext context;
	
	private UIComponent searchInputText;
	
	private Integer tarefaId;
	
	private Despesas despesa1;
	
	public void gravarr(AjaxBehaviorEvent event) {
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
