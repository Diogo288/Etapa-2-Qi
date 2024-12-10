package controller;

import dao.ComentarioDAO;
import model.Comentario;
import java.sql.*;
import java.util.List;

public class ComentarioController {

    private Connection connection;
    private ComentarioDAO comentarioDAO;

    public ComentarioController(Connection connection) {
        this.connection = connection;
        this.comentarioDAO = new ComentarioDAO(connection);
    }

    public boolean cadastrarComentario(int idUnidade, int idUsuario, String comentario) {
        Comentario novoComentario = new Comentario(0, idUnidade, idUsuario, comentario, null);
        return comentarioDAO.criarComentario(novoComentario);
    }

    public List<Comentario> listarComentarios(int idUnidade) {
        return comentarioDAO.listarComentariosPorUnidade(idUnidade);
    }
}