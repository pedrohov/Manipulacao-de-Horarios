package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import modelo.Periodo;
import service.PeriodoService;
import util.FacesMensagens;

@ManagedBean(name="periodo")
@SessionScoped
public class PeriodoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Periodo obj = new Periodo();
	private List<Periodo> periodos;
	private PeriodoService service = new PeriodoService();
	
	public PeriodoBean() {
		setPeriodos(service.buscarTodos());
	}
	
	public void salvar() {
		try{
			service.salvar(obj);
			setPeriodos(service.buscarTodos()); 
			
			FacesMensagens.info("Registro salvo com sucesso.");
			limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public void excluir() {
		try{
			service.remover(obj.getCodigo());
			setPeriodos(service.buscarTodos()); 
		
			FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public String editar() {
		return "cadastro_periodo?faces-redirect=true";
	}
	
	public String novo() {
		limpa();
		return "cadastro_periodo?faces-redirect=true";
	}
	
	private void limpa() {
		obj = new Periodo();
	}
	
	public void preRender(ComponentSystemEvent e) {
		setPeriodos(service.buscarTodos());
	}

	public Periodo getObj() {
		return obj;
	}

	public void setObj(Periodo obj) {
		this.obj = obj;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	

}
