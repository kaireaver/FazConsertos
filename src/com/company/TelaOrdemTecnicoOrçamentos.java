package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by edvil on 03/07/2017.
 */
public class TelaOrdemTecnicoOrçamentos extends JFrame {
    private JComboBox cbOrdens;

    private JLabel[] jlCampos = {"Cliente"};

    private Container boxSuper;

    public TelaOrdemTecnicoOrçamentos{
        super("Suas Ordens");
        Container container = getContentPane();

        cbOrdens = new JComboBox();

        setSize(315,75);
        setVisible(true);
        setResizable(false);
    }
}
