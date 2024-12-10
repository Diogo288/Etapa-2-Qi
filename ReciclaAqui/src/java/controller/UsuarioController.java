package controller;

import dao.UsuarioDAO;
import model.Usuario;
import java.sql.*;

public class UsuarioController {

    private Connection connection;
    private UsuarioDAO usuarioDAO;

    public UsuarioController(Connection connection) {
        this.connection = connection;
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    public boolean cadastrarUsuario(String nome, String email, String senha, String tipo) {
        Usuario usuario = new Usuario(0, nome, email, senha, tipo, null);
        return usuarioDAO.criarUsuario(usuario);
    }

    public Usuario login(String email) {
        return usuarioDAO.buscarPorEmail(email);
    }

    public boolean atualizarUsuario(Usuario usuario) {
        return usuarioDAO.atualizarUsuario(usuario);
    }

    public boolean excluirUsuario(int idUsuario) {
        return usuarioDAO.excluirUsuario(idUsuario);
    }
}