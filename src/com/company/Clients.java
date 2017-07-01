package com.company;

/**
 * Created by Deivison Silva on 01/07/2017.
 */
public class Clients {
    String Nome;
    long CPF;
    long Telefone;

    String RG;
    String Endereco;
    String Email;

    public Clients(String Nome, long CPF, long Telefone, String RG, String Endereco, String Email)
    {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Telefone = Telefone;
        this.RG = RG;
        this.Endereco = Endereco;
        this.Email = Email;
    }

}
