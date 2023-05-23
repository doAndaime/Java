
package testes;

import business.Abrigo;
import business.Animal;
import business.Box;
import java.util.ArrayList;
import lib.Console;

public class TestAbrigo {
    public static void main(String[] args) {
        Abrigo abrigo = new Abrigo(); // Instanciação de um objeto da classe Abrigo
        
        //=== Atribuições às propriedades do objeto =============================
        abrigo.setNome("Patudos");
        abrigo.setVeterinario("Dr.Fernando");
        abrigo.setTelefone(123456789);
        
        int nBoxes = Console.readInt("Numero de boxes:");
        for (int i = 0; i < nBoxes; i++) {
            Box box = new Box(); // Instanciação de um objeto da classe Box
            
            //=== Atribuições às propriedades do objeto ==========================
            box.setSetor(Console.readInt("Setor: "));
            box.setTipoAnimal(Console.readString("Tipo de animal: "));
            int nAnimais;
            //=== Ciclo para testar o numero de animais introduzido ===================
            do {
                nAnimais = Console.readInt("Numero de animais: ");
                if (nAnimais > Box.CAP_MAX) {
                    System.out.println("Numero de animais excede o limite permitido");
                }
            } while (nAnimais > Box.CAP_MAX);
            
            for (int j = 0; j < nAnimais; j++) {
                    Animal animal = new Animal();// Instanciação de um objeto da classe Animal

                    //=== Atribuições às propriedades do objeto
                    animal.setNome(Console.readString("Nome: "));
                    animal.setRaca(Console.readString("Raca: "));
                    animal.setEspecie(Console.readString("Especie: "));
                    animal.setIdade(Console.readInt("Idade: "));
                    box.addAnimal(animal); // Adição do objeto Animal ao objeto Box
                }
                abrigo.addBox(box); // Adição do objeto Box ao objeto Abrigo
        }
        
        //Mostra a informação referente ao abrigo criado
        System.out.println("Nome abrigo:"+ abrigo.getNome());
        System.out.println("Veterinario:"+ abrigo.getVeterinario());
        System.out.println("Telefone:"+ abrigo.getTelefone());
        System.out.println("Numero de animais do abrigo:"+ Animal.getContaAnimais());
        System.out.println("Numero de boxes do abrigo:"+ Box.getContaBoxes());
        //Percorre o ArrayList presente no objeto Box e mostra a informação contida no mesmo
        ArrayList<Box> boxes = abrigo.getBoxes();
        for (Box boxe : boxes) {
            System.out.println(boxe.toString());
        }

//        String nome = Console.readString("Nome: ");
//        String veterinario = Console.readString("Veterinario: ");
//        int telefone = Console.readInt("Telefone: ");
//        Abrigo abrigo = new Abrigo(nome, telefone, veterinario);
    }
}
