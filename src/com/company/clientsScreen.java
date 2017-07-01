package com.company;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Deivison Silva on 01/07/2017.
 */
public class clientsScreen {
    private JLabel lNome = new JLabel("Nome:");
    private JLabel lCPF = new JLabel("CPF - apenas números:");
    private JLabel lTelefone = new JLabel("Telefone + DDD:");

    private JTextField tNome;
    private JTextField tCPF;
    private JTextField tTelefone;

    private JButton bOk = new JButton("OK");
    private JButton bCancel = new JButton("Cancelar");

    public clientsScreen()
    {
        tNome = new JTextField(40);
        tCPF = new JTextField(11);;
        tTelefone = new JTextField(12);;
    }
}
