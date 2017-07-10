package com.company;

import java.awt.event.ActionEvent;

/**
 * Created by Deivison Silva on 09/07/2017.
 */
public class TelaCriaOrcamentoTecnico extends TelaOrdemClienteOrcamento {
    private final Tecnico tecnico;

    TelaCriaOrcamentoTecnico(Ordem o, Tecnico tecnico) {

        super(o);
        this.tecnico = tecnico;
        this.tHora.setEditable(true);
        this.tMateriais.setEditable(true);
        this.tPreco.setEditable(false);
        this.tValHora.setEditable(true);
        this.tValMateriais.setEditable(true);
        this.bAprovar.setText("ENVIAR");
        this.bRecusar.setText("SAIR");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bAprovar)
        {
            this.o.setHora(Integer.parseInt(tHora.getText()));
            this.o.setMateriais(tMateriais.getText(), Float.parseFloat(tValMateriais.getText()));
            this.o.setValorHora(Float.parseFloat(tValHora.getText()));
            this.o.settID(this.tecnico);
            this.o.setStatus("Aguardando Aprovação do Cliente");
            atualizaLista(this.o);
            this.dispose();

        }
        else
        {
            this.dispose();
        }
    }
}
