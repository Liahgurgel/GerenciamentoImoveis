
package gerenciamentomoveis.model;

public class Casa extends Imovel {
    private int numeroQuartos;

    // Construtor
    public Casa(int id, String tipo, String endereco, double valor, int proprietarioId, int numeroQuartos) {
        super(id, tipo, endereco, valor, proprietarioId);
        this.numeroQuartos = numeroQuartos;
    }

    public Casa() {
    }

    // Getter e Setter
    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }
}