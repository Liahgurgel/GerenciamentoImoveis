
package gerenciamentomoveis.dao;
import gerenciamentomoveis.conexao.ModuloConexao;
import gerenciamentomoveis.model.Proprietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ProprietarioDAO {

    private Connection connection = null;

    // Construtor que inicializa a conexão
    public ProprietarioDAO() {
        ModuloConexao c = new ModuloConexao();
        this.connection = c.retornaConexao();
    }

    // Método para adicionar um proprietário ao banco de dados
    public void adiciona(Proprietario proprietario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "INSERT INTO Proprietario (nome, telefone, email, endereco) VALUES (?, ?, ?, ?)"
            );
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getTelefone());
            stmt.setString(3, proprietario.getEmail());
            stmt.setString(4, proprietario.getEndereco());
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para retornar todos os proprietários do banco de dados
    public ArrayList<Proprietario> retorna() throws SQLException {
        ArrayList<Proprietario> proprietarios = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Proprietario";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Proprietario proprietario = new Proprietario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("endereco")
                );
                proprietarios.add(proprietario);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }

        return proprietarios;
    }

    // Método para atualizar um proprietário no banco de dados
    public void update(Proprietario proprietario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "UPDATE Proprietario SET nome = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?"
            );
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getTelefone());
            stmt.setString(3, proprietario.getEmail());
            stmt.setString(4, proprietario.getEndereco());
            stmt.setInt(5, proprietario.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para deletar um proprietário do banco de dados
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement("DELETE FROM Proprietario WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}