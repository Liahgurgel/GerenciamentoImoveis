
package gerenciamentomoveis.model;

import java.util.Date;


public class Locacao {
    private int id;
    private int imovelId;
    private int inquilinoId;
    private Date dataInicio;
    private Date dataFim;

    @Override
    public String toString() {
        return id + ", imovelId=" + imovelId + ", inquilinoId=" + inquilinoId + ", datas= " + dataInicio +  " - " + dataFim;
    }

    public Locacao() {
    }

    // Construtor
    public Locacao(int id, int imovelId, int inquilinoId, Date dataInicio, Date dataFim) {
        this.id = id;
        this.imovelId = imovelId;
        this.inquilinoId = inquilinoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImovelId() {
        return imovelId;
    }

    public void setImovelId(int imovelId) {
        this.imovelId = imovelId;
    }

    public int getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(int inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}