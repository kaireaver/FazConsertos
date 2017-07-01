package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kings on 12/06/2017.
 */
public class TelaOrdem extends JFrame {

    private JButton[] buttons;
    private String[] nomebotao;


    private BorderLayout layout;

    private JFrame[] nome_campos;
    private JTextField[] campos;

    public TelaOrdem(){
        super("Ordem de Serviços")
        this.layout = new BorderLayout(5,5);
        Container container = getContentPane();
        container.setLayout(this.layout);

    }
}
