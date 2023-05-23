
package persistence;

import business.Formando;
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
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/"+ baseDados + "?" + "user=" + user + "&password=" + password);        
    }
    
    public void guardar(Formando f) throws SQLException {
        
        String stringSQL = "INSERT INTO formando(numero, nome, idade, morada, nota) VALUES(?, ?, ?, ?, ?)";
        
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.setInt(1, f.getNumero());
        pst.setString(2, f.getNome());
        pst.setInt(3, f.getIdade());
        pst.setString(4, f.getMorada());
        pst.setInt(5, f.getNota());
        
        if(pst != null){
            pst.close();
        }
    }
    
    public ArrayList<Formando> getAllFormandos() throws SQLException {
        ArrayList<Formando> formandos = new ArrayList<>();
        
        String stringsql = "SELECT * FROM formando";
        
        PreparedStatement pst = conn.prepareStatement(stringsql);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            Formando f = new Formando();
            f.setNumero(rs.getInt("numero"));
            f.setNome((rs.getString("nome")));
            f.setIdade(rs.getInt("idade"));
            f.setMorada(rs.getString("morada"));
            f.setNota(rs.getInt("nota"));
            formandos.add(f);
        }
        
        if(pst != null){
            pst.close();
        }
        
        return formandos;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
//    
//    
//    private Connection connect = null;
//    private Statement statement = null;
//    private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;
//    
//    public DBWorker(String servidor, String username, String password, String base_dados) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        connect = DriverManager.getConnection("jdbc:mysql://" + servidor + "/"+ base_dados + "?" + "user=" + username + "&password=" + password);
//    }
//    
//    public void obterFormandos() throws ClassNotFoundException, SQLException {
//
//        statement = connect.createStatement();
//        resultSet = statement.executeQuery("select * from formando");
//        while(resultSet.next()){
//            System.out.print("id=" + resultSet.getInt("codigo"));
//            System.out.print("nome=" + resultSet.getInt("codigo"));
//        }
//    }
//    
//    public void guardaFormando(Formando f) throws SQLException {
//    
//        preparedStatement = connect.prepareStatement("insert into formando values (default, ?, ?, ?, ?)");
//
//        preparedStatement.setString(1, "Maria");
//        preparedStatement.setString(2, "Rua das couves");
//        preparedStatement.setString(3, "35");
//        preparedStatement.setString(5, "987987987");
//        preparedStatement.setString(6, "18");
//
//        preparedStatement.executeUpdate();
//
//    }

    public DBWorker(Connection conn) {
        this.conn = conn;
    }
}


