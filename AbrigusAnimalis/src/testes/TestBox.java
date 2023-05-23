
package testes;

import business.Animal;
import business.Box;
import java.util.ArrayList;
import lib.Console;

/*
 * @author Alberto Silva
 */
public class TestBox {
    public static void main(String[] args) {
        Box box1 = new Box(); // Instanciação de um objeto(box1) da classe Box
        Box box2 = new Box();
//==================== Inicialização dos atributos da class ==========================      
        box1.setSetor(1);
        box1.setTipoAnimal("Cao");
        box2.setSetor(2); 
//=================== Adição de animais na box ======================================= 
        int nAnimais = Console.readInt("Numero de animais?");
        for (int i = 0; i < nAnimais; i++) {
            Animal animal = new Animal();
            animal.setNome(Console.readString("Nome:"));
            animal.setRaca(Console.readString("Raça:"));
            animal.setEspecie(Console.readString("Especie:"));
            animal.setIdade(Console.readInt("Idade:"));
            box1.addAnimal(animal);
        }
        Animal animal1 = new Animal("Fufi","nd","gato",4);
        box1.addAnimal(animal1);
        // Move animal de uma box para a outra, utilizando os objetos correspondentes
        box1.moverAnimal(box2, animal1);
//======================= Prints para o ecra ==========================================
        System.out.println("_____________________________");
        System.out.println("Setor:"+ box1.getSetor());
        System.out.println("Numero:"+ Box.getContaBoxes());
        System.out.println("Tipo animal:"+ box1.getTipoAnimal());
        System.out.println("\nLista de animais:");
        //Declaração e inicialização do ArrayList que recebe a lista de animais
        ArrayList<Animal> animais = box1.getAnimais();
        for (Animal animai : animais) {
            System.out.println(animai.toString());
        }
        System.out.println(box2.toString());
    }
}
