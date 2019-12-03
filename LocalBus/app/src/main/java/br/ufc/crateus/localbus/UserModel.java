package br.ufc.crateus.localbus;

import android.text.Editable;

public class UserModel {
    private String key;
    private String email;
    private String nome;
    private Integer matricula;
    private String curso;
    private String senha;

    public UserModel() {
    }

    public UserModel(String nome, String email, Integer matricula, String curso, String senha) {
        this.email = email;
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.senha = senha;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", curso='" + curso + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

}
