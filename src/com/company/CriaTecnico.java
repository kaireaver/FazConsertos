package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;

/**
 * Created by edvil on 01/07/2017.
 */
public class CriaTecnico extends JFrame{
    private JLabel[] jlCampos;
    private  JTextField[] tCampos;
    private String[] jlsCampos = {"Nome", "Email", "Telefone","Habilidade"};

    private Container[] boxCampos;
    private  Container boxSuper;

    private BorderLayout layout;

    private JComboBox cbHabilidades;
    private String[] cbsHabilidades = {"Tecnico", "Mecanico", "Garota de Programa", "Cozinheiro"};

    private JButton[] bCriaTecnico;
    private String[] bsCriaTecnico = {"Criar", "Cancelar"};

    public CriaTecnico(){
        super("Insira suas informações");

        jlCampos = new JLabel[jlsCampos.length];
        tCampos = new JTextField[jlsCampos.length-1];
        boxCampos = new Container[jlsCampos.length+1];
        cbHabilidades = new JComboBox(cbsHabilidades);
        bCriaTecnico = new JButton[bsCriaTecnico.length];

        boxSuper = Box.createVerticalBox();
        Container container = getContentPane();

        layout = new BorderLayout(25,25);
        container.add(this.boxSuper);

        for(int i = 0; i< jlsCampos.length-1;i++){
            jlCampos[i] = new JLabel(jlsCampos[i]);
            tCampos[i] = new JTextField(5);
            boxCampos[i] = Box.createHorizontalBox();

            boxCampos[i].add(jlCampos[i]);
            boxCampos[i].add(tCampos[i]);
            boxSuper.add(boxCampos[i]);


        }

        boxCampos[3] = Box.createHorizontalBox();
        jlCampos[3] = new JLabel(jlsCampos[3]);
        boxCampos[3].add(jlCampos[3]);
        boxCampos[3].add(cbHabilidades);
        boxSuper.add(boxCampos[3]);

        boxCampos[4] = Box.createHorizontalBox();
        boxSuper.add(boxCampos[4]);

        for(int i=0;i<bsCriaTecnico.length;i++){
            bCriaTecnico[i] = new JButton(bsCriaTecnico[i]);
            boxCampos[4].add(bCriaTecnico[i]);
        }

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,150);
        setResizable(false);
        setVisible(true);
    }
}