package com.company;

import javafx.scene.input.DataFormat;

import java.util.Date;

/**
 * Created by Deivison Silva on 01/07/2017.
 */
public class Cliente {

    private String Nome;
    private String Telefone;
    private long CPF;
    private String RG;
    private String Endereco;
    private String Email;
    private Data DataNascimento;

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

    public long getCPF() {
        return CPF;
    }

    public String getNome() {
        return Nome;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getRG() {
        return RG;
    }

    public Data getDataNascimento() {
        return DataNascimento;
    }
}

