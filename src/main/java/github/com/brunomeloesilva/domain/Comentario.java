package github.com.brunomeloesilva.domain;

import java.util.Date;

public class Comentario {

    private Long id;
    private String texto;
    private String usuario;
    private Date data;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Comentario id(Long id) {
        this.id = id;
        return this;
    }

    public Comentario texto(String texto) {
        this.texto = texto;
        return this;
    }

    public Comentario usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public Comentario data(Date data) {
        this.data = data;
        return this;
    }
}
