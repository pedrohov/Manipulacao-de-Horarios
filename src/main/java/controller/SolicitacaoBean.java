package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Solicitacao;
import modelo.SolicitacaoStatus;
import service.SolicitacaoService;
import util.FacesMensagens;

@ManagedBean(name="solib")
@SessionScoped
public class SolicitacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Solicitacao obj = new Solicitacao();
	private Solicitacao novo = new Solicitacao();
	private List<Solicitacao> solicitacoes;
	private SolicitacaoService service = new SolicitacaoService();
	private String status;
	
	public SolicitacaoBean() {
		setSolicitacoes(service.buscarTodos());
	}
	
	public void salvar() {
		try{
			novo.setData(new Date());
			service.salvar(novo);
			setSolicitacoes(service.buscarTodos()); 
			
			FacesMensagens.info("Registro salvo com sucesso.");
			limpar();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public void excluir() {
		try{
			service.remover(obj.getCodigo());
			setSolicitacoes(service.buscarTodos()); 
		
			FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public String editar() {
		return "cadastro_curso?faces-redirect=true";
	}
	
	public String novo() {
		limpar();
		return "cadastro_curso?faces-redirect=true";
	}
	
	private void limpar() {
		obj  = new Solicitacao();
		novo = new Solicitacao();
	}

	public Solicitacao getObj() {
		return obj;
	}

	public void setObj(Solicitacao obj) {
		this.obj = obj;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public Solicitacao getNovo() {
		return novo;
	}

	public void setNovo(Solicitacao novo) {
		this.novo = novo;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String corSolicitacao() {
		if(obj == null)
			return "";
		
		if(obj.getStatus() == SolicitacaoStatus.SOLICITADA)
			return "solicitacao-pendente";
		else if(obj.getStatus() == SolicitacaoStatus.ACEITA)
			return "solicitacao-aceita";
		else if(obj.getStatus() == SolicitacaoStatus.RECUSADA)
			return "solicitacao-recusada";
		
		return "";
	}
	
	public void recusar() {
		
		try{
			obj.setStatus(SolicitacaoStatus.RECUSADA);
			service.salvar(obj);
			setSolicitacoes(service.buscarTodos()); 
			
			FacesMensagens.info("Status alterado com sucesso.");
			limpar();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
}
