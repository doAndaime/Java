
package b_business;

import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;

/**
 * 2023-03-21 Producao de Java
 * @author Alberto Silva
 */
public class ProdutoEmbalagemPlastico extends Produto {
    
    private float taxaSuplementarSemIva = 0.0f;

    /**
     *
     * @param designacao
     */
    public ProdutoEmbalagemPlastico(String designacao) {
        super(designacao);
    }

    /**
     *
     * @param designacao
     * @param preco
     * @param taxaIva
     * @param taxaSuplementar
     * @throws TaxaIvaInvalidaException
     * @throws ValorInvalidoException
     */
    public ProdutoEmbalagemPlastico(String designacao, float preco, int taxaIva, float taxaSuplementar) throws TaxaIvaInvalidaException, ValorInvalidoException {
        super(designacao, preco, taxaIva);
        this.taxaSuplementarSemIva=taxaSuplementar;
    }

    /**
     *
     * @return
     */
    public float getTaxaSuplementarSemIva() {
        return taxaSuplementarSemIva;
    }

    /**
     *
     * @param taxaSuplementarSemIva
     */
    public void setTaxaSuplementarSemIva(float taxaSuplementarSemIva) {
        this.taxaSuplementarSemIva = taxaSuplementarSemIva;
    }

    /**
     *
     * @return
     */
    @Override
    public float getPrecoSemIva() {
        return super.getPrecoSemIva() + taxaSuplementarSemIva;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "ProdutoEmbalagemPlastico{" + super.toString() + ", " + "taxa suplementar=" + getTaxaSuplementarSemIva() + '}';        
    }    
}
