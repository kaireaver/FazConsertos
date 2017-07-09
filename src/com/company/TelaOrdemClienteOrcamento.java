package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Deivison Silva on 09/07/2017.
 */
public class TelaOrdemClienteOrcamento extends Tela {

    private Ordem o;

    Box boHora;
    private final JLabel lHora;
    private JTextField tHora;
    private final JLabel lValHora;
    private JTextField tValHora;

    Box boOutros;
    private final JLabel lData;
    private JTextField tData;
    private final JLabel lValMateriais;
    private JTextField tValMateriais;

    private final JLabel lMateriais;
    private JTextArea tMateriais;
    Box boPreco;
    private final JLabel lPreco;
    private JTextField tPreco;

    Box boBtn;
    private final JButton bAprovar;
    private final JButton bRecusar;

    Box boV;


    TelaOrdemClienteOrcamento(Ordem o){

        super("ORÇAMENTO", 500, 200);
        this.o = o;

        this.lHora = new JLabel("Horas necessárias (h) : ");
        this.tHora = new JTextField(String.valueOf(this.o.getHora()));
        this.tHora.setEditable(false);
        this.lValHora = new JLabel("Valor por Hora (R$) : ");
        this.tValHora = new JTextField(String.valueOf(this.o.getValor_hora()));
        this.tValHora.setEditable(false);
        boHora = novoBoxHorizontal(lHora, tHora, lValHora, tValHora);


        this.lData = new JLabel("Data do Pedido: ");
        this.tData = new JTextField(this.o.getData_pedido());
        this.tData.setEditable(false);
        this.lValMateriais = new JLabel("Valor dos materiais (R$) : ");
        this.tValMateriais = new JTextField(String.valueOf(String.valueOf(this.o.getMaterial_valor())));
        this.tValMateriais.setEditable(false);
        boOutros = novoBoxHorizontal(lData, tData,  lValMateriais, tValMateriais );

        this.lMateriais = new JLabel("Lista de Materiais: ");
        this.tMateriais = new JTextArea(this.o.getMateriais());
        this.tMateriais.setEditable(false);
        
        this.lPreco = new JLabel("Preço total (R$) : ");
        this.tPreco = new JTextField(String.valueOf(this.o.getPreco()));
        this.tPreco.setEditable(false);
        boPreco = novoBoxHorizontal(lPreco, tPreco);
        
        bAprovar = new JButton("APROVAR");
        bAprovar.addActionListener(this);
        bRecusar = new JButton("RECUSAR");
        bRecusar.addActionListener(this);
        boBtn = Box.createHorizontalBox();
        boBtn.add(bAprovar);
        boBtn.add(bRecusar);
        

        boV = Box.createVerticalBox();
        boV.add(boHora);
        boV.add(boOutros);
        boV.add(lMateriais);
        boV.add(tMateriais);
        boV.add(boPreco);
        boV.add(boBtn);
        

        this.getContentPane().add(boV);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bAprovar)
        {
            o.aprova(true);
            atualizaLista();
            this.dispose();
        }
        else
        {
            o.aprova(false);
            atualizaLista();
            this.dispose();
        }
    }

    public void atualizaLista() {
        for (Ordem ord:oList)
        {
            if(ord.getId()== this.o.getId())
            {
                oList.remove(ord);
                oList.add(o);
                System.out.println("ACHEI!");
                break;
            }
        }

    }
}
