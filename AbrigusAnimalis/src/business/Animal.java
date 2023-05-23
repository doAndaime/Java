
package business;

import java.util.Objects;


public class Animal {
    //=== Variaveis de Classe ==================================
    private static int contaAnimais = 0;

    //=== Métodos da Classe ====================================
    public static int getContaAnimais() {
        return contaAnimais;
    }
    
    public static void incrementaContaAnimais(){
        contaAnimais ++;
    }
    
    //=== Métodos construtores ================================================
    public Animal(String nome, String raca, String especie, int idade){
        Animal.incrementaContaAnimais();
        this.ID = Animal.getContaAnimais();
        this.nome = nome;
        this.raca = raca;
        this.especie = especie;
        this.idade = idade;
    }

    public Animal() {
        Animal.incrementaContaAnimais();
        ID = Animal.getContaAnimais();
    }
    
    //=== Variáveis de instância ============================================
    private String nome;
    public final int ID;
    private String raca;
    private String especie;
    private int idade;

    //============================== Getters and Setters ====================
    public String getNome() {
        return nome;
    }

    public void setNome(String animal) {
        this.nome = animal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public int getId(){
        return ID;
    }
    
    //================== toString() ============================

    @Override
    public String toString() {
        return "Animal{" + "animal=" + nome + ", id=" + ID + ", raca=" + raca + ", especie=" + especie + ", idade=" + idade + '}';
    }
    //============= equals() =========================

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
        final Animal other = (Animal) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        return Objects.equals(this.especie, other.especie);
    }
    
}
