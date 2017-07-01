package com.company;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Deivison Silva on 01/07/2017.
 */
public class clientsScreen {
    private JFrame fClients;
    final private JLabel lNome = new JLabel("Nome:");
    final private JLabel lCPF = new JLabel("CPF - apenas números:");
    final private JLabel lTelefone = new JLabel("Telefone + DDD:");
    final private JButton bOk = new JButton("OK");
    final private JButton bCancel = new JButton("Cancelar");

    private JTextField tNome;
    private JTextField tCPF;
    private JTextField tTelefone;



    public clientsScreen()
    {
        tNome = new JTextField(40);
        tCPF = new JTextField(11);;
        tTelefone = new JTextField(12);;
    }
}
