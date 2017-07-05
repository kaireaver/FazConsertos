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

    private Box boxConfirma;
    final private static JLabel lTemCerteza = new JLabel("Tem certeza?");
    private static JButton bConfirma;
    private static JButton bRecusa;

    private Tecnico t;

    public MainTecnico(Tecnico t) {
        super("Bem-vindo, " + t.getNome() + "! Selecione a opção desejada:", 500, 80);
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

        bConfirma = new JButton("Prosseguir");
        bRecusa = new JButton("Cancelar");

        bConfirma.addActionListener(this);
        bRecusa.addActionListener(this);

        boxConfirma = Box.createVerticalBox();
        boxConfirma.add(lTemCerteza);

        Box boxAux = Box.createHorizontalBox();
        boxAux.add(bConfirma);
        boxAux.add(bRecusa);

        boxConfirma.add(boxAux);

        pTecnicoPrincipal.add(boxConfirma);
        boxConfirma.setVisible(false);
        getContentPane().add(pTecnicoPrincipal);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bAlteraDados) {
            setButton(bAlteraDados,false);
            setButton(bConsultaServico,false);
            setButton(bExcluirTecnico,false);
            setButton(bSair,false);

            TelaDadosTecnico tDados = new TelaDadosTecnico(t);
        }

        else if(event.getSource() == bConsultaServico) {
            JFrame fConsultaServicos = new TelaOrdemTecnicoServiços();
        }

        else if(event.getSource() == bExcluirTecnico) {
            boxConfirma.setVisible(true);
            setSize(new Dimension(500,120));
        }

        else if(event.getSource() == bConfirma) {
            tList.remove(t);
            fechaTela(true);
        }

        else if(event.getSource() == bRecusa) {
            boxConfirma.setVisible(false);
            setSize(new Dimension(500,80));
        }

        else if(event.getSource() == bSair) {
            fechaTela(true);
        }
    }
}
