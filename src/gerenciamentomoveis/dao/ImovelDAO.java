
package gerenciamentomoveis.dao;


import gerenciamentomoveis.conexao.ModuloConexao;
import gerenciamentomoveis.model.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImovelDAO {

    private Connection connection;

    // Construtor que inicializa a conexão
    public ImovelDAO() {
        ModuloConexao c = new ModuloConexao();
        this.connection = c.retornaConexao();
    }

    // Método para retornar todos os registros de Imovel
    public ArrayList<Imovel> retornaTodos() throws SQLException {
        ArrayList<Imovel> imoveis = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Imovel";
            stmt = this.connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Imovel imovel = new Imovel(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("endereco"),
                    rs.getDouble("valor"),
                    rs.getInt("proprietarioId")
                );
                imoveis.add(imovel);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        return imoveis;
    }
}
