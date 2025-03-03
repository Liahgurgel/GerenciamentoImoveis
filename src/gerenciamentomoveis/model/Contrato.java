
package gerenciamentomoveis.model;

import java.util.Date;


public class Contrato {
    private int id;
    private int locacaoId;
    private Date dataContrato;
    private double valorMensal;
    private int duracao;

    public Contrato() {
    }

    // Construtor
    public Contrato(int id, int locacaoId, Date dataContrato, double valorMensal, int duracao) {
        this.id = id;
        this.locacaoId = locacaoId;
        this.dataContrato = dataContrato;
        this.valorMensal = valorMensal;
        this.duracao = duracao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocacaoId() {
        return locacaoId;
    }

    public void setLocacaoId(int locacaoId) {
        this.locacaoId = locacaoId;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}