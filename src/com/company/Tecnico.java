package com.company;

/**
 * Created by edvil on 01/07/2017.
 */
public class Tecnico {
    private String nome;
    private String email;
    private String telefone;
    private String habilidade;

    private static int i = 0;
    private int numMatricula;

    public Tecnico(String nome, String endereco, String telefone, String habilidade){
        this.numMatricula = i;
        i++;

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.habilidade = habilidade;
    }

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public String getTelefone(){
        return this.telefone;
    }

    public String getHabilidade(){
        return this.habilidade;
    }

    public int getId(){
        return this.numMatricula;
    }

    //void abstract void ExcluiTecnico(int numMatricula);

    public void AlteraDados(String nome, String telefone, String email, String habilidade){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.habilidade = habilidade;
    }
}
