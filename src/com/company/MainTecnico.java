package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTecnico extends JFrame implements ActionListener {
    private static JButton bAlteraDados;
    private static JButton bConsultaServico;
    private static JButton bExcluirTecnico;
    private static JButton bSair;

    private JPanel pTecnicoPrincipal;

    private Box boxConfirma;
    final private static JLabel lTemCerteza = new JLabel("Tem certeza?");
    private static JButton bConfirma;
    private static JButton bRecusa;

    private int numMatricula;

    public MainTecnico(String numMatricula) {
        super("Bem-vindo! Selecione a opção desejada:");
        this.numMatricula = Integer.parseInt(numMatricula);

        bAlteraDados = new JButton("Alterar dados");
        bConsultaServico = new JButton("Consultar serviço");
        bExcluirTecnico = new JButton("Excluir usuário");
        bSair = new JButton("Sair");

        bAlteraDados.addActionListener(this);
        bConsultaServico.addActionListener(this);
        bExcluirTecnico.addActionListener(this);
        bSair.addActionListener(this);

        Box boxButtons = Box.createVerticalBox();
        boxButtons.add(bAlteraDados);
        boxButtons.add(bConsultaServico);
        boxButtons.add(bExcluirTecnico);
        boxButtons.add(bSair);

        pTecnicoPrincipal = new JPanel();
        pTecnicoPrincipal.setLayout(new BorderLayout(600,300));
        pTecnicoPrincipal.add(boxButtons, BorderLayout.LINE_START);

        bConfirma = new JButton("Prosseguir");
        bRecusa = new JButton("Cancelar");

        bConfirma.addActionListener(this);
        bRecusa.addActionListener(this);

        boxConfirma = Box.createHorizontalBox();
        boxConfirma.add(lTemCerteza);
        boxConfirma.add(bConfirma);
        boxConfirma.add(bRecusa);

        Container contAuxiliar = new Container();
        contAuxiliar.setLayout(new BorderLayout(300,300));
        contAuxiliar.add(boxConfirma, BorderLayout.CENTER);

        pTecnicoPrincipal.add(contAuxiliar, BorderLayout.LINE_END);
        boxConfirma.setVisible(false);
        getContentPane().add(pTecnicoPrincipal);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600,300);
        setResizable(false);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bAlteraDados) {
            // IMPLEMENTAR!
        }

        else if(event.getSource() == bConsultaServico) {
            // IMPLEMENTAR!
        }

        else if(event.getSource() == bExcluirTecnico) {
            boxConfirma.setVisible(true);
        }

        else if(event.getSource() == bConfirma) {
            this.dispose();
        }

        else if(event.getSource() == bRecusa) {
            boxConfirma.setVisible(false);
        }

        else if(event.getSource() == bSair) {
            this.dispose();
        }
    }
}
