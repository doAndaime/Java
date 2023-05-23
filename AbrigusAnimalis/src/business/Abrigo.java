
package business;

import java.util.ArrayList;
import java.util.Objects;

public class Abrigo {
    //=== Métodos construtores ==============================================
    public Abrigo(String nome){
        this.nome = nome;
    }
    public Abrigo(String nome, int telefone, String veterinario){
        this.nome = nome;
        this.telefone = telefone;
        this.veterinario = veterinario;   
    }

    public Abrigo() {
        
    }
    //=== Variáveis de instância ========================================= 
    private String nome;
    private int telefone;
    private String veterinario;
    public ArrayList<Box> boxes = new ArrayList<>();
    private boolean flag = false;

//======================================== Getters e Setters    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }
    
    
//============================================================= Métodos de remoção e adição de Boxes

    public void addBox(Box box){
        if (!boxes.isEmpty()) {
            for (Box boxe : boxes) {
                flag = box.getNumero() == boxe.getNumero(); //============== Testa a existencia da box
            }
            if (flag == true) {
                System.out.println("Falha ao adicionar. Numero da box ja existe");
            }else{
                boxes.add(box);
//                Box.incrementaContaBoxes();
            }
        }else{
            boxes.add(box);
//            Box.incrementaContaBoxes();
        }       
    }
    
    public void removeBox(Box box){
        for (Box boxe : boxes) {
            if (boxe.equals(box)) { //=========== Testa a existencia da box
                boxes.remove(box);
            }
            else{
                System.out.println("Falha na remocao. Box inexistente");
            }
        }
    }
    
    public void removeBox(int numero){
        for (Box boxe : boxes) { //======= Testa a existencia do numero da box
            if (boxe.getNumero() == numero) {
                boxes.remove(numero);
            }
            else{
                System.out.println("Falha na remocao. Numero de box inexistente");
            }
        }
    }
    
    public ArrayList<Box> getBoxes(){
        return boxes;
    }
//============================================================================================== toString() e equals()

    @Override
    public String toString() {
        return "Abrigo{" + "nome=" + nome + ", telefone=" + telefone + ", veterinario=" + veterinario + ", boxes=" + boxes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Abrigo other = (Abrigo) obj;
        if (this.telefone != other.telefone) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.veterinario, other.veterinario)) {
            return false;
        }
        return Objects.equals(this.boxes, other.boxes);
    }
}
