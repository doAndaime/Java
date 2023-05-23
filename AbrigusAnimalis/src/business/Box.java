package business;

import java.util.ArrayList;
import java.util.Objects;

public class Box {
    //=== Variaveis de classe ================================================
    private static int contaBoxes = 0;
    public static final int CAP_MAX = 3;
    //=== Métodos de Classe =================================================

    public static int getContaBoxes() {
        return contaBoxes;
    }
    public static void incrementaContaBoxes(){
        contaBoxes ++;
    }
    
    //=== Métodos construtores ===============================================
    public Box(int setor){
        Box.incrementaContaBoxes();
        this.numeroBox = Box.getContaBoxes();
        this.setor = setor;
    }

    public Box() {
        Box.incrementaContaBoxes();
        this.numeroBox = Box.getContaBoxes();
    }
    //=== Variáveis de instancia =============================================
    private int setor;
    private int numeroBox;
    private String tipoAnimal;
    public ArrayList<Animal> animais = new ArrayList<>();
    
    
    //======================= Getters and Setters =============================

    public int getSetor() {
        return setor;
    }

    public void setSetor(int setor) {
        this.setor = setor;
    }

    public int getNumero() {
        return numeroBox;
    }

    public void setNumero() {
        this.numeroBox = Box.getContaBoxes();
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    
    public void addAnimal(Animal animal){
        if (animais.isEmpty()){// && (this.tipoAnimal == null ? animal.getEspecie() == null : this.tipoAnimal.equals(animal.getEspecie()))) {
            animais.add(animal);
            this.tipoAnimal = animal.getEspecie();
        }
        else {
            if (animal.getEspecie().equals(this.tipoAnimal) && animais.size() < CAP_MAX) {
                animais.add(animal);   
            }else if (!animal.getEspecie().equals(this.tipoAnimal) || animais.size() == CAP_MAX) {
                System.out.println("Capacidade da box superada ou especie não correspondente");
            }
        }     
    }
    
    public ArrayList<Animal> getAnimais(){
        return animais;
    }
    
    public void removerAnimal(Animal animal){
        for (Animal animai : animais) {
            if (animai.equals(animal)) {
                animais.remove(animal);
            }
            else{
                System.out.println("Falha na remocao. Animal inexistente");
            }
        }    
    }
    public void removerAnimal(int id){
        if (id < animais.size() - 1 && id > -1) {
            animais.remove(id);
        }
        else{
            System.out.println("Falha ao remover. Posicao invalida ou inexistente");
        }   
    }
    
    public void moverAnimal(Box box, Animal animal){
        box.addAnimal(animal);
        this.removerAnimal(animal);
    }
    
    //=============== toString() and equals() ===========================

    @Override
    public String toString() {
        return "Box{" + "setor= " + setor + ", numero=" + numeroBox + ", tipoAnimal=" + tipoAnimal + ", animais=" + animais + '}';
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
        final Box other = (Box) obj;
        if (this.setor != other.setor) {
            return false;
        }
        if (this.numeroBox != other.numeroBox) {
            return false;
        }
        if (!Objects.equals(this.tipoAnimal, other.tipoAnimal)) {
            return false;
        }
        return Objects.equals(this.animais, other.animais);
    }
}
