package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTecnico extends JFrame implements ActionListener {
    private static JButton bAlteraDados;
    private static JButton bConsultaServico;
    private static JButton bExcluirTecnico;

    private JPanel pTecnicoPrincipal;
    private Box container;
    private Box pConfirma;
    final private static JLabel lTemCerteza = new JLabel("Tem certeza que deseja excluir o técnico?");
    private static JButton bConfirma;
    private static JButton bRecusa;

    private int numMatricula;

    public MainTecnico() {
        super("Bem-vindo! Selecione a opção desejada:");

        bAlteraDados = new JButton("Alterar dados de usuário");
        bConsultaServico = new JButton("Consultar serviço");
        bExcluirTecnico = new JButton("Excluir usuário");

        pTecnicoPrincipal = new JPanel();
        pTecnicoPrincipal.add(bAlteraDados);
        pTecnicoPrincipal.add(bConsultaServico);
        pTecnicoPrincipal.add(bExcluirTecnico);

        bConfirma = new JButton("Prosseguir");
        bRecusa = new JButton("Cancelar");

        pConfirma = Box.createHorizontalBox();
        pConfirma.add(bConfirma);
        pConfirma.add(bRecusa);

        container = Box.createVerticalBox();
        container.add(lTemCerteza);
        container.add(pConfirma);
        pTecnicoPrincipal.add(container);

        container.setVisible(false);
        getContentPane().add(pTecnicoPrincipal);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,100);
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
            container.setVisible(true);
        }
    }
}
