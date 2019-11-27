package br.ufc.crateus.localbus;

public class MensagemModel {
    String nome;
    String mensagem;

    public MensagemModel() {
    }

    public MensagemModel(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "MensagemModel{" +
                "nome='" + nome + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
