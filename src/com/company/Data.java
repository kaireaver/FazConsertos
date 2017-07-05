package com.company;

import javax.swing.*;

public class Data
{
    public int Dia;
    public int Mes;
    public int Ano;
    public Data(int D, int M, int A)
    {
        Dia = D;
        Mes = M;
        Ano = A;
    }

    public Data(String s)
    {
        try{
            Dia = Integer.parseInt(s.substring(0,1));
            Mes = Integer.parseInt(s.substring(3,4));
            Ano = Integer.parseInt(s.substring(6,9));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
