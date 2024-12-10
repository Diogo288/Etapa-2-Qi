package model;

import java.sql.Time;

public class Unidade {
    private int idUnidade;
    private String cnpj;
    private String nome;
    private String endereco;
    private String residuosAceitos;
    private Time horarioInicio;
    private Time horarioFim;
    private String emailContato;
    private byte[] imagemLocal;
    private int criadoPor;
    private String aprovado;

    public Unidade(int idUnidade, String cnpj, String nome, String endereco, String residuosAceitos,
                   Time horarioInicio, Time horarioFim, String emailContato, byte[] imagemLocal, int criadoPor, String aprovado) {
        this.idUnidade = idUnidade;
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.residuosAceitos = residuosAceitos;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.emailContato = emailContato;
        this.imagemLocal = imagemLocal;
        this.criadoPor = criadoPor;
        this.aprovado = aprovado;
    }

    // Getters and Setters

    public String getCnpj() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getResiduosAceitos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getEndereco() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Time getHorarioInicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Time getHorarioFim() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getEmailContato() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCriadoPor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getAprovado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
