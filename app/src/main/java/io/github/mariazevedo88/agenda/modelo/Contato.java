package io.github.mariazevedo88.agenda.modelo;

import java.io.Serializable;

/**
 * @author Mariana Azevedo
 * @since 10/04/2018
 */
public class Contato implements Serializable{

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String site;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSite(){
        return site;
    }

    @Override
    public String toString()  {
        return getId() + " - " + getNome();
    }
}
