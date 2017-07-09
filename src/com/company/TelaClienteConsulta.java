package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Base64;

/**
 * Created by edvil on 05/07/2017.
 */

public class TelaClienteConsulta extends Tela {

    private final Box boBotoes;
    private final JButton bAtualizar;
    static JButton bAprovar;
    private Cliente cliente;
    private JComboBox<Ordem> cbOrdem;
    private JLabel jlOrdem;

    private  JTextField[] tCampos;
    private  JTextArea tCampoDescr;
    private JLabel[] jlCampos;
    private String[] sCampos = {"Descrição:    ", "Tecnico:       ", "Status:          "};

    private Container boxSuper;
    private Container boxCampos[];
    private Ordem ordem;

    public TelaClienteConsulta(Cliente cliente)
    {
        super("Suas Ordens ativas!", 500, 190);
        this.cliente = cliente;
        Container container = getContentPane();

        cbOrdem = new JComboBox<>(getOrdens());
        jlOrdem = new JLabel("Orçamento: ");

        tCampos = new JTextField[sCampos.length];
        jlCampos = new JLabel[sCampos.length];


        boxSuper = Box.createVerticalBox();
        boxCampos = new Container[sCampos.length + 1];

        boxCampos[3] = novoBoxHorizontal(jlOrdem, cbOrdem);
        boxSuper.add(boxCampos[3]);

        for (int i = 1; i<sCampos.length; i++){
            tCampos[i] = new JTextField(20);
            jlCampos[i] = new JLabel(sCampos[i]);
            this.tCampos[i].setEditable(false);

            boxCampos[i] = novoBoxHorizontal(jlCampos[i], tCampos[i]);
            boxSuper.add(boxCampos[i]);
        }

        tCampoDescr = new JTextArea(5,7);
            jlCampos[0] = new JLabel(sCampos[0]);
            this.tCampoDescr.setEditable(false);
            boxCampos[0] = novoBoxHorizontal(jlCampos[0], tCampoDescr);
            boxSuper.add(boxCampos[0]);

        boBotoes = Box.createHorizontalBox();
            bAtualizar = new JButton("ATUALIZAR");
            bAtualizar.addActionListener(this);
            bAprovar = new JButton("ORÇAMENTO");
            setButton(bAprovar, false);
            bAprovar.addActionListener(this);
            boBotoes.add(bAtualizar);
            boBotoes.add(bAprovar);

        boxSuper.add(boBotoes);

        container.add(boxSuper);
        setVisible(true);
    }

    private Ordem[] getOrdens(){
        ArrayList<Ordem> aS = new ArrayList<>();

        for (Ordem o:oList)
        {
            if(o.getCliente().getCPF().equals(this.cliente.getCPF()))
            {
                aS.add(o);
            }
        }

      int tam = aS.size()+1;
        Ordem[] S = new Ordem[tam];
        int i = 0;
        for (Ordem s: aS)
        {
            S[i++] = s;
        }

        return S;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        setButton(TelaMainCliente.bNovaSolicitacao,true);
        setButton(TelaMainCliente.bConsultarSolicitacao,true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bAtualizar)
        {
            atualizaOrdemNaTela();
        }
        if(e.getSource() == bAprovar)
        {
            if(bAprovar.getText() == "ORÇAMENTO")
            {
                Tela Orcamento = new TelaOrdemClienteOrcamento(this.ordem);
                atualizaOrdemNaTela();
               // JOptionPane.showMessageDialog(null, "MOMENTO DE VISUALIZAR O ORÇAMENTO");
            }
        }
    }

    public void atualizaOrdemNaTela()
    {
        this.ordem = (Ordem) cbOrdem.getSelectedItem();
        if(this.ordem == null) return;
        this.tCampoDescr.setText(this.ordem.getDescricao());
        if(this.ordem.gettID() == 0 )
            this.tCampos[1].setText("Nenhum técnico até o momento");
        else
            this.tCampos[1].setText(String.valueOf(this.ordem.gettID()));
        this.tCampos[2].setText(String.valueOf(this.ordem.getStatus()));
        if(this.ordem.getStatus().equals("Aguardando Aprovação do Cliente"))
        {
            bAprovar.setText("ORÇAMENTO");
            setButton(bAprovar, true);
        }
        else
        {
            setButton(bAprovar, false);
        }
    }
}