package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class TelaExcluiTecnico extends Tela {
    private Tecnico t;

    final private static JLabel lTemCerteza = new JLabel("Tem certeza?");
    private static JButton bConfirma;
    private static JButton bRecusa;


    public TelaExcluiTecnico(Tecnico t) {
        super("Tela de Exclusão do usuário.", 300,90);
        this.t = t;

        bConfirma = new JButton("Prosseguir");
        bRecusa = new JButton("Cancelar");

        bConfirma.addActionListener(this);
        bRecusa.addActionListener(this);

        Box boxConfirma = Box.createVerticalBox();
        Box boxAux = Box.createHorizontalBox();
        boxConfirma.add(lTemCerteza);
        boxAux.add(bConfirma);
        boxAux.add(bRecusa);
        boxConfirma.add(boxAux);

        getContentPane().add(boxConfirma);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bConfirma) {
            tList.remove(t);
            this.dispose();
        }
        else if(event.getSource() == bRecusa) {
            MainTecnico.setButtonsMainTecnico(true);
            this.dispose();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        MainTecnico.setButtonsMainTecnico(true);
        this.dispose();
    }
}
