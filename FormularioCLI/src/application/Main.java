package application;

import entities.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("questionario.txt");
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

        for(String qst : questions) {
            System.out.print(qst + " ");
            answers.add(sc.nextLine());
        }

        Usuario user = new Usuario(answers.get(0), answers.get(1), Integer.valueOf(answers.get(2)), Double.valueOf(answers.get(3)));
        System.out.println(user);

        String pathname = answers.get(0).replace(" ", "").toUpperCase() + ".txt";
        File user1 = new File(pathname);
        try{
            user1.createNewFile();
        } catch(IOException e){
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(user1))){
            for(String s: answers){
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}