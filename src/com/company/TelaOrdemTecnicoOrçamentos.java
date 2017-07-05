package com.company;

import javax.swing.*;
import java.awt.*;

public class TelaOrdemTecnicoOrçamentos extends Tela {
    private JComboBox cbOrdens;

    private JLabel[] jlCampos = {};

    private Container boxSuper;

    public TelaOrdemTecnicoOrçamentos() {
        super("Suas Ordens", 315, 75);
        Container container = getContentPane();

        cbOrdens = new JComboBox();

        setVisible(true);
        }
}
