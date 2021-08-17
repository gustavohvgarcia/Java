package ConnectionJDBC;

import java.util.List;


public abstract class Main {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        //método consulta
        List<Aluno> alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        //método consulta por id
        Aluno alunoParaConsulta = alunoDAO.getById(1);
        System.out.println(alunoParaConsulta);

        //metodo inserir
//        Aluno inserido = new Aluno("Joaquina",18,"TO");
//        alunoDAO.create(inserido);

        //metodo delete
        //alunoDAO.delete(5);

        //metodo update
        Aluno alunoParaAtualizar = alunoDAO.getById(4);
        alunoParaAtualizar.setNome("Joaquim");
        alunoParaAtualizar.setIdade(18);
        alunoParaAtualizar.setEstado("RS");
        alunoDAO.editarAluno(alunoParaAtualizar);
    }
}
