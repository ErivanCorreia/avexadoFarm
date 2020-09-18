package br.com.avexadoFarm.presentation.dto.email;

public class EmailResquestDTO {

    private String assunto;
    private String mensagem;
    private String destinatario;

    public EmailResquestDTO() {
    }

    public EmailResquestDTO(String assunto, String menssagem, String destinatario) {
        this.assunto = assunto;
        this.mensagem = menssagem;
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String menssagem) {
        this.mensagem = menssagem;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
