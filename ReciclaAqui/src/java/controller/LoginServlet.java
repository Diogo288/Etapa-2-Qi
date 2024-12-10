package controller;

import utils.DBConnection;
import model.Usuario;
import utils.PasswordUtil;
import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    private UsuarioController usuarioController;

    public void init() {
        try {
            usuarioController = new UsuarioController(DBConnection.getConnection()); // Assumindo que a conexão com o banco já foi configurada
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Validação de parâmetros
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
                request.setAttribute("erro", "Email e senha são obrigatórios.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
                dispatcher.forward(request, response);
                return;
            }

            // Recuperação do usuário no banco de dados
            Usuario usuario = usuarioController.login(email);
            if (usuario != null && PasswordUtil.verificarSenha(senha, usuario.getSenha())) {
                // Gerenciamento de sessão
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                HttpSession newSession = request.getSession(true);
                newSession.setAttribute("usuario", usuario);

                // Redirecionamento baseado no tipo de usuário
                if ("admin".equals(usuario.getTipo())) {
                    response.sendRedirect("admin.html");
                } else {
                    response.sendRedirect("unidades.html");
                }
            } else {
                // Feedback ao usuário
                request.setAttribute("erro", "Email ou senha inválidos.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Para desenvolvimento, substitua por log seguro
            request.setAttribute("erro", "Erro no processamento. Tente novamente.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
            dispatcher.forward(request, response);
        }
    }
}
