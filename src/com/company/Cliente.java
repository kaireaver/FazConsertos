package com.company;

import javafx.scene.input.DataFormat;

import java.util.Date;

/**
 * Created by Deivison Silva on 01/07/2017.
 */
public class Cliente {
    String Nome;
    String Telefone;

    private String CPF;
    private String RG;
    private String Endereco;
    String Email;
    String DataNascimento;

    public Cliente(String Nome, String CPF, String Telefone)
    {
        System.out.println("Criando novo cliente:\n");
        this.Nome = Nome;
        this.CPF =  CPF;
        this.Telefone = Telefone;
        System.out.println(this.toString());

    }
    public void preencheCliente(String RG, String Email, String Endereco, String DataNascimento)
    {
        this.RG = RG;
        this.Endereco = Endereco;
        this.Email = Email;
        this.DataNascimento = DataNascimento;
    }

    public String getCPF() {
        return this.CPF;
    }
    public String getRG() {
        return this.RG;
    }
    public String getEndereco() {
        return this.Endereco;
    }

    @Override
    public String toString()
    {
        return "-----------------\nNome: "+this.Nome+"\nCPF: " + this.CPF + "\nEmail: " + this.Email + "\n----------------\n";
    }
}

