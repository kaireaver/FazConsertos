package com.company;

import javafx.scene.input.DataFormat;

import java.util.Date;

/**
 * Created by Deivison Silva on 01/07/2017.
 */
public class Cliente {
    String Nome;
    String Telefone;

    long CPF;
    String RG;
    String Endereco;
    String Email;
    Data DataNascimento;

    public Cliente(String Nome, long CPF, String Telefone)
    {
        this.Nome = Nome;
        this.CPF =  CPF;
        this.Telefone = Telefone;

    }
    public void preencheCliente(String RG, String Endereco, String Email, Data DataNascimento)
    {
        this.RG = RG;
        this.Endereco = Endereco;
        this.Email = Email;
        this.DataNascimento = DataNascimento;
    }

}

