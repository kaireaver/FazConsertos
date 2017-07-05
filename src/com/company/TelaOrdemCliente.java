package com.company;

import javafx.collections.transformation.SortedList;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kings on 12/06/2017.
 */
public class TelaOrdemCliente extends Tela {

    private JButton[] bOrdemCliente;
    private String[] bsOrdemCliente = {"Confirmar", "Cancelar"};

    private JLabel[] jlCampos;
    private String[] jlsCampos = {"Habilidades", "Descrição"};

    private JTextField tDescricao;

    private JComboBox cbHabilidades;
    private String[] cbsHabilidades = {"Técnico", "Mecânico", "Programador", "Cozinheiro"};

    private Container boxCampos[];
    private Container boxSuper;

    public TelaOrdemCliente(){
        super("Solicitar Ordem");
        Container container = getContentPane();

        jlCampos = new JLabel[2];
        cbHabilidades = new JComboBox(cbsHabilidades);
        boxCampos = new Container[3];
        boxSuper = Box.createVerticalBox();
        tDescricao = new JTextField(300);
        bOrdemCliente = new JButton[2];

        container.add(boxSuper);

        boxCampos[0] = Box.createHorizontalBox();
        jlCampos[0] = new JLabel(jlsCampos[0]);
        boxCampos[0].add(jlCampos[0]);
        boxCampos[0].add(cbHabilidades);

        boxCampos[1] = Box.createHorizontalBox();
        jlCampos[1] = new JLabel(jlsCampos[1]);

        for(int i = 0; i<bsOrdemCliente.length;i++) {
            bOrdemCliente[i] = new JButton(bsOrdemCliente[i]);
            boxCampos[1].add(bOrdemCliente[i]);
        }
        boxSuper.add(boxCampos[0]);
        boxSuper.add(jlCampos[1]);
        boxSuper.add(tDescricao);
        boxSuper.add(boxCampos[1]);


        setSize(500,150);
        setVisible(true);
        setResizable(false);

    }
}
