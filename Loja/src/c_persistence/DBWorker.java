
package c_persistence;

import b_business.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ruiboticas
 */
public class DBWorker {
    private Connection conn;
    
    public DBWorker(String servidor, String user, String password, String baseDados) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/"+ baseDados + "?" + "user=" + user + "&password=" + password);        
    }
    
    public void guardar(Produto p) throws SQLException {
        
        String stringSQL = "INSERT INTO produto(referencia_produto, designacao_produto, preco_produto, taxa_iva) VALUES('?', '?', ?, ?)";
        Produto produto = new Produto();
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.setString(1, produto.getReferencia());
        pst.setString(2, produto.getDesignacao());
        pst.setFloat(3, produto.getPrecoSemIva());
        pst.setInt(4, produto.getTaxaIva());
        
        pst.executeUpdate(stringSQL);
        
        if(pst != null){
            pst.close();
        }
    }
    
//    public ArrayList<Formando> getAllFormandos() throws SQLException {
//        ArrayList<Formando> formandos = new ArrayList<>();
//        
//        String stringsql = "SELECT * FROM formando";
//        
//        PreparedStatement pst = conn.prepareStatement(stringsql);
//        ResultSet rs = pst.executeQuery();
//        
//        while(rs.next()){
//            Formando f = new Formando();
//            f.setNumero();
//            f.setNome((rs.getString("nome")));
//            f.setIdade(rs.getInt("idade"));
//            f.setMorada(rs.getString("morada"));
//            f.setNota(rs.getInt("nota"));
//            formandos.add(f);
//        }
//        
//        if(pst != null){
//            pst.close();
//        }
//        
//        return formandos;
    }



