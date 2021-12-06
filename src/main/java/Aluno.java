import cursojava.constantes.StatusAluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private int idade;
    private String dataNascimento;


    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    /* MÉTODO QUE RETORNA A MÉDIA DO ALUNO*/
    public double getmediaNota(){
        double somaNotas = 0.0;

        for (Disciplina disciplina : disciplinas){
            somaNotas += disciplina.getNota();
        }
        return somaNotas / disciplinas.size();
    }

    /*METODO QUE RETURN TRUE PARA APROVADO E FALSE PARA REPROVADO*/
    public boolean getAlunoAprovado(){
        double media = this.getmediaNota();
        if (media >= 70){
            return true; /*APROVADO*/
        }else{
            return false; /*REPROVADO*/
        }
    }
    public String getAlunoAprovado2(){
        double media = this.getmediaNota();
        if (media >= 50){
            if (media >= 70){
                return StatusAluno.APROVADO;
            }else{
                return StatusAluno.RECUPERACAO;
            }
        }else {
            return StatusAluno.REPROVADO;
        }
    }
}
