package model;

import java.sql.Timestamp;

public class Comentario {
    private int idComentario;
    private int idUnidade;
    private int idUsuario;
    private String comentario;
    private Timestamp criadoEm;

    public Comentario(int idComentario, int idUnidade, int idUsuario, String comentario, Timestamp criadoEm) {
        this.idComentario = idComentario;
        this.idUnidade = idUnidade;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
        this.criadoEm = criadoEm;
    }

    // Getters and Setters

    public int getIdUnidade() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getComentario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}