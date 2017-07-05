package com.company;


public class Tecnico {
    private String nome;
    private String email;
    private String telefone;
    private String habilidade;
    protected static final String[] cbsHabilidades = {"Técnico", "Mecânico", "Programador", "Cozinheiro"};

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
    public int getHabID() {
        for(i = 0; i < cbsHabilidades.length; i++) {
            if(cbsHabilidades[i] == habilidade)
                return i;
        }
        return 0;
    }
    public int getId(){
        return this.numMatricula;
    }
    public static int getNumTecnicos() { return i; }

    public void AlteraDados(String nome, String telefone, String email, String habilidade){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.habilidade = habilidade;
    }
}
