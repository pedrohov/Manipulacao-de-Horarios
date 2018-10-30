package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import modelo.Pessoa;
import modelo.Sexo;
import service.PessoaService;
import util.FacesMensagens;

@ManagedBean(name="usuario")
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Pessoa obj = new Pessoa();
	private List<Pessoa> usuarios;
	private PessoaService service = new PessoaService();
	private String permissao;
	
	public UsuarioBean() {
		setUsuarios(service.buscarTodos());
		obj.setSexo(Sexo.MASCULINO);
		permissao = "DE";
	}
	
	public void salvar() {
		try{			
			service.salvar(obj);
			setUsuarios(service.buscarTodos()); 
			
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
			setUsuarios(service.buscarTodos()); 
		
			FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public String editar() {
		return "cadastro_usuario?faces-redirect=true";
	}
	
	public String novo() {
		limpar();
		return "cadastro_usuario?faces-redirect=true";
	}
	
	private void limpar() {
		obj = new Pessoa();
		obj.setSexo(Sexo.MASCULINO);
	}
	
	public void preRender(ComponentSystemEvent e) {
		setUsuarios(service.buscarTodos());
	}
	
	public Sexo[] getSexos() {
        return Sexo.values();
    }

	public Pessoa getObj() {
		return obj;
	}

	public void setObj(Pessoa obj) {
		this.obj = obj;
	}

	public List<Pessoa> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Pessoa> usuarios) {
		this.usuarios = usuarios;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

}
