package application;

import entities.GerenciadorUsuario;
import entities.MenuOptions;
import entities.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String basePath = System.getProperty("user.dir");
        String caminhoArquivo = basePath + File.separator + "FormularioCLI" + File.separator +  "resources" + File.separator + "questionario.txt";
        File file = new File(caminhoArquivo);
        List<String> questions = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();
            while(line != null) {
                questions.add(line);
                line = br.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        int menuAns;
        int idUser = 0;
        int numberQuestion = 5;

        do {
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Listar todos usuários cadastrados");
            System.out.println("3 - Cadastrar nova pergunta no formulário");
            System.out.println("4 - Deletar pergunta do formulário");
            System.out.println("5 - Pesquisar usuário por nome");
            System.out.println("6 - Encerrar");
            System.out.println();

            System.out.print("Opção desejada: ");
            menuAns = Integer.parseInt(sc.nextLine());

            switch (menuAns) {
                case 1:
                    idUser++;
                    MenuOptions.opt1(questions, idUser);
                    break;
                case 2:
                    MenuOptions.opt2();
                    break;
                case 3:
                    MenuOptions.opt3(file, numberQuestion);
                    numberQuestion++;
                    break;
                case 4:
                    MenuOptions.opt4(file);
                case 5:
                    MenuOptions.opt5();
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("resposta invalida paizao tenta de novo");
                    break;
            }
            System.out.println();
        }
        while(menuAns != 6);

        sc.close();
    }
}