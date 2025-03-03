
package gerenciamentomoveis.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ModuloConexao {
    
    public static Connection con = null;
    
    public Connection retornaConexao(){
           // TODO add your handling code here:
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ImoveisDB", "admin", "admin");
            System.out.println("Conectado.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        
        return con;
    }
}
    
    

