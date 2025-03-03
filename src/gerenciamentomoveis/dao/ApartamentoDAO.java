
package gerenciamentomoveis.dao;


import gerenciamentomoveis.conexao.ModuloConexao;
import gerenciamentomoveis.model.Apartamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApartamentoDAO {

    private Connection connection = null;

    // Construtor que inicializa a conexão
    public ApartamentoDAO() {
        ModuloConexao c = new ModuloConexao();
        this.connection = c.retornaConexao();
    }

// Método para adicionar um apartamento ao banco de dados
public void adiciona(Apartamento apartamento) throws SQLException {
    PreparedStatement stmtImovel = null;
    PreparedStatement stmtApartamento = null;
    ResultSet generatedKeys = null;

    try {
        // Inserindo na tabela Imovel
        stmtImovel = this.connection.prepareStatement(
            "INSERT INTO Imovel (tipo, endereco, valor, proprietarioId) VALUES (?, ?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        );
        stmtImovel.setString(1, apartamento.getTipo());
        stmtImovel.setString(2, apartamento.getEndereco());
        stmtImovel.setDouble(3, apartamento.getValor());
        stmtImovel.setInt(4, apartamento.getProprietarioId());
        stmtImovel.executeUpdate();

        // Recuperando o ID gerado para o Imovel
        generatedKeys = stmtImovel.getGeneratedKeys();
        if (generatedKeys.next()) {
            int imovelId = generatedKeys.getInt(1);

            // Inserindo na tabela Apartamento com o ID do Imovel
            stmtApartamento = this.connection.prepareStatement(
                "INSERT INTO Apartamento (id, andar) VALUES (?, ?)"
            );
            stmtApartamento.setInt(1, imovelId);
            stmtApartamento.setInt(2, apartamento.getAndar());
            stmtApartamento.executeUpdate();
        } else {
            throw new SQLException("Falha ao obter o ID gerado para o imóvel.");
        }
    } finally {
        if (generatedKeys != null) {
            generatedKeys.close();
        }
        if (stmtApartamento != null) {
            stmtApartamento.close();
        }
        if (stmtImovel != null) {
            stmtImovel.close();
        }
    }
}


    // Método para retornar todos os apartamentos do banco de dados
    public ArrayList<Apartamento> retorna() throws SQLException {
        ArrayList<Apartamento> apartamentos = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Apartamento";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Apartamento apartamento = new Apartamento(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("endereco"),
                    rs.getDouble("valor"),
                    rs.getInt("proprietarioId"),
                    rs.getInt("andar")
                );
                apartamentos.add(apartamento);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }

        return apartamentos;
    }

    // Método para atualizar um apartamento no banco de dados
    public void update(Apartamento apartamento) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "UPDATE Apartamento SET tipo = ?, endereco = ?, valor = ?, proprietarioId = ?, andar = ? WHERE id = ?"
            );
            stmt.setString(1, apartamento.getTipo());
            stmt.setString(2, apartamento.getEndereco());
            stmt.setDouble(3, apartamento.getValor());
            stmt.setInt(4, apartamento.getProprietarioId());
            stmt.setInt(5, apartamento.getAndar());
            stmt.setInt(6, apartamento.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para deletar um apartamento do banco de dados
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement("DELETE FROM Apartamento WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
