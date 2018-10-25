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

@Entity(name="periodo")
public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private Integer semestre;
	private Integer ano;
	@OneToMany(mappedBy="periodo", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Turma> turmas;
	
	public Periodo() {
		turmas = new ArrayList<Turma>();
	}
	
	public Periodo(Integer codigo, String nome, Integer semestre, Integer ano, List<Turma> turmas) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.semestre = semestre;
		this.ano = ano;
		this.turmas = turmas;
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

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public void addTurma(Turma turma) {
		if(!this.turmas.contains(turma)) {
			turma.setPeriodo(this);
			this.turmas.add(turma);
		}
	}
	
	public void removeTurma(Turma turma) {
		if(this.turmas.contains(turma)) {
			turma.setPeriodo(null);
			this.turmas.remove(turma);
		}
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
		Periodo other = (Periodo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Periodo [nome=" + nome + ", semestre=" + semestre + ", ano=" + ano + "]";
	}
	
}
