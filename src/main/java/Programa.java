import cursojava.constantes.StatusAluno;
import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        /*SOLICITAÇÃO DE SENHA PARA EXECUÇÃO DO PROGRAMA */
        String login = JOptionPane.showInputDialog("Informe o Login");
        String senha = JOptionPane.showInputDialog("Informe a Senha");

        if (login.equalsIgnoreCase("admin") &&
                senha.equalsIgnoreCase("1234")) {

            /*ADICIONANDO MAIS DE UM ALUNO*/
            List<Aluno> alunos = new ArrayList<Aluno>();

            /*LISTANDO POR STATUS DE APROVAÇÃO*/
            List<Aluno> alunosAprovados = new ArrayList<Aluno>();
            List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
            List<Aluno> alunosReprovados = new ArrayList<Aluno>();


            for (int qtd = 1; qtd <= 5; qtd++) {

                String nome = JOptionPane.showInputDialog("Qual nome do Alunos " + qtd + "? ");
            /*String idade = JOptionPane.showInputDialog("Qual idade do Aluno? ");
            String dataNascimento = JOptionPane.showInputDialog("Digite sua data de Nascimento: ");*/

                Aluno aluno1 = new Aluno();

                aluno1.setNome(nome);
            /*aluno1.setIdade(Integer.valueOf(idade));
            aluno1.setDataNascimento(dataNascimento);*/

                /*METODO PARA ADICIONAR DISCIPLINAS*/
                for (int pos = 1; pos <= 1; pos++) {
                    String nomeDisciplina = JOptionPane.showInputDialog("Nome da Disciplina " + pos + " ? ");
                    String notaDisciplina = JOptionPane.showInputDialog("Nota da Disciplina " + pos + "? ");

                    Disciplina disciplina = new Disciplina();
                    disciplina.setDisciplina(nomeDisciplina);
                    disciplina.setNota(Double.valueOf(notaDisciplina));


                    /*ADICIONAR NA LISTA*/
                    aluno1.getDisciplinas().add(disciplina);
                }


                /*REMOVER DISCIPLINA*/
                int escolha = JOptionPane.showConfirmDialog(null, "Deseja Remover Alguma Disciplina ? ");
                /*Sim = 0 / Não = 1*/
                if (escolha == 0) {
                    int continuarRemover = 0;
                    int posicao = 1;

                    while (continuarRemover == 0) {
                        String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina 1, 2, 3 ou 4 ?");
                        aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                        posicao++;
                        continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a Remover? ");
                    }
                }
                alunos.add(aluno1);
            }
            for (Aluno aluno : alunos) {/*VAMOS VASCULHAR A LISTA DE ALUNOS E SEPARAR POR STATUS*/
                if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
                    alunosAprovados.add(aluno);
                } else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                    alunosRecuperacao.add(aluno);
                } else {
                    alunosReprovados.add(aluno);
                }

            }

            System.out.println("---------Lista dos Alunos Aprovados---------");
            for (Aluno aluno : alunosAprovados) {
                System.out.println("Aluno: " + aluno.getNome());
                System.out.println("Disciplina: " + aluno.getDisciplinas());
                System.out.println("Resultado: " + aluno.getAlunoAprovado2() + " com Média de: " + aluno.getmediaNota());
                System.out.println();
            }
            System.out.println("---------Lista dos Alunos de Recuperação---------");
            for (Aluno aluno : alunosRecuperacao) {
                System.out.println("Aluno: " + aluno.getNome());
                System.out.println("Disciplina: " + aluno.getDisciplinas());
                System.out.println("Resultado: " + aluno.getAlunoAprovado2() + " com Média de: " + aluno.getmediaNota());
                System.out.println();
            }
            System.out.println("---------Lista dos Alunos Reprovados---------");
            for (Aluno aluno : alunosReprovados) {
                System.out.println("Aluno: " + aluno.getNome());
                System.out.println("Disciplina: " + aluno.getDisciplinas());
                System.out.println("Resultado: " + aluno.getAlunoAprovado2() + " com Média de: " + aluno.getmediaNota());
            }
        }
    }
}














