package controller;

import dao.UnidadeDAO;
import model.Unidade;
import java.sql.*;
import java.util.List;

public class UnidadeController {

    private Connection connection;
    private UnidadeDAO unidadeDAO;

    public UnidadeController(Connection connection) {
        this.connection = connection;
        this.unidadeDAO = new UnidadeDAO(connection);
    }

    public boolean cadastrarUnidade(String cnpj, String nome, String endereco, String residuosAceitos, 
                                      Time horarioInicio, Time horarioFim, String emailContato, 
                                      byte[] imagemLocal, int criadoPor) {
        Unidade unidade = new Unidade(0, cnpj, nome, endereco, residuosAceitos, horarioInicio, horarioFim, 
                                      emailContato, imagemLocal, criadoPor, "pendente");
        return unidadeDAO.criarUnidade(unidade);
    }

    public List<Unidade> listarUnidades() {
        return unidadeDAO.listarUnidades();
    }

    public boolean atualizarUnidade(Unidade unidade) {
        return unidadeDAO.atualizarUnidade(unidade);
    }

    public boolean excluirUnidade(int idUnidade) {
        return unidadeDAO.excluirUnidade(idUnidade);
    }
}
