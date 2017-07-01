package com.company;

/**
 * Created by Deivison Silva on 01/07/2017.
 */
public class Cliente {
    String Nome;
    long CPF;
    long Telefone;

    String RG;
    String Endereco;
    String Email;

    public Cliente(String Nome, long CPF, long Telefone)
    {
        this.Nome = Nome;
        this.CPF =  CPF;
        this.Telefone = Telefone;

    }
    public void ConfirmaCliente(String RG, String Endereco, String Email)
    {
        this.RG = RG;
        this.Endereco = Endereco;
        this.Email = Email;
    }

}
