package com.company;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by edvil on 01/07/2017.
 */
public class Ordem {
    Cliente cliente;

    private int hora;
    private int valor_hora;
    private Date data_pedido;

    private String[] materiais;
    private int[] material_valor;
    private String habilidades;

    private String descricao;
    private boolean validade; //Para determinar se já se passaram os 90 dias
    private String status; //O Status do orçamento

    private static int i = 0;
    private int id; //id do Orçamento
    private int tID;

    public Ordem(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.validade = true;
        this.status = "Cadastrada";
        this.descricao = descricao;

        this.id = i;
        this.id++;
    }

    public void setHora(int hora){
        this.hora = hora;
    }
    public void setValorHora(int valor_hora){
        this.valor_hora = valor_hora;
    }
    public void setDataPedido(Date data_pedido){
        this.data_pedido = data_pedido;
    }
    public void setMateriais(String[] materiais, int[] material_valor){
        this.materiais = materiais;
        this.material_valor = material_valor;
    }
    public void setValidade(boolean validade){
        this.validade = validade;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public int getHora() {
        return hora;
    }

    public int getValor_hora() {
        return valor_hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public static int getI() {
        return i;
    }

    public int getId() {
        return id;
    }

    public int[] getMaterial_valor() {
        return material_valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String[] getMateriais() {
        return materiais;
    }

    public int gettID() {
        return tID;
    }

    public String getHabilidades() {
        return habilidades;
    }
}
