
package a_presentation;



import b_business.Encomenda;
import b_business.Loja;
import b_business.ProdutoEmbalagemPapel;
import b_business.ProdutoEmbalagemPlastico;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.util.ArrayList;
import lib.Console;
/**
 *
 * @author ruiboticas
 */
public class StartConsoleMode {
    
    public static void pause(){
        Console.readString("\n\n !! PRIMA ENTER PARA CONTINUAR !! \n\n");
    }
    
    public static void main(String[] args) throws TaxaIvaInvalidaException, ValorInvalidoException {
        
        // --- Criacao da loja -------------------------------------------------
        String designacaLoja = Console.readString("Indique a designacao da designacao da Loja");
        Loja lj = new Loja(designacaLoja);
        
        int opcao = 0;

        // --- INTERATIVO ------------------------------------------------------
        do{
            // --- MENU --------------------------------------------------------
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=== LOJA DO BOM SUCESSO ======================");
            System.out.println("1. Ver dados da loja");
            System.out.println("2. Total de Iva da Loja");
            System.out.println("------ ENCOMENDAS --------------------------- ");
            System.out.println("3. Nova Encomenda");
            System.out.println("4. Remover Encomenda");
            System.out.println("5. Ver Total da Encomenda com Iva");
            System.out.println("6. Ver Total da Encomenda sem Iva");
            System.out.println("------ PRODUTOS ------------------------ ");
            System.out.println("7. Adicionar Produtos a Encomenda Existente");
            System.out.println("8. Remover Produto de Encomenda Existente");
            System.out.println("0. Sair");
            System.out.println("----------------------------------------- ");
            
            
            opcao = Console.readInt("[ESCOLHA OPCAO]# ");
            System.out.println("\n\n\n");
            switch(opcao){
                case 1:
                        // DADOS DA LOJA
                        System.out.println("=== Loja: " + lj.getDesignacao());
                        System.out.println("=== Total Encomendas: " + lj.getEncomendas().size());
                        System.out.println("--- ENCOMENDAS -------------------------");
                        System.out.println(lj.getEncomendas().toString());
                        pause();
                        break;
                
                case 2:
                        // TOTAL DE IVA LOJA
                        float totalIva = 0.0f;
                        for (Encomenda encomenda : lj.getEncomendas()) {
                            totalIva += (encomenda.calculaTotalComIva() - encomenda.calculaTotalSemIva());
                        }
                        System.out.println("\nTotal de IVA a Loja: " + totalIva);
                        pause();
                        break;
                
                case 3:
                        // NOVA ENCOMENDA
                        //=== Recebe e guarda nas variaveis as informacoes sobre a encomenda ===
                        System.out.println("\n Criacao de um nova encomenda\n");
                        String nomeCliente = Console.readString("Nome cliente: ");
                        
                        //=== Instanciacao de um objeto da classe Encomenda
                        Encomenda encomenda = new Encomenda(nomeCliente);
                        
                        //=== Recebe e guarda na variavel a informacao relativa à quantidade de produtos desejada ===
                        int quantidade = Console.readInt("Quantidade de produtos: ");
                        //=== Ciclo para criacao de produtos pretendidos ======
                        for (int i = 0; i < quantidade; i++) {
                            //=== Pergunta ao utilizador o tipo de produto a adicionar =====
                            int op = Console.readInt("1 - Produto em papel 2 - Produto em plastico\nOpcao: ");
                
                switch (op) {
                        //=== Criacao de um produto em embalagem de papel e adicao do mesmo à encomenda com tratamento de excepcoes
                    case 1:
                        {
                            //=== Recebe e guarda nas variaveis as informacoes sobre o produto ===
                            String designacao = Console.readString("Designacao do produto: ");
                            float preco = (float)Console.readDouble("Preco: ");
                            int taxaIva = Console.readInt("Taxa de IVA: ");
                            
                            //=== Tenta a adicao do produto à encomenda com tratamento de excepcoes e informa o utilizador ===
                            try {
                                ProdutoEmbalagemPapel pPapel = new ProdutoEmbalagemPapel(designacao, preco, taxaIva);
                                encomenda.adicionarProduto(pPapel);
                            } catch (ValorInvalidoException | TaxaIvaInvalidaException e) {      
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        //=== Criacao de um produto em embalagem de plastico e adicao do mesmo à encomenda com tratamento de excepcoes
                    case 2:
                        {
                            //=== Recebe e guarda nas variaveis as informacoes sobre o produto ===
                            String designacao = Console.readString("Designacao do produto: ");
                            float preco = (float)Console.readDouble("Preco: ");
                            int taxaIva = Console.readInt("Taxa de IVA: ");
                            float taxaAdicional = Float.parseFloat(Console.readString("Taxa adicional: "));
                            
                            //=== Tenta a adicao do produto à encomenda com tratamento de excepcoes e informa o utilizador ===
                            try {
                                ProdutoEmbalagemPlastico pPlastico = new ProdutoEmbalagemPlastico(designacao, preco, taxaIva, taxaAdicional);
                                encomenda.adicionarProduto(pPlastico);
                            } catch (ValorInvalidoException | TaxaIvaInvalidaException e) {   
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }
                        }
                        //=== Tenta a adição da encomenda à loja com tratamento de excepções, informando o utilizador ========
                        try {
                            lj.adicionaEncomenda(encomenda);
                            Console.readString("Encomenda realizada com sucesso.");
                        } catch (Exception e) {
                            System.out.println("Falha ao adicionar a encomenda. Tente novamente");
                        }
                        pause();
                        break;
                
                case 4:
                        // REMOVER ENCOMENDA
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomend = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomend.getNomeCliente());
                        }
                        int escolhaRemocao = Console.readInt("Qual a encomenda a eliminar? ");
                        try{
                            lj.getEncomendas().remove(escolhaRemocao);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                        }
                        pause();
                        break;
                
                case 5:
                    //=== Testa a existencia de encomendas na loja =====
                     if (!lj.getEncomendas().isEmpty()) {
                        //=== Lista as encomendas ===
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomend = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomend.getNomeCliente());
                        }
                        //=== Recebe do utilizador e guarda na variavel a informacao sobre a encomenda pretendida ===
                        int escolhaEncomendaSemIva = Console.readInt("Indique qual a encomenda: ");
                        
                        //=== Tenta o calculo do valor da encomenda com Iva com tratamento das excepcoes e informa o utilizador
                        try{
                            System.out.println("Total com Iva: " + lj.getEncomendas().get(escolhaEncomendaSemIva).calculaTotalComIva());
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
//                            pause();
                        }
                    }else{
                    
                        System.out.println("A loja nao tem encomendas.");
                    }
        
                    pause();
                    break;
                
                case 6:
                    //=== Testa a existencia de encomendas na loja =====
                    if (!lj.getEncomendas().isEmpty()) {
                        // VER TOTAL DA ENCOMENDA SEM IVA
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomend = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomend.getNomeCliente());
                        }
                        int escolhaEncomendaSemIva = Console.readInt("Indique qual a encomenda: ");
                        try{
                            System.out.println("Total sem Iva: " + lj.getEncomendas().get(escolhaEncomendaSemIva).calculaTotalSemIva());
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
//                            pause();
                        }
                    }else{
                    
                        System.out.println("A loja nao tem encomendas.");
                    }
                        
                    pause();
                    break;
                
                case 7:
                    //=== Testa a existencia de encomendas na loja =====
                    if (!lj.getEncomendas().isEmpty()) {
                        //=== Lista as encomendas ===
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomend = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomend.getNomeCliente());
                        }
                        //=== Recebe do utilizador a informação sobre a encomenda pretendida, caso exista ===
                        int escolhaEncomendaAdicionarProduto = Console.readInt("Indique qual a encomenda: ");
                        
