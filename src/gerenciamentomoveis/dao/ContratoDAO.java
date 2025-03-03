
package gerenciamentomoveis.dao;

import gerenciamentomoveis.conexao.ModuloConexao;
import gerenciamentomoveis.model.Contrato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContratoDAO {

    private Connection connection = null;

    // Construtor que inicializa a conexão
    public ContratoDAO() {
        ModuloConexao c = new ModuloConexao();
        this.connection = c.retornaConexao();
    }

    // Método para adicionar um contrato ao banco de dados
    public void adiciona(Contrato contrato) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "INSERT INTO Contrato (locacaoId, dataContrato, valorMensal, duracao) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, contrato.getLocacaoId());
            stmt.setDate(2, new Date(contrato.getDataContrato().getTime()));
            stmt.setDouble(3, contrato.getValorMensal());
            stmt.setInt(4, contrato.getDuracao());
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para retornar todos os contratos do banco de dados
    public ArrayList<Contrato> retorna() throws SQLException {
        ArrayList<Contrato> contratos = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Contrato";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Contrato contrato = new Contrato(
                    rs.getInt("id"),
                    rs.getInt("locacaoId"),
                    rs.getDate("dataContrato"),
                    rs.getDouble("valorMensal"),
                    rs.getInt("duracao")
                );
                contratos.add(contrato);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }

        return contratos;
    }

    // Método para atualizar um contrato no banco de dados
    public void update(Contrato contrato) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "UPDATE Contrato SET locacaoId = ?, dataContrato = ?, valorMensal = ?, duracao = ? WHERE id = ?"
            );
            stmt.setInt(1, contrato.getLocacaoId());
            stmt.setDate(2, new Date(contrato.getDataContrato().getTime()));
            stmt.setDouble(3, contrato.getValorMensal());
            stmt.setInt(4, contrato.getDuracao());
            stmt.setInt(5, contrato.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para deletar um contrato do banco de dados
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement("DELETE FROM Contrato WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
