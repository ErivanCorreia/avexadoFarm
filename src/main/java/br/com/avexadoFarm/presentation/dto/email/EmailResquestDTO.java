package br.com.avexadoFarm.presentation.dto.email;

public class EmailResquestDTO {

    private String assunto;
    private String menssagem;
    private String destinatario;

    public EmailResquestDTO() {
    }

    public EmailResquestDTO(String assunto, String menssagem, String destinatario) {
        this.assunto = assunto;
        this.menssagem = menssagem;
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
