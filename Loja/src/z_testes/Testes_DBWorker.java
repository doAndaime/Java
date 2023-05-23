
package z_testes;
import b_business.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import c_persistence.DBWorker;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
/**
 *
 * @author efapp0122
 */
public class Testes_DBWorker {
    public static void main(String[] args) throws ValorInvalidoException, TaxaIvaInvalidaException {
        DBWorker dbWorker;
        try {
            dbWorker = new DBWorker("192.168.64.5", "root", "123", "mydb");
            Produto product = new Produto();
//            ArrayList<Formando> formandos = dbWorker.getAllFormandos();
            product.setReferencia( "yoh");
            product.setDesignacao("Bolachas");
            product.setPrecoSemIva(10);
            product.setTaxaIva(23);
            
            dbWorker.guardar(product);
            
//            for (Formando formando : formandos) {
//                System.out.println(formando);
//            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Testes_DBWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
