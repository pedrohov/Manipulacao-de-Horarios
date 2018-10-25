package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="professor")
@DiscriminatorValue("PROFESSOR")
public class Professor extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="professor", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Turma> turmas;
	
	public Professor() {
		turmas = new ArrayList<Turma>();
	}

	public Professor(List<Turma> turmas) {
		super();
		this.turmas = turmas;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public void addTurma(Turma turma) {
		if(!this.turmas.contains(turma)) {
			turma.setProfessor(this);
			this.turmas.add(turma);
		}
	}
	
	public void removeTurma(Turma turma) {
		if(this.turmas.contains(turma)) {
			turma.setProfessor(null);
			this.turmas.remove(turma);
		}
	}
}
