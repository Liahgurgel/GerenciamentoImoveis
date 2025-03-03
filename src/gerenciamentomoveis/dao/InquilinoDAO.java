
package gerenciamentomoveis.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import gerenciamentomoveis.conexao.ModuloConexao;
import gerenciamentomoveis.model.Inquilino;

public class InquilinoDAO {

    private Connection connection = null;

    // Construtor que inicializa a conexão
    public InquilinoDAO() {
        ModuloConexao c = new ModuloConexao();
        this.connection = c.retornaConexao();
    }

    // Método para adicionar um inquilino ao banco de dados
    public void adiciona(Inquilino inquilino) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "INSERT INTO Inquilino (nome, telefone, email, dataCadastro) VALUES (?, ?, ?, ?)"
            );
            stmt.setString(1, inquilino.getNome());
            stmt.setString(2, inquilino.getTelefone());
            stmt.setString(3, inquilino.getEmail());
            stmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para retornar todos os inquilinos do banco de dados
    public ArrayList<Inquilino> retorna() throws SQLException {
        ArrayList<Inquilino> inquilinos = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Inquilino";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Inquilino inquilino = new Inquilino(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                inquilinos.add(inquilino);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }

        return inquilinos;
    }

    // Método para atualizar um inquilino no banco de dados
    public void update(Inquilino inquilino) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(
                "UPDATE Inquilino SET nome = ?, telefone = ?, email = ?, dataCadastro = ? WHERE id = ?"
            );
            stmt.setString(1, inquilino.getNome());
            stmt.setString(2, inquilino.getTelefone());
            stmt.setString(3, inquilino.getEmail());
            stmt.setDate(4, new Date(inquilino.getDataCadastro().getTime()));
            stmt.setInt(5, inquilino.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para deletar um inquilino do banco de dados
    public void delete(int id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement("DELETE FROM Inquilino WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
