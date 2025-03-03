
package gerenciamentomoveis.dao;


import gerenciamentomoveis.conexao.ModuloConexao;
import gerenciamentomoveis.model.Locacao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocacaoDAO {

    private Connection connection = null;

    // Construtor que inicializa a conexão
    public LocacaoDAO() {
        ModuloConexao c = new ModuloConexao();
        this.connection = c.retornaConexao();
    }

    // Método para adicionar uma locação ao banco de dados
    public void adiciona(Locacao locacao) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "INSERT INTO Locacao (imovelId, inquilinoId, dataInicio, dataFim) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, locacao.getImovelId());
            stmt.setInt(2, locacao.getInquilinoId());
            stmt.setDate(3, new Date(locacao.getDataInicio().getTime()));
            stmt.setDate(4, new Date(locacao.getDataFim().getTime()));
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para retornar todas as locações do banco de dados
    public ArrayList<Locacao> retorna() throws SQLException {
        ArrayList<Locacao> locacoes = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Locacao";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Locacao locacao = new Locacao(
                    rs.getInt("id"),
                    rs.getInt("imovelId"),
                    rs.getInt("inquilinoId"),
                    rs.getDate("dataInicio"),
                    rs.getDate("dataFim")
                );
                locacoes.add(locacao);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }

        return locacoes;
    }

    // Método para atualizar uma locação no banco de dados
    public void update(Locacao locacao) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "UPDATE Locacao SET imovelId = ?, inquilinoId = ?, dataInicio = ?, dataFim = ? WHERE id = ?"
            );
            stmt.setInt(1, locacao.getImovelId());
            stmt.setInt(2, locacao.getInquilinoId());
            stmt.setDate(3, new Date(locacao.getDataInicio().getTime()));
            stmt.setDate(4, new Date(locacao.getDataFim().getTime()));
            stmt.setInt(5, locacao.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para deletar uma locação do banco de dados
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement("DELETE FROM Locacao WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
