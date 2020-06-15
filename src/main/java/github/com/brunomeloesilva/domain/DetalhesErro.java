package github.com.brunomeloesilva.domain;

public class DetalhesErro {

    private Long statusHTTP;
    private String titulo;
    private String mensagemDesenvolvedor;
    private Long timestamp;


    public DetalhesErro() {}

    public DetalhesErro(Long status, String titulo, String mensagemDesenvolvedor, Long timestamp) {
        this.titulo = titulo;
        this.statusHTTP = status;
        this.timestamp = timestamp;
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }


    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getStatus() {
        return this.statusHTTP;
    }

    public void setStatus(Long status) {
        this.statusHTTP = status;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensagemDesenvolvedor() {
        return this.mensagemDesenvolvedor;
    }

    public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }



}
