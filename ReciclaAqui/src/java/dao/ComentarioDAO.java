package dao;

import model.Comentario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO {

    private Connection connection;

    public ComentarioDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean criarComentario(Comentario comentario) {
        String sql = "INSERT INTO comentarios (id_unidade, id_usuario, comentario) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, comentario.getIdUnidade());
            stmt.setInt(2, comentario.getIdUsuario());
            stmt.setString(3, comentario.getComentario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Comentario> listarComentariosPorUnidade(int idUnidade) {
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM comentarios WHERE id_unidade = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUnidade);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                comentarios.add(new Comentario(
                    rs.getInt("id_comentario"),
                    rs.getInt("id_unidade"),
                    rs.getInt("id_usuario"),
                    rs.getString("comentario"),
                    rs.getTimestamp("criado_em")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comentarios;
    }
}