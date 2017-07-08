package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MainTecnico extends Tela {
    protected static JButton bAlteraDados;
    protected static JButton bConsultaServico;
    protected static JButton bExcluirTecnico;
    protected static JButton bSair;

    private JPanel pTecnicoPrincipal;

    private Tecnico t;

    public MainTecnico(Tecnico t) {
        super("Bem-vindo, " + t.getNome() + "! Selecione a opção desejada:", 500, 90);
        this.t = t;

        bAlteraDados = new JButton("Alterar dados");
        bConsultaServico = new JButton("Consultar serviço");
        bExcluirTecnico = new JButton("Excluir usuário");
        bSair = new JButton("Sair");

        bAlteraDados.addActionListener(this);
        bConsultaServico.addActionListener(this);
        bExcluirTecnico.addActionListener(this);
        bSair.addActionListener(this);

        pTecnicoPrincipal = new JPanel();
        pTecnicoPrincipal.add(bAlteraDados);
        pTecnicoPrincipal.add(bConsultaServico);
        pTecnicoPrincipal.add(bExcluirTecnico);
        pTecnicoPrincipal.add(bSair);

        getContentPane().add(pTecnicoPrincipal);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bAlteraDados) {
            setButtonsMainTecnico(false);
            TelaDadosTecnico tDados = new TelaDadosTecnico(t);
        }

        else if(event.getSource() == bConsultaServico) {
            JFrame fConsultaServicos = new TelaOrdemTecnicoServiços();
        }

        else if(event.getSource() == bExcluirTecnico) {
            setButtonsMainTecnico(false);
            TelaExcluiTecnico tExclui = new TelaExcluiTecnico(t);
        }

        else if(event.getSource() == bSair) {
            fechaTela(true);
        }
    }

    public static void setButtonsMainTecnico(boolean state) {
        setButton(MainTecnico.bAlteraDados,state);
        setButton(MainTecnico.bConsultaServico,state);
        setButton(MainTecnico.bExcluirTecnico,state);
        setButton(MainTecnico.bSair,state);

        return;
    }
}
