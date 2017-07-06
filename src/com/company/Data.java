package com.company;

import javax.swing.*;

public class Data
{
    public int Dia;
    public int Mes;
    public int Ano;
    public String sData;


    public Data(String s)
    {
        this.sData = s;
        try{
            Dia = Integer.parseInt(s.substring(0,2));
            Mes = Integer.parseInt(s.substring(3,5));
            Ano = Integer.parseInt(s.substring(6,10));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return sData;
    }
}
