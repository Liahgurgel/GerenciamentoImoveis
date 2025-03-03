
package gerenciamentomoveis.dao;


import gerenciamentomoveis.conexao.ModuloConexao;
import gerenciamentomoveis.model.Casa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CasaDAO {

    private Connection connection = null;

    // Construtor que inicializa a conexão
    public CasaDAO() {
        ModuloConexao c = new ModuloConexao();
        this.connection = c.retornaConexao();
    }
// Método para adicionar uma casa ao banco de dados
public void adiciona(Casa casa) throws SQLException {
    PreparedStatement stmtImovel = null;
    PreparedStatement stmtCasa = null;
    ResultSet generatedKeys = null;

    try {
        // Inserindo na tabela Imovel
        stmtImovel = this.connection.prepareStatement(
            "INSERT INTO Imovel (tipo, endereco, valor, proprietarioId) VALUES (?, ?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        );
        stmtImovel.setString(1, casa.getTipo());
        stmtImovel.setString(2, casa.getEndereco());
        stmtImovel.setDouble(3, casa.getValor());
        stmtImovel.setInt(4, casa.getProprietarioId());
        stmtImovel.executeUpdate();

        // Recuperando o ID gerado para o Imovel
        generatedKeys = stmtImovel.getGeneratedKeys();
        if (generatedKeys.next()) {
            int imovelId = generatedKeys.getInt(1);

            // Inserindo na tabela Casa com o ID do Imovel
            stmtCasa = this.connection.prepareStatement(
                "INSERT INTO Casa (id, numeroQuartos) VALUES (?, ?)"
            );
            stmtCasa.setInt(1, imovelId);
            stmtCasa.setInt(2, casa.getNumeroQuartos());
            stmtCasa.executeUpdate();
        } else {
            throw new SQLException("Falha ao obter o ID gerado para o imóvel.");
        }
    } finally {
        if (generatedKeys != null) {
            generatedKeys.close();
        }
        if (stmtCasa != null) {
            stmtCasa.close();
        }
        if (stmtImovel != null) {
            stmtImovel.close();
        }
    }
}

    // Método para retornar todas as casas do banco de dados
    public ArrayList<Casa> retorna() throws SQLException {
        ArrayList<Casa> casas = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Casa";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Casa casa = new Casa(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("endereco"),
                    rs.getDouble("valor"),
                    rs.getInt("proprietarioId"),
                    rs.getInt("numeroQuartos")
                );
                casas.add(casa);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }

        return casas;
    }

    // Método para atualizar uma casa no banco de dados
    public void update(Casa casa) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "UPDATE Casa SET tipo = ?, endereco = ?, valor = ?, proprietarioId = ?, numeroQuartos = ? WHERE id = ?"
            );
            stmt.setString(1, casa.getTipo());
            stmt.setString(2, casa.getEndereco());
            stmt.setDouble(3, casa.getValor());
            stmt.setInt(4, casa.getProprietarioId());
            stmt.setInt(5, casa.getNumeroQuartos());
            stmt.setInt(6, casa.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para deletar uma casa do banco de dados
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement("DELETE FROM Casa WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}

