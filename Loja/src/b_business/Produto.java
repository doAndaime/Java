
package b_business;

import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.util.Objects;

/**
 * 2023-03-21
 * @author Alberto Silva
 */
public class Produto {
    
    //=== Variavel de classe ========
    private static int produtoNumero;
    
    //=== Métodos de classe ====
    /**
     * Método de acesso ao membro que define o numero do produto
     * @return devolve o numero do produto
     */
    public static int getProdutoNumero() {
        return produtoNumero;
    }

    /**
     * Método que incrementa o numero do produto
     */
    public static void incrementaNumero() {
        Produto.produtoNumero++;
    }
    //=== Variaveis de instancia ================================
    private String referencia;
    private String designacao;
    private float precoSemIva;
    private int taxaIva;

    //=== Métodos de instancia ==================================
    /**
     * Método construtor que define a referencia do produto
     * @param designacao define a designacao do produto
     */
    public Produto(String designacao) {
        incrementaNumero();
        this.referencia = produtoNumero + "";
        this.designacao = designacao; 
    }

    /**
     * Método construtor que define a referencia do produto
     * @param designacao define a designacao do produto
     * @param preco define o preco do produto
     * @param taxaIva define a taxa de Iva a aplicar ao produto
     * @throws TaxaIvaInvalidaException lança excepçao relacionada com a taxa do Iva
     * @throws ValorInvalidoException lança excepçao relacionada com p preco do produto
     */
    public Produto(String designacao, float preco, int taxaIva) throws TaxaIvaInvalidaException, ValorInvalidoException {
        incrementaNumero();
        this.referencia = produtoNumero + "";
        this.designacao = designacao;
        setPrecoSemIva(preco);
        setTaxaIva(taxaIva);
    }

    /**
     * Construtor vazio
     */
    public Produto() {
        incrementaNumero();
        this.referencia = produtoNumero + "";
    }
    
    
    /**
     *  Método de acesso ao membro que define a referencia do produto
     * @return devolve a referencia do produto
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Método que define a referencia do produto
     * @param referencia usado como referencia do produto
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     *  Método de acesso ao membro que define a designacao do produto
     * @return devolve a designacao do produto
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Método que define a designacao do produto 
     * @param designacao usado como designacao do produto
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Método de acesso ao membro que define o preco sem Iva
     * @return devolve o preco sem Iva
     */
    public float getPrecoSemIva() {
        return precoSemIva;
    }

    /**
     * Método que define o preco sem Iva
     * @param precoSemIva usado como preco sem Iva
     * @throws ValorInvalidoException lança excepcao relacionada com o preco invalido
     */
    public final void setPrecoSemIva(float precoSemIva) throws ValorInvalidoException {
        if(precoSemIva >= 0){
            this.precoSemIva = precoSemIva;            
        }else{
            throw new ValorInvalidoException("Preco introduzido invalido ("+precoSemIva+").");
        }
    }

    /**
     * Método de acesso ao membro que define a taxa de Iva
     * @return devolve a taxa de Iva
     */
    public int getTaxaIva() {
        return taxaIva;
    }
    
    /**
     * Método usado para definir a taxa de Iva 
     * @param taxaIva valor da taxa de Iva
     * @throws TaxaIvaInvalidaException lança excepçao relacionada com a taxa de Iva
     */
    public final void setTaxaIva(int taxaIva) throws TaxaIvaInvalidaException{
        if (taxaIva == 6 || taxaIva == 13 || taxaIva == 23) {
            this.taxaIva = taxaIva;
        }else{
            throw new TaxaIvaInvalidaException("Taxa de Iva invalida");
        }
    }

    /**
     * Método que transforma em string as informacoes relativas ao produto
     * @return devolve string com as informacoes
     */
    @Override
    public String toString() {
        return "Produto{" + "Referencia: " + referencia + ", Designacao: " + designacao + ", Preco: " + precoSemIva + ", TaxaIva: " + taxaIva + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.referencia);
        hash = 67 * hash + Objects.hashCode(this.designacao);
        hash = 67 * hash + Float.floatToIntBits(this.precoSemIva);
        hash = 67 * hash + this.taxaIva;
        return hash;
    }

    /**
     * Método usado para comparar objetos
     * @param obj objeto a ser comparado
     * @return devolve verdadeiro se igual ou falso se diferente
     */
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
        final Produto other = (Produto) obj;
        if (Float.floatToIntBits(this.precoSemIva) != Float.floatToIntBits(other.precoSemIva)) {
            return false;
        }
        if (this.taxaIva != other.taxaIva) {
            return false;
        }
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        return Objects.equals(this.designacao, other.designacao);
    }
       
}
