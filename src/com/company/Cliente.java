package com.company;

import javafx.scene.input.DataFormat;

import java.util.Date;

/**
 * Created by Deivison Silva on 01/07/2017.
 */
public class Cliente {
    String Nome;
    String Telefone;

    String CPF;
    String RG;
    String Endereco;
    String Email;
    Date DataNascimento;

    public Cliente(String Nome, String CPF, String Telefone)
    {
        System.out.println("Criando novo cliente:");
        this.Nome = Nome;
        this.CPF =  CPF;
        this.Telefone = Telefone;
        System.out.println("\n"+this.toString() + "\n-------------\n");

    }
    public void preencheCliente(String RG, String Email, String Endereco, Date DataNascimento)
    {
        this.RG = RG;
        this.Endereco = Endereco;
        this.Email = Email;
        this.DataNascimento = DataNascimento;
    }

    public String getCPF() {
        return this.CPF;
    }

    @Override
    public String toString()
    {
        return "Nome: "+this.Nome+"\nCPF: " + this.CPF + "\nEmail: " + this.Email;
    }
}

