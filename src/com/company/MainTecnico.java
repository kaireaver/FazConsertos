package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTecnico extends JFrame implements ActionListener {
    private static JButton bAlteraDados;
    private static JButton bConsultaServico;
    private static JButton bExcluirTecnico;

    private JPanel pTecnicoPrincipal;
    private BorderLayout layout;

    private Box boxContainer;
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

        bAlteraDados.addActionListener(this);
        bConsultaServico.addActionListener(this);
        bExcluirTecnico.addActionListener(this);

        Box boxButtons = Box.createVerticalBox();
        boxButtons.add(bAlteraDados);
        boxButtons.add(bConsultaServico);
        boxButtons.add(bExcluirTecnico);

        pTecnicoPrincipal = new JPanel();
        layout = new BorderLayout(350, 125);
        pTecnicoPrincipal.setLayout(layout);
        pTecnicoPrincipal.add(boxButtons, BorderLayout.LINE_START);

        bConfirma = new JButton("Prosseguir");
        bRecusa = new JButton("Cancelar");

        bConfirma.addActionListener(this);
        bRecusa.addActionListener(this);

        Box boxConfirma;
        boxConfirma = Box.createHorizontalBox();
        boxConfirma.add(bConfirma);
        boxConfirma.add(bRecusa);

        boxContainer = Box.createVerticalBox();
        boxContainer.add(lTemCerteza);
        boxContainer.add(boxConfirma);

        pTecnicoPrincipal.add(boxContainer, BorderLayout.LINE_END);
        boxContainer.setVisible(false);
        getContentPane().add(pTecnicoPrincipal);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(350,125);
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
            boxContainer.setVisible(true);
        }

        else if(event.getSource() == bConfirma) {
            this.dispose();
        }

        else if(event.getSource() == bRecusa) {
            boxContainer.setVisible(false);
        }
    }
}