                        //=== Variavel vai receber a encomenda atraves do indice da mesma no ArrayList das encomendas
                        Encomenda encomendaAdicionarProduto = lj.getEncomendas().get(escolhaEncomendaAdicionarProduto);
                        
                        //=== Recebe do utilizador a informacao sobre o tipo de produto a adicionar ====
                        int tipoProduto = Console.readInt("1 - Produto em papel 2 - Produto em plastico\nOpcao: ");
                switch (tipoProduto) {
                    case 1:
                        {   
                            //=== Recebe e guarda na variavel a designacao escolhida pelo utilizador ===
                            String designacao = Console.readString("Designacao do produto: ");
                            
                            //=== Recebe e guarda na variavel o preco escolhido pelo utilizador ===
                            float preco = Float.parseFloat(Console.readString("Preco do produto: "));
                            
                            //=== Recebe e guarda na variavel o valor do IVA escolhido pelo utilizador ===
                            int taxaIva = Console.readInt("Taxa de IVA: ");
                            
                            //=== Tenta a adicao do produto à encomenda com teste das excepcoes ===
                            try {
                                ProdutoEmbalagemPapel pPapel = new ProdutoEmbalagemPapel(designacao, preco, taxaIva);
                                encomendaAdicionarProduto.adicionarProduto(pPapel);
                                System.out.println("Produto adicionado com sucesso.");
                            } catch (ValorInvalidoException | TaxaIvaInvalidaException e) {      
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    case 2:
                        {
                            String designacao = Console.readString("Designacao do produto: ");
                            float preco = Float.parseFloat(Console.readString("Preco do produto: "));
                            int taxaIva = Console.readInt("Taxa de IVA: ");
                            float taxaAdicional = Float.parseFloat(Console.readString("Taxa adicional: "));
                            try {
                                ProdutoEmbalagemPlastico pPlastico = new ProdutoEmbalagemPlastico(designacao, preco, taxaIva, taxaAdicional);
                                encomendaAdicionarProduto.adicionarProduto(pPlastico);
                                System.out.println("Produto adicionado com sucesso.");
                            } catch (ValorInvalidoException | TaxaIvaInvalidaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    default:
                        System.out.println("Opcao invalida");
                        break;
                        
                }
                        }else{
                            System.out.println("A loja nao tem encomendas.");
                        }
                        pause();
                        break;
                
                case 8:
                    //=== Testa a existencia de encomendas na loja =====
                    if (!lj.getEncomendas().isEmpty()) {
                        //=== Lista as encomendas existentes ====
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomend = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomend.getNomeCliente());
                        }
                        //=== Recebe do utilizador a informação sobre a encomenda pretendida, caso exista ===
                        int escolhaEncomendaRemoverProduto = Console.readInt("Indique qual a encomenda: ");
                        //=== Variavel vai receber a encomenda atraves do indice da mesma no ArrayList das encomendas
                        Encomenda encomRemoverProduto = lj.getEncomendas().get(escolhaEncomendaRemoverProduto);
                        //=== Ciclo para listar os produtos da encomenda escolhida ====
                        for (int i = 0; i < encomRemoverProduto.getProdutosEncomendados().size(); i++) {
                            System.out.println(i + " - " + encomRemoverProduto.getProdutosEncomendados().get(i).getDesignacao());                       
                        }
                        //=== Recebe do utilizador a informacao sobre o produto a remover, caso exista ====
                        int produtoARemover = Console.readInt("Qual a produto a remover? ");
                        //=== Tenta remover o produto pretendido com tratamento das excepcoes ===
                        try{
                            encomRemoverProduto.removeProduto(produtoARemover);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
//                            pause();
                        }
                    }else{
                        System.out.println("A loja nao tem encomendas.");
                    }
                        pause();
                        break;
                                
                case 0:
                        System.out.println("Volte sempre");
                        pause();
                        break;
                default:
                        System.out.println("Opcao Invalida!!!!!");
                        pause();
            }
        }while(opcao != 0);
    }
}
