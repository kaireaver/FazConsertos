package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaTecnico extends Tela implements ActionListener {
    private JPanel pTecnicos;
    private static JButton bNovoTecnico;
    private static JButton bLogaTecnico;
    private static JButton bCancela;
    private ArrayList<Tecnico> tList;

    public TelaTecnico(ArrayList<Tecnico> tList) {
        super("Selecione sua opção:", 500, 70);
        this.tList = tList;

        bNovoTecnico = new JButton("Novo Técnico");
        bLogaTecnico = new JButton("Entrar no sistema");
        bCancela = new JButton("Cancelar");

        bNovoTecnico.addActionListener(this);
        bLogaTecnico.addActionListener(this);
        bCancela.addActionListener(this);

        pTecnicos = new JPanel();
        pTecnicos.add(bNovoTecnico);
        pTecnicos.add(bLogaTecnico);
        pTecnicos.add(bCancela);

        getContentPane().add(pTecnicos);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bNovoTecnico) {
            JFrame fCriaTecnico = new CriaTecnico();
            fechaTela(false);
        }

        else if(event.getSource() == bLogaTecnico) {
            JFrame fLoginTecnico = new LogaTecnico();
            fechaTela(false);
        }

        else if(event.getSource() == bCancela) {
            fechaTela(true);
        }
    }
}
