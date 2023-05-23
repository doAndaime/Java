
package b_business;

import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;

/**
 * 2023-03-21
 * @author Alberto Silva
 */
public class ProdutoEmbalagemPapel extends Produto {
    
    /**
     * Método construtor herdado da super classe Produto
     * @param designacao define a designacao do produto
     * @param preco define o preco do produto
     * @param taxaIva define a taxa de IVA a aplicar ao produto
     * @throws TaxaIvaInvalidaException lança excepçao relacionada com taxa de IVA invalida
     * @throws ValorInvalidoException lança excepçao relacionada com o valor do produto invalido
     */
    public ProdutoEmbalagemPapel(String designacao, float preco, int taxaIva) throws TaxaIvaInvalidaException, ValorInvalidoException {
        super(designacao, preco, taxaIva);
    }

    /**
     * Método que transforma as informacoes do produto numa string
     * @return devolve a string com as informacoes do produto
     */
    @Override
    public String toString() {
        return "ProdutoEmbalagemPapel{" + super.toString() +'}';
    }
        
}
