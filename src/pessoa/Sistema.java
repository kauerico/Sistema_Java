package pessoa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Sistema{
    public static int menu(){
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        
        System.out.println("1 - Salvar dados; ");
        System.out.println("2- Ler dados; ");
        System.out.println("1 - Sair");

        escolha = teclado.nextInt(); 
        return escolha; 
    }

    public static void lerDados(){
        String nome, cpf, telefone; 
        float altura; 
        Scanner teclado = new Scanner(System.in);

        System.out.println("Entre com o nome: ");
        nome = teclado.next(); 

        System.out.println("Entre com o CPF: ");
        cpf = teclado.next(); 

        System.out.println("Entre com o telefone: ");
        telefone = teclado.next(); 

        System.out.println("Entre com a altura: ");
        altura = Float.valueOf(teclado.next()); 

        salvar(nome, cpf, altura, telefone, "pessoas.txt");
    }
    
    public static void salvar(String nome, String cpf, float altura, String telefone, String nomeArquivo) {
        File file = new File(nomeArquivo);
        try{
            if(file.exists() == false){
                file.createNewFile();
            }

            FileWriter arquivo = new FileWriter(file, true); 
            arquivo.write(nome + "\n");
            arquivo.write(cpf + "\n");
            arquivo.write(String.valueOf(altura) + "\n");
            arquivo.write(telefone + "\n");
            arquivo.close();
            System.out.println("Salvo com sucesso!");

        }catch (Exception e) {
            
        }
    }
    
    public static void lerArquivo(String nomeArquivo){
        File file = new File(nomeArquivo);
        try {
            Scanner arquivo = new Scanner(file);
            while (arquivo.hasNextLine()) {
                String nome = arquivo.nextLine();
                String cpf = arquivo.nextLine();
                String altura = arquivo.nextLine();
                String telefone = arquivo.nextLine();

                System.out.println("Nome ...: " + nome);
                System.out.println("CPF ...: " + cpf);
                System.out.println("Altura ...: " + altura);
                System.out.println("Telefone ...: " + telefone);
                System.out.println("------------------------------------------");    
            }
            arquivo.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }
   
    public static void executar(){
        int escolha = 0;

        while (escolha != 3) {
            escolha = menu(); 

            if(escolha == 1){
                lerDados();
            } else if(escolha == 2){
                lerArquivo("pessoas.txt");
            }
            
        }
        System.out.println("Saindo do sistema...");
    }
    public static void main(String[] args) {
        executar();

    }
}