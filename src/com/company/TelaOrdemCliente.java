package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * Created by kings on 12/06/2017.
 */
public class TelaOrdemCliente extends Tela {

    private final Cliente cliente;
    private JButton[] bOrdemCliente;
    private String[] bsOrdemCliente = {"Confirmar", "Cancelar"};

    private JLabel[] jlCampos;
    private String[] jlsCampos = {"Habilidades:  ", "Descrição  "};

    private JTextArea tDescricao;

    private JComboBox cbHabilidades;
    private String[] cbsHabilidades = {"Técnico", "Mecânico", "Programador", "Cozinheiro"};

    private Container boxCampos[];
    private Container boxSuper;

    public TelaOrdemCliente(Cliente cliente){
        super("Solicitar Ordem", 500, 150);
        Container container = getContentPane();
        this.cliente = cliente;

        jlCampos = new JLabel[2];
        cbHabilidades = new JComboBox(cbsHabilidades);
        boxCampos = new Container[3];
        boxSuper = Box.createVerticalBox();
        tDescricao = new JTextArea(5,7);
        bOrdemCliente = new JButton[2];

        container.add(boxSuper);

        jlCampos[0] = new JLabel(jlsCampos[0]);
        boxCampos[0] = novoBoxHorizontal(jlCampos[0], cbHabilidades);
        boxCampos[1] = Box.createHorizontalBox();
        jlCampos[1] = new JLabel(jlsCampos[1]);

        for(int i = 0; i<bsOrdemCliente.length;i++) {
            bOrdemCliente[i] = new JButton(bsOrdemCliente[i]);
            boxCampos[1].add(bOrdemCliente[i]);
            bOrdemCliente[i].addActionListener(this);
        }
        boxSuper.add(boxCampos[0]);
        boxSuper.add(jlCampos[1]);
        boxSuper.add(tDescricao);
        boxSuper.add(boxCampos[1]);


        setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        setButton(TelaMainCliente.bNovaSolicitacao,true);
        setButton(TelaMainCliente.bConsultarSolicitacao,true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== bOrdemCliente[0])
        { //Confirmar
            if(!String.valueOf(cbHabilidades.getSelectedItem()).equals("Técnico"))
            {
                System.out.println(String.valueOf(cbHabilidades.getSelectedItem()));
                Ordem o = new Ordem(this.cliente,tDescricao.getText(),(String) cbHabilidades.getSelectedItem());
                oList.add(o);
                JOptionPane.showMessageDialog(this, "SUA SOLICITAÇÃO FOI REALIZADA COM SUCESSO!");
                setButton(TelaMainCliente.bNovaSolicitacao,true);
                setButton(TelaMainCliente.bConsultarSolicitacao,true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Por favor, selecione uma habilidade.");
            }

        }
        else{ //Cancelar
            this.dispose();
            setButton(TelaMainCliente.bNovaSolicitacao,true);
            setButton(TelaMainCliente.bConsultarSolicitacao,true);
            System.out.println("Fechando tela de nova solicitação!");
        }
    }
}
