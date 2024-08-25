package ifpb.edu.br.entidades;

public class Disciplina {
    private String nomeDisciplina;
    private Professor professor;

    public Disciplina(String nome, Professor professor) {
        this.nomeDisciplina = nome;
        this.professor = professor;
    }

    public String getNomeDisciplina() { return nomeDisciplina; }
    public Professor getProfessor() { return professor; }
}