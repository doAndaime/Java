
package testes;

import business.Animal;

/**
 *
 * @author efapp0122
 */
public class TestAnimal {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        animal1.setNome("doAndaime");
        animal1.setRaca("Boxer");
        animal1.setEspecie("Cao");
        animal1.setIdade(3);
        
        System.out.println("Nome: " + animal1.getNome());
        System.out.println("Raça: " + animal1.getRaca());
        System.out.println("Especie: " + animal1.getEspecie());
        System.out.println("Idade: " + animal1.getIdade());
    }
}
