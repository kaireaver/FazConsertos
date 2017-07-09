package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class TelaDadosTecnico extends Tela {
    private Tecnico t;

    private static final String sLabels[] = {"Nome: ", "E-mail: ", "Telefone: "};
    private static JLabel[] labels;
    private JTextField[] txtFields;
    private JComboBox combBox;

    private static final String sButtons[] = {"Editar", "Sair"};
    private static JButton[] buttons;

    public TelaDadosTecnico(Tecnico t) {
        super("Dados cadastrais ", 500, 160);
        this.t = t;

        Box boxSuper = Box.createVerticalBox();
        Container container = getContentPane();
        container.add(boxSuper);

        Box boxB[];
        Box bForm = Box.createVerticalBox();

        labels = new JLabel[sLabels.length];
        txtFields = new JTextField[sLabels.length];
        boxB = new Box[sLabels.length];
        combBox = new JComboBox(Tecnico.cbsHabilidades);
        combBox.setEnabled(false);
        combBox.setSelectedIndex(t.getHabID());

        for(int i = 0; i < sLabels.length; i++) {
            labels[i] = new JLabel(sLabels[i]);
            txtFields[i] = new JTextField();
            boxB[i] = novoBoxHorizontal(labels[i], txtFields[i]);
            bForm.add(boxB[i]);

            txtFields[i].setEnabled(false);
            txtFields[i].setDisabledTextColor(Color.black);
        }

        txtFields[0].setText(t.getNome());
        txtFields[1].setText(t.getEmail());
        txtFields[2].setText(t.getTelefone());

        bForm.add(combBox);
        boxSuper.add(bForm);

        buttons = new JButton[sButtons.length];
        Box boxBut = Box.createHorizontalBox();
        for(int i = 0; i < sButtons.length; i++) {
            buttons[i] = new JButton(sButtons[i]);
            buttons[i].addActionListener(this);
            boxBut.add(buttons[i]);
        }

        boxSuper.add(boxBut);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttons[0]) {
            if(buttons[0].getText() == "Editar") {
                for(int i = 0; i < sLabels.length; i++)
                    txtFields[i].setEnabled(true);
                combBox.setEnabled(true);
                buttons[0].setText("Salvar");
                buttons[1].setText("Cancelar");
            }
            else if(buttons[0].getText() == "Salvar") {
                String[] dados = new String[sLabels.length];

                for(int i = 0; i < sLabels.length; i++) {
                    dados[i] = txtFields[i].getText();
                    txtFields[i].setEnabled(false);
                }

                combBox.setEnabled(false);
                String str = (String) combBox.getSelectedItem();
                t.AlteraDados(dados[0], dados[1], dados[2], str);
                buttons[0].setText("Editar");
                buttons[1].setText("Sair");
            }
        }

        else if(e.getSource() == buttons[1]) {
            if(buttons[1].getText() == "Sair") {
                setButton(MainTecnico.bAlteraDados,true);
                setButton(MainTecnico.bConsultaServico,true);
                setButton(MainTecnico.bExcluirTecnico,true);
                setButton(MainTecnico.bSair,true);

                this.dispose();
            }
            else if(buttons[1].getText() == "Cancelar") {
                for(int i = 0; i < sLabels.length; i++)
                    txtFields[i].setEnabled(false);
                combBox.setEnabled(false);
                buttons[0].setText("Editar");
                buttons[1].setText("Sair");
            }
        }


    }

    @Override
    public void windowClosing(WindowEvent e) {
        setButton(MainTecnico.bAlteraDados,true);
        setButton(MainTecnico.bConsultaServico,true);
        setButton(MainTecnico.bExcluirTecnico,true);
        setButton(MainTecnico.bSair,true);

        this.dispose();
    }
}
