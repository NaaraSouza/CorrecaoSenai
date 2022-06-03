package br.com.senai.jpa.jsfbean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sena.naarasouza.jpa.jsfbean.DespesasBean;
import br.com.senai.naarasouza.jpa.model.Despesa;

@Named("form")
@RequestScoped
public class ProdutoBean {
	
	@EJB // OBS:CRIAR PRODUTO BEAM E NO TAREFA BEAN DESPESAS BEAN
	private DespesasBean DespesaBean;

	@Inject
	private FacesContext context;
	
	private UIComponent searchInputText;
	
	private Integer tarefaId;
	
	private Despesa despesa;
	
	public void gravar(AjaxBehaviorEvent event) {
		if(despesa.getId()==null) {
			DespesaBean.inserir();
		}else {
			DespesaBean.atualizar(despesa);
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) {
		despesa = DespesaBean.carregar(tarefaId);
		
		if(despesa == null) {
			context.addMessage(searchInputText.getClientId(context),
					new FacesMessage("Tarefa n�o encontrada"));
		}
		tarefaId = null;		
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		DespesaBean.excluir(despesa);
		despesa = null;
	}
	public Despesa getTarefa() {
		if(despesa==null) {
			despesa = new Despesa();
		}
		return despesa;
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