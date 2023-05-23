
package b_business;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ruiboticas
 */
public class Loja {
    private String designacao;
    private final ArrayList<Encomenda> encomendas;

    public Loja(String designacao) {
        this.designacao = designacao;
        this.encomendas = new ArrayList<>();
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public ArrayList<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void adicionaEncomenda(Encomenda e){
        encomendas.add(e);
    }
    
    public void removeEncomenda(int i){
        encomendas.remove(i);
    }

    @Override
    public String toString() {
        return "Loja{" + "designacao=" + designacao + ", encomendas=" + encomendas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.designacao);
        hash = 97 * hash + Objects.hashCode(this.encomendas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loja other = (Loja) obj;
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        return Objects.equals(this.encomendas, other.encomendas);
    }
}
