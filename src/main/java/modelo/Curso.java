package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private Integer n_periodos;
	@OneToOne(mappedBy="curso", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Coordenador coordenador;
	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
	    @JoinTable(name = "curso_disciplina",
	        joinColumns = @JoinColumn(name = "codCurso"),
	        inverseJoinColumns = @JoinColumn(name = "codDisciplina")
	    )
	private List<Disciplina> disciplinas;
	
	public Curso() {
		disciplinas = new ArrayList<Disciplina>();
	}
	
	public Curso(Integer codigo, String nome, Integer n_periodos, Coordenador coordenador) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.n_periodos = n_periodos;
		this.coordenador = coordenador;
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

	public Integer getN_periodos() {
		return n_periodos;
	}

	public void setN_periodos(Integer n_periodos) {
		this.n_periodos = n_periodos;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void addDisciplina(Disciplina d) {
		this.disciplinas.add(d);
	}
	
	public void removeDisciplina(Disciplina d) {
		this.disciplinas.remove(d);
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
		Curso other = (Curso) obj;
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
