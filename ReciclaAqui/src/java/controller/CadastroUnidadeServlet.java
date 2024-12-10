package controller;

import utils.DBConnection;
import model.Unidade;
import model.Usuario;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroUnidadeServlet extends HttpServlet {

    private UnidadeController unidadeController;

    @Override
    public void init() {
        try {
            unidadeController = new UnidadeController(DBConnection.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUnidadeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro_pev.html");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Recuperando e validando dados do formulário
            String cnpj = request.getParameter("cnpj");
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String residuosAceitos = request.getParameter("residuosAceitos");
            String horarioInicioStr = request.getParameter("horarioInicio");
            String horarioFimStr = request.getParameter("horarioFim");
            String emailContato = request.getParameter("emailContato");

            if (cnpj == null || nome == null || horarioInicioStr == null || horarioFimStr == null) {
                throw new IllegalArgumentException("Campos obrigatórios ausentes.");
            }

            // Validando horários
            Time horarioInicio = Time.valueOf(horarioInicioStr + ":00");
            Time horarioFim = Time.valueOf(horarioFimStr + ":00");

            // Verificando sessão
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("login.html");
                return;
            }

            Usuario usuario = (Usuario) session.getAttribute("usuario");
            int criadoPor = usuario.getIdUsuario();

            // Tratamento da imagem
            Part imagemPart = request.getPart("imagemLocal");
            if (imagemPart == null || !imagemPart.getContentType().startsWith("image/")) {
                request.setAttribute("erro", "Arquivo de imagem inválido.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro_pev.html");
                dispatcher.forward(request, response);
                return;
            }
            byte[] imagemLocal = imagemPart.getInputStream().readAllBytes();

            // Persistindo a unidade
            Unidade unidade = new Unidade(0, cnpj, nome, endereco, residuosAceitos, horarioInicio, horarioFim, emailContato, imagemLocal, criadoPor, "pendente");
            boolean sucesso = unidadeController.cadastrarUnidade(cnpj, nome, endereco, residuosAceitos, horarioInicio, horarioFim, emailContato, imagemLocal, criadoPor);

            if (sucesso) {
                response.sendRedirect("unidades.html");
            } else {
                request.setAttribute("erro", "Erro ao cadastrar unidade. Tente novamente.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro_pev.html");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro no processamento: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro_pev.html");
            dispatcher.forward(request, response);
        }
    }
}
