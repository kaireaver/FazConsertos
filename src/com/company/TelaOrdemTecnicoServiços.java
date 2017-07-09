package com.company;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Objects;

public class TelaOrdemTecnicoServiços extends Tela {
    private JComboBox<Ordem> cbOrdem;
    private JLabel jlOrdem;

    private Tecnico tecnico;
    private  JTextField[] tCampos;
    private JLabel[] jlCampos;
    private String[] sCampos = {"ID", "Habilidade", "Descrição"};
    Box boBtn;
    private final JButton bAtualizar;
    private final JButton bOrcar;

    private Container boxSuper;
    private Container boxCampos[];
    private Ordem ordem;

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

        bAtualizar = new JButton("ATUALIZAR");
        bAtualizar.addActionListener(this);
        bOrcar = new JButton("ORÇAR");
        bOrcar.addActionListener(this);
        setButton(bOrcar, false);
        boBtn = Box.createHorizontalBox();
        boBtn.add(bAtualizar);
        boBtn.add(bOrcar);

        boxSuper.add(boBtn);

        container.add(boxSuper);
        setVisible(true);
    }

    private Ordem[] getOrdens(){
        ArrayList<Ordem> aS = new ArrayList<>();

        for (Ordem o:oList)
        {
            System.out.println(o.getHabilidades() + " == " + this.tecnico.getHabilidade());
            if(Objects.equals(o.getStatus(), "Cadastrada") && Objects.equals(o.getHabilidades(), this.tecnico.getHabilidade()))
            {
                System.out.println("CHEGUEI!");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bAtualizar)
        {
            atualizaOrdemNaTela();
        }
        else
        {
            Ordem o = (Ordem) cbOrdem.getSelectedItem();
            o.realizarOrcamento(tecnico);
        }
    }

    private void atualizaOrdemNaTela() {
        this.ordem = (Ordem) cbOrdem.getSelectedItem();
        if(this.ordem == null) return;
        this.tCampos[2].setText(this.ordem.getDescricao());
        this.tCampos[0].setText(String.valueOf(this.ordem.getId()));
        this.tCampos[1].setText(String.valueOf(this.ordem.getHabilidades()));
        setButton(bOrcar, true);
    }
}
