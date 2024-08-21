package ifpb.edu.br.entidades;

public class Disciplina {
    String nome;
    Professor professor;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public String getNome() { return nome; }
    public Professor getProfessor() { return professor; }
}
