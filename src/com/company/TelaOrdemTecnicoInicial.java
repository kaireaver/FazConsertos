package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by edvil on 03/07/2017.
 */
public class TelaOrdemTecnicoInicial extends Tela{
    private JButton[] bOrdemCliente;
    private String[] bsOrdemCliente = {"Ver Ordens Ativas", "Ver Ordens Disponiveis"};

    private Container boxSuper;
    public TelaOrdemTecnicoInicial(){
        super("Serviços",315,75);
        Container container = getContentPane();

        boxSuper = Box.createHorizontalBox();
        bOrdemCliente = new JButton[2];

        for (int i = 0; i<bsOrdemCliente.length;i++){
            bOrdemCliente[i] = new JButton(bsOrdemCliente[i]);
            boxSuper.add(bOrdemCliente[i]);
        }
        container.add(boxSuper);

        setVisible(true);
        }
}
