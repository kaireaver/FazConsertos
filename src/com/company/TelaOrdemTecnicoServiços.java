package com.company;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaOrdemTecnicoServiços extends Tela {
    private JComboBox<Ordem> cbOrdem;
    private JLabel jlOrdem;

    private Tecnico tecnico;
    private  JTextField[] tCampos;
    private JLabel[] jlCampos;
    private String[] sCampos = {"ID", "Habilidade", "Descrição"};

    private Container boxSuper;
    private Container boxCampos[];

    public TelaOrdemTecnicoServiços(Tecnico tecnico){
        super("Ordens Disponiveis!", 500, 150);
        this.tecnico = tecnico;
        Container container = getContentPane();

        cbOrdem = new JComboBox<Ordem>(getOrdens());
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

    private Ordem[] getOrdens(){
        ArrayList<Ordem> aS = new ArrayList<>();

        for (Ordem o:oList)
        {
            System.out.println(o.getHabilidades() + " == " + this.tecnico.getHabilidade());
            if(o.getStatus() == "Cadastrada" && o.getHabilidades() == this.tecnico.getHabilidade())
            {
                aS.add(o);
            }
        }

        int tam = aS.size()+1;
        Ordem[] S = new Ordem[tam];
        int i = 0;
        for (Ordem s: aS)
        {
            S[i++] = s;
        }

        return S;
    }

}
