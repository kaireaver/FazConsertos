package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;

/**
 * Created by edvil on 01/07/2017.
 */
public class CriaTecnico extends JFrame{
    private JLabel[] nome_campos;
    private  JTextField[] campos;
    private String[] nomes = {"Nome", "Email", "Telefone","Habilidade"};

    private Container[] boxCampos;
    private  Container boxSuper;

    private BorderLayout layout;

    private JComboBox cbHabilidades;
    private String[] habilidades = {"Tecnico", "Mecanico", "Garota de Programa", "Cozinheiro"};

    public CriaTecnico(){
        super("Insira suas informações");

        nome_campos = new JLabel[nomes.length];
        campos = new JTextField[nomes.length-1];
        boxCampos = new Container[nomes.length];
        cbHabilidades = new JComboBox(habilidades);

        boxSuper = Box.createVerticalBox();
        Container container = getContentPane();

        layout = new BorderLayout(25,25);
        container.add(this.boxSuper);

        for(int i = 0; i< nomes.length-1;i++){
            nome_campos[i] = new JLabel(nomes[i]);
            campos[i] = new JTextField(5);
            boxCampos[i] = Box.createHorizontalBox();

            boxCampos[i].add(nome_campos[i]);
            boxCampos[i].add(campos[i]);
            boxSuper.add(boxCampos[i]);


        }
        boxCampos[3] = Box.createHorizontalBox();
        nome_campos[3] = new JLabel(nomes[3]);
        boxCampos[3].add(nome_campos[3]);
        boxCampos[3].add(cbHabilidades);
        boxSuper.add(boxCampos[3]);


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,150);
        setResizable(false);
        setVisible(true);
    }
}