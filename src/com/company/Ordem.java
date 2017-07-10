package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Ordem {
    private Cliente cliente;
    private String habilidades;

    private int hora;
    private float valor_hora;
    private String data_pedido;
    private int LIM_VALIDADE = 90;
    private String[] materiais;
    private float[] material_valor;
    private float preco;


    private String descricao;
    private boolean validade; //Para determinar se já se passaram os 90 dias
    private String status; //O Status do orçamento

    private static int i = 0;
    private int id; //id do Orçamento
    private int tID;

    public Ordem(Cliente cliente, String descricao, String habilidade) {
        this.cliente = cliente;
        this.validade = true;
        this.status = "Cadastrada";
        this.descricao = descricao;
        this.habilidades = habilidade;
        this.data_pedido = DataDeHoje();
        this.id = i++;
        this.tID = 0;
    }

    public Ordem(Cliente cliente, String descricao, String habilidade, String data_pedido, String tID, String Status) {
        this(cliente, descricao, habilidade);
        this.data_pedido = data_pedido;
        this.descricao = descricao;
        this.tID = Integer.parseInt(tID);
        this.status = Status;
        verificaValidade();
    }

    public void preencheOrcamento(String H, String vH)
    {
        this.valor_hora = Float.parseFloat(vH);
        this.hora = Integer.parseInt(H);
    }

    private void verificaValidade()
    {
        Calendar hoje = Calendar.getInstance();
        Date pedido = Date_pedido();
        long dt = (hoje.getTime().getTime() - pedido.getTime()) + 3600000; // 1 hora para compensar horário de verão
        this.validade = ( dt < LIM_VALIDADE + 1 );
    }

    public void setHora(int hora){
        this.hora = hora;
    }
    public void setValorHora(float valor_hora){
        this.valor_hora = valor_hora;
    }
    public void setMateriais(String[] materiais, float[] material_valor){
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

    public float getValor_hora() {
        return valor_hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getData_pedido()
    {
        return this.data_pedido;
    }

    private Date Date_pedido() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(this.data_pedido.substring(6,10)));
        cal.set(Calendar.MONTH, Integer.parseInt(this.data_pedido.substring(3,5)) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(this.data_pedido.substring(0,2)));
        Date d = cal.getTime();

        return d;
    }


    public int getId() {
        return id;
    }

    public float[] getMaterial_valor() {
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

    @Override
    public String toString() {
        verificaValidade();
        return String.valueOf(this.id) + " - " + this.data_pedido + " - " + this.getHabilidades();
    }

    public String DataDeHoje()
    {
        Date hoje = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");
        return (df.format(hoje));
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        float sum = 0;
        int iter;
        for (iter=0;i<material_valor.length;i++){
            sum += material_valor[iter];
        }
        preco = sum;
    }

    public void aprova(boolean b) {
        if(b)
        {
            this.status = "Aprovada";
            return;
        }
        this.status = "Cancelada";
        return;
    }

    public void realizarOrcamento(Tecnico tecnico) {
    }

    public void settID(int tID) {
        this.tID = tID;
    }
}
