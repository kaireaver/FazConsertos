package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by edvil on 01/07/2017.
 */
public class TelaServicos extends Tela {

    private JButton[] buttons;
    private String[] nomebotao;

    private BorderLayout layout;

    private JFrame[] nome_campos;
    private JTextField[] campos;

    public TelaServicos(){
        super("Ordem de Serviços", 500,150);
        this.layout = new BorderLayout(5,5);
        Container container = getContentPane();
        container.setLayout(this.layout);

    }
}
