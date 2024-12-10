package dao;

import model.Unidade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnidadeDAO {

    private Connection connection;

    public UnidadeDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean criarUnidade(Unidade unidade) {
        String sql = "INSERT INTO unidades (cnpj, nome, endereco, residuos_aceitos, horario_inicio, horario_fim, email_contato, criado_por, aprovado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, unidade.getCnpj());
            stmt.setString(2, unidade.getNome());
            stmt.setString(3, unidade.getEndereco());
            stmt.setString(4, unidade.getResiduosAceitos());
            stmt.setTime(5, unidade.getHorarioInicio());
            stmt.setTime(6, unidade.getHorarioFim());
            stmt.setString(7, unidade.getEmailContato());
            stmt.setInt(8, unidade.getCriadoPor());
            stmt.setString(9, unidade.getAprovado());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Unidade> listarUnidades() {
        List<Unidade> unidades = new ArrayList<>();
        String sql = "SELECT * FROM unidades";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                unidades.add(new Unidade(
                    rs.getInt("id_unidade"),
                    rs.getString("cnpj"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("residuos_aceitos"),
                    rs.getTime("horario_inicio"),
                    rs.getTime("horario_fim"),
                    rs.getString("email_contato"),
                    rs.getBytes("imagem_local"),
                    rs.getInt("criado_por"),
                    rs.getString("aprovado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unidades;
    }

    public boolean atualizarUnidade(Unidade unidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean excluirUnidade(int idUnidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}