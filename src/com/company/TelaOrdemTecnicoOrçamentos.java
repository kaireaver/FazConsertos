package com.company;

import javax.swing.*;
import java.awt.*;

public class TelaOrdemTecnicoOrçamentos extends JFrame {
    private JComboBox cbOrdens;

    private JLabel[] jlCampos = {};

    private Container boxSuper;

    public TelaOrdemTecnicoOrçamentos() {
        super("Suas Ordens");
        Container container = getContentPane();

        cbOrdens = new JComboBox();

        setSize(315,75);
        setVisible(true);
        setResizable(false);
    }
}
