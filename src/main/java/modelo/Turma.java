package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@ManyToOne
	@JoinColumn(name="codDisciplina")
	private Disciplina disciplina;
	@ManyToOne
	@JoinColumn(name="codProfessor")
	private Professor professor;
	@ManyToOne
	@JoinColumn(name="codPeriodo")
	private Periodo periodo;
	@OneToMany(mappedBy="turma", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Horario> horarios;
	
	public Turma() {
		horarios = new ArrayList<Horario>();
	}

	public Turma(Integer codigo, Disciplina disciplina, Professor professor, Periodo periodo,
			List<Horario> horarios) {
		super();
		this.codigo = codigo;
		this.disciplina = disciplina;
		this.professor = professor;
		this.periodo = periodo;
		this.horarios = horarios;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	
	public void addHorario(Horario h) {
		if(!this.horarios.contains(h)) {
			h.setTurma(this);
			this.horarios.add(h);
		}
	}
	
	public void removeHorario(Horario h) {
		if(this.horarios.contains(h)) {
			h.setTurma(null);
			this.horarios.remove(h);
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
		Turma other = (Turma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turma [codigo=" + codigo + ", professor=" + professor + ", periodo="
				+ periodo + "]";
	}

}
