package com.company;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by edvil on 05/07/2017.
 */
public class TelaOrdemTecnicoServiços extends JFrame{
    private JComboBox cbOrdem;
    private JLabel jlOrdem;

    private  JTextField[] tCampos;
    private JLabel[] jlCampos;
    private String[] sCampos = {"ID", "Habilidade", "Descrição"};

    private Container boxSuper;
    private Container boxCampos[];

    public TelaOrdemTecnicoServiços(){
        super("Ordens Disponiveis!");
        Container container = getContentPane();

        cbOrdem = new JComboBox(getOrdens());
        jlOrdem = new JLabel("Orçamento");

        tCampos = new JTextField[sCampos.length];
        jlCampos = new JLabel[sCampos.length];

        boxSuper = Box.createVerticalBox();
        boxCampos = new Container[sCampos.length + 1];

        boxCampos[3] = Box.createHorizontalBox();
        boxCampos[3].add(jlOrdem);
        boxCampos[3].add(cbOrdem);
        boxSuper.add(boxCampos[3]);

        for (int i = 0; i<sCampos.length; i++){
            tCampos[i] = new JTextField(20);
            jlCampos[i] = new JLabel(sCampos[i]);

            boxCampos[i] = Box.createHorizontalBox();
            boxCampos[i].add(jlCampos[i]);
            boxCampos[i].add(tCampos[i]);
            boxSuper.add(boxCampos[i]);
        }

        container.add(boxSuper);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,150);
        setResizable(false);
        setVisible(true);
    }

    public String[] getOrdens(){
        String[] s = {"a","b"};
        return s;
    };
}
