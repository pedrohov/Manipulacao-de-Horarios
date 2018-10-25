package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sala implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String tipo;
	private Integer capacidade;
	@OneToMany(mappedBy="sala", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Horario> horarios;
	
	public Sala() {
		horarios = new ArrayList<Horario>();
	}

	public Sala(Integer codigo, String nome, String tipo, Integer capacidade, List<Horario> horarios) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.horarios = horarios;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	
	public void addHorario(Horario h) {
		if(!this.horarios.contains(h)) {
			h.setSala(this);
			this.horarios.add(h);
		}
	}
	
	public void removeHorario(Horario h) {
		h.setSala(null);
		if(this.horarios.contains(h))
			this.horarios.remove(h);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

}
