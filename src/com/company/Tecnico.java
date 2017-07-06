package com.company;

public class Tecnico {
    private String nome;
    private String email;
    private String telefone;
    private String habilidade;

    private static int i = 0;
    private int numMatricula;

    public Tecnico(String nome, String email, String telefone, String habilidade){
        i++;
        this.numMatricula = i;

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
    public static int getNumTecnicos() { return i; }

    //void abstract void ExcluiTecnico(int numMatricula);

    public void AlteraDados(String nome, String telefone, String email, String habilidade){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.habilidade = habilidade;
    }

    public int getNumMatricula() {
        return numMatricula;
    }
}
