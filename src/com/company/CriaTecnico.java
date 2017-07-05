package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

public class CriaTecnico extends Tela implements ActionListener{
    private JLabel[] jlCampos;
    private  JTextField[] tCampos;
    private String[] jlsCampos = {"Nome: ", "E-mail: ", "Telefone: ","Habilidade: "};

    private Container[] boxCampos;
    private  Container boxSuper;

    private JComboBox cbHabilidades;
    private String[] cbsHabilidades = {"Técnico", "Mecânico", "Programador", "Cozinheiro"};

    private JButton[] bCriaTecnico;
    private String[] bsCriaTecnico = {"Criar", "Cancelar"};

    public CriaTecnico(){
        super("Insira suas informações", 500,150);

        jlCampos = new JLabel[jlsCampos.length];
        tCampos = new JTextField[jlsCampos.length-1];
        boxCampos = new Container[jlsCampos.length+1];
        cbHabilidades = new JComboBox(cbsHabilidades);
        bCriaTecnico = new JButton[bsCriaTecnico.length];

        boxSuper = Box.createVerticalBox();
        Container container = getContentPane();

        container.add(this.boxSuper);

        for(int i = 0; i < jlsCampos.length-1; i++){
            jlCampos[i] = new JLabel(jlsCampos[i]);
            tCampos[i] = new JTextField(5);
            boxCampos[i] = Box.createHorizontalBox();

            boxCampos[i].add(jlCampos[i]);
            boxCampos[i].add(tCampos[i]);
            boxSuper.add(boxCampos[i]);


        }

        boxCampos[3] = Box.createHorizontalBox();
        jlCampos[3] = new JLabel(jlsCampos[3]);
        boxCampos[3].add(jlCampos[3]);
        boxCampos[3].add(cbHabilidades);
        boxSuper.add(boxCampos[3]);

        boxCampos[4] = Box.createHorizontalBox();
        boxSuper.add(boxCampos[4]);

        for(int i = 0; i < bsCriaTecnico.length; i++){
            bCriaTecnico[i] = new JButton(bsCriaTecnico[i]);
            boxCampos[4].add(bCriaTecnico[i]);
        }

        bCriaTecnico[0].addActionListener(this);
        bCriaTecnico[1].addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == bCriaTecnico[1]) {
            if(bCriaTecnico[1].getText() == "Cancelar") {
                fechaTela(true);
            }
            else if(bCriaTecnico[1].getText() == "Recusar") {
                bCriaTecnico[0].setText(bsCriaTecnico[0]);
                bCriaTecnico[1].setText(bsCriaTecnico[1]);

                for(int i = 0; i < tCampos.length; i++)
                    tCampos[i].setEditable(true);
                cbHabilidades.setEnabled(true);
            }
        }
        else if(event.getSource() == bCriaTecnico[0]) {
            if(bCriaTecnico[0].getText() == "Criar") {
                bCriaTecnico[0].setText("Confirmar");
                bCriaTecnico[1].setText("Recusar");

                for(int i = 0; i < tCampos.length; i++)
                    tCampos[i].setEditable(false);
                cbHabilidades.setEnabled(false);
            }
            else if(bCriaTecnico[0].getText() == "Confirmar") {
                // INSERIR NO BANCO DE DADOS!
                fechaTela(true);
            }
        }
    }
}