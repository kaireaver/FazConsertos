package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by edvil on 05/07/2017.
 */

public class TelaClienteConsulta extends Tela {

    private final Box boBotoes;
    private final JButton bAtualizar;
    private final JButton bAprovar;
    private Cliente cliente;
    private JComboBox<Ordem> cbOrdem;
    private JLabel jlOrdem;

    private  JTextField[] tCampos;
    private JLabel[] jlCampos;
    private String[] sCampos = {"ID: ", "Tecnico: ", "Status: "};

    private Container boxSuper;
    private Container boxCampos[];
    private Ordem ordem;

    public TelaClienteConsulta(Cliente cliente)
    {
        super("Suas Ordens ativas!", 500, 220);
        this.cliente = cliente;
        Container container = getContentPane();

        cbOrdem = new JComboBox<>(getOrdens());
        jlOrdem = new JLabel("Orçamento: ");

        tCampos = new JTextField[sCampos.length];
        jlCampos = new JLabel[sCampos.length];


        boxSuper = Box.createVerticalBox();
        boxCampos = new Container[sCampos.length + 1];

        boxCampos[3] = novoBoxHorizontal(jlOrdem, cbOrdem);
        boxSuper.add(boxCampos[3]);

        for (int i = 0; i<sCampos.length; i++){
            tCampos[i] = new JTextField(20);
            jlCampos[i] = new JLabel(sCampos[i]);
            this.tCampos[i].setEditable(false);

            boxCampos[i] = novoBoxHorizontal(jlCampos[i], tCampos[i]);
            boxSuper.add(boxCampos[i]);
        }
        boBotoes = Box.createHorizontalBox();
            bAtualizar = new JButton("ATUALIZAR");
            bAtualizar.addActionListener(this);
            bAprovar = new JButton("ORÇAMENTO");
            setButton(bAprovar, false);
            bAprovar.addActionListener(this);
            boBotoes.add(bAtualizar);
            boBotoes.add(bAprovar);

        boxSuper.add(boBotoes);

        container.add(boxSuper);
        setVisible(true);
    }

    public Ordem[] getOrdens(){
        ArrayList<Ordem> aS = new ArrayList<>();

        for (Ordem o:oList)
        {
            if(o.getCliente().getCPF().equals(this.cliente.getCPF()))
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

    @Override
    public void windowClosing(WindowEvent e) {
        setButton(TelaMainCliente.bNovaSolicitacao,true);
        setButton(TelaMainCliente.bConsultarSolicitacao,true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bAtualizar)
        {
            atualizaOrdemNaTela();
        }
        if(e.getSource() == bAprovar)
        {
            JOptionPane.showMessageDialog(null, "NÃO EXISTE ORÇAMENTO AINDA!");
        }
    }

    private void atualizaOrdemNaTela()
    {
        this.ordem = (Ordem) cbOrdem.getSelectedItem();
        if(this.ordem == null) return;
        this.tCampos[0].setText(String.valueOf(this.ordem.getId()));
        this.tCampos[1].setText(String.valueOf(this.ordem.gettID()));
        this.tCampos[2].setText(String.valueOf(this.ordem.getStatus()));
        if(this.ordem.getStatus().equals("Cadastrada"))
        {
            setButton(bAprovar, true);
        }
    }
}