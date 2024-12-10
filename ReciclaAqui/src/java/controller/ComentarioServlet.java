package controller;

import utils.DBConnection;
import model.Comentario;
import model.Usuario;
import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class ComentarioServlet extends HttpServlet {

    private ComentarioController comentarioController;

    public void init() {
        try {
            comentarioController = new ComentarioController(DBConnection.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Validação de sessão
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("login.html");
                return;
            }

            // Recuperando dados do formulário
            String comentario = request.getParameter("comentario");
            if (comentario == null || comentario.trim().isEmpty()) {
                request.setAttribute("erro", "O comentário não pode estar vazio.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/unidades.html");
                dispatcher.forward(request, response);
                return;
            }

            int idUnidade;
            try {
                idUnidade = Integer.parseInt(request.getParameter("idUnidade"));
            } catch (NumberFormatException e) {
                request.setAttribute("erro", "ID da unidade inválido.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/unidades.html");
                dispatcher.forward(request, response);
                return;
            }

            // Recuperando o usuário da sessão
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            int idUsuario = usuario.getIdUsuario();

            // Criando e persistindo o comentário
            if (comentarioController.cadastrarComentario(idUnidade, idUsuario, comentario)) {
                response.sendRedirect("unidades.html");
            } else {
                request.setAttribute("erro", "Erro ao adicionar comentário. Tente novamente.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/unidades.html");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Para produção, substitua por logs seguros
            request.setAttribute("erro", "Erro no processamento. Tente novamente.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/unidades.html");
            dispatcher.forward(request, response);
        }
    }
}
