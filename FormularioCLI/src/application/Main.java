package application;

import entities.GerenciadorUsuario;
import entities.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("C:\\Users\\gabmi\\IdeaProjects\\Projeto-Formulario-Java\\FormularioCLI\\questionario.txt");
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();
            while(line != null) {
                questions.add(line);
                line = br.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        for(String s : questions){
            System.out.println(s + " ");
            answers.add(sc.nextLine());
        }

        String userName = answers.get(0);
        String userEmail = answers.get(1);
        Integer userAge = Integer.valueOf(answers.get(2));
        Double userHeight = Double.valueOf(answers.get(3));
        int userId = 1;

        Usuario usuario = new Usuario(userName, userEmail, userAge, userHeight, userId);
        GerenciadorUsuario userGerenc = new GerenciadorUsuario();
        userGerenc.cadastrarUsuario(usuario, answers);


    }
}