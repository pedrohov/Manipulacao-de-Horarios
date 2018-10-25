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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="disciplina")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String tipo;
	private Integer carga_horaria;
	private String tipo_sala_requerida;
	private Integer ano;
	@ManyToMany(mappedBy="disciplinas", fetch=FetchType.LAZY)
	private List<Curso> cursos;
	@OneToMany(mappedBy="disciplina", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Turma> turmas;
	
	public Disciplina () {
		cursos = new ArrayList<Curso>();
		turmas = new ArrayList<Turma>();
	}

	public Disciplina(Integer codigo, String nome, String tipo, Integer carga_horaria, String tipo_sala_requerida,
			Integer ano, List<Curso> cursos, List<Turma> turmas) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.carga_horaria = carga_horaria;
		this.tipo_sala_requerida = tipo_sala_requerida;
		this.ano = ano;
		this.cursos = cursos;
		this.turmas = turmas;
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
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
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

	public Integer getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(Integer carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getTipo_sala_requerida() {
		return tipo_sala_requerida;
	}

	public void setTipo_sala_requerida(String tipo_sala_requerida) {
		this.tipo_sala_requerida = tipo_sala_requerida;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public void addTurma(Turma turma) {
		if(!this.turmas.contains(turma)) {
			turma.setDisciplina(this);
			this.turmas.add(turma);
		}
	}
	
	public void removeTurma(Turma turma) {
		if(this.turmas.contains(turma)) {
			turma.setDisciplina(null);
			this.turmas.remove(turma);
		}
	}
	
	public void addCurso(Curso c) {
		if(!this.cursos.contains(c)) {
			c.addDisciplina(this);
			this.cursos.add(c);
		}
	}
	
	public void removeCurso(Curso c) {
		if(this.cursos.contains(c)) {
			c.removeDisciplina(this);
			this.cursos.remove(c);
		}
	}

	@Override
	public String toString() {
		return nome;
	}

}
