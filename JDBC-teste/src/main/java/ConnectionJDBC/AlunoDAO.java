package ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    //método responsavel por trazer a lista de alunos do BD
    public List<Aluno> list(){
        List<Aluno> alunos = new ArrayList<>();

        //acessar o banco
        try(Connection conn = ConnectionJDBC.getConnection())
        {

        PreparedStatement prst = conn.prepareStatement("SELECT * from aluno");
        ResultSet rs = prst.executeQuery();

        while(rs.next()){
            Aluno aluno = new Aluno(rs.getInt("id"),rs.getString("nome"),rs.getInt("idade"),rs.getString("estado"));
            alunos.add(aluno);
        }
        } catch (SQLException throwables) {
            System.out.println("Erro na listagem. Cheque a pilha de erros");
            throwables.printStackTrace();
        }
        return alunos;
    }//fim do método list()

    //consulta com filtro
    public Aluno getById(int id){
        //aluno retornado pela query
        Aluno aluno = new Aluno();

        //inicio da conexao
        try(Connection conn = ConnectionJDBC.getConnection()){
            //string que contera o comando da consulta
            String sql = "SELECT * from aluno WHERE id = ?";
            //a string é passada para o metodo prepareStatement
            PreparedStatement statement = conn.prepareStatement(sql);
            //o '?' da consulta é trocado, em sua primeira ocorrencia, pelo valor id do aluno passado como parametro
            statement.setInt(1,id);

            //O resultSet fara a pesquisa e guardara os resultados do registro selecionado
            ResultSet rs = statement.executeQuery();

            //os dados do BD são passados para o objeto 'aluno' de retorno
            if(rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }
        }catch(Exception e){
            System.out.println("O retorno do aluno falhou. Cheque o stacktrace");
            e.printStackTrace();
        }
        return aluno;
    }

    public void create(Aluno aluno){

        try (Connection conn = ConnectionJDBC.getConnection()){
            String sql = "INSERT INTO aluno(nome,idade,estado) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,aluno.getNome());
            statement.setInt(2,aluno.getIdade());
            statement.setString(3, aluno.getEstado());

            //executa a inserção e armazena o numero de linhas afetadas pela mesma
            int linhasAfetadas = statement.executeUpdate();
            System.out.println("Insercao feita com sucesso! "+linhasAfetadas+" linha(s) sofreram alteração");

        }catch(Exception e){
            System.out.println("Falha na inserção!");
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection conn = ConnectionJDBC.getConnection()){
            String sql = "DELETE FROM aluno WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);

            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Remocao bem sucedida! "+linhasAfetadas+" foram removidas!");
        }catch(Exception e){
            System.out.println("A remocao não foi concluida! Cheque o stacktrace.");
            e.printStackTrace();
        }
    }

    public void editarAluno(Aluno aluno){
        try(Connection conn = ConnectionJDBC.getConnection()){
            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,aluno.getNome());
            stmt.setInt(2,aluno.getIdade());
            stmt.setString(3,aluno.getEstado());
            stmt.setInt(4,aluno.getId());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        }catch (Exception e){
            System.out.println("A atualização falhou! Cheque o stacktrace!");
            e.printStackTrace();
        }
    }



}//fim da classe
