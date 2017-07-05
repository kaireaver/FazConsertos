package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCliente extends Tela {
    private JPanel pOpcoes;
    final private JLabel lDescription;
    protected static JButton bNovaSolicitacao;
    protected static JButton bConsultarSolicitacao;
    private Cliente cliente;

    public MainCliente(Cliente cliente)
    {

        super("Bem-vindo ao sistema FazConsertos v1.0 - "+ cliente.Nome, 500, 70);
        this.cliente = cliente;
        lDescription = new JLabel("SOLICITAÇÕES: ");

        bNovaSolicitacao = new JButton("      NOVA       ");
        bNovaSolicitacao.addActionListener(this);
        
        bConsultarSolicitacao = new JButton("CONSULTAR");
        bConsultarSolicitacao.addActionListener(this);


        pOpcoes = new JPanel();
        pOpcoes.add(lDescription);
        pOpcoes.add(bNovaSolicitacao);
        pOpcoes.add(bConsultarSolicitacao);

        getContentPane().add(pOpcoes);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == bNovaSolicitacao) {
            JFrame fNovaSolicitacao = new TelaOrdemCliente();
            setButton(bNovaSolicitacao, false);
            setButton(bConsultarSolicitacao, false);
        }

        else if(event.getSource() == bConsultarSolicitacao)
        {
            JFrame fConsultaSolicitacao = new TelaClienteConsulta() ;
            setButton(bNovaSolicitacao, false);
            setButton(bConsultarSolicitacao, false);
        }
    }
    
    

}
