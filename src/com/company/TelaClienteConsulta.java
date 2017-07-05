package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by edvil on 05/07/2017.
 */

public class TelaClienteConsulta extends Tela {
    private JComboBox cbOrdem;
    private JLabel jlOrdem;

    private  JTextField[] tCampos;
    private JLabel[] jlCampos;
    private String[] sCampos = {"ID", "Tecnico", "Status"};

    private Container boxSuper;
    private Container boxCampos[];

    public TelaClienteConsulta(){
        super("Suas Ordens ativas!", 500, 150);
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
        setVisible(true);
    }

    public String[] getOrdens(){
        String[] s = {"a","b"};
        return s;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        setButton(MainCliente.bNovaSolicitacao,true);
        setButton(MainCliente.bConsultarSolicitacao,true);
    }
}