package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuOptions {
    public static void opt1(List<String> qst, List<String> ans, int id){
        Scanner sc = new Scanner(System.in);
        for (String s : qst) {
            System.out.println(s + " ");
            ans.add(sc.nextLine());
        }

        Usuario user = new Usuario(ans.get(0), ans.get(1), ans.get(2), ans.get(3), id);
        GerenciadorUsuario gerenciar = new GerenciadorUsuario();
        gerenciar.cadastrarUsuario(user, ans, id);
    }

    public static void opt2(){
        GerenciadorUsuario gerenciar = new GerenciadorUsuario();
        gerenciar.listarUsuarios();
    }

    public static void opt3(File file, int numberQuestion){
        Scanner sc = new Scanner(System.in);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            System.out.print("Digite uma nova pergunta para adicionar no questionário: ");
            String question = sc.nextLine();
            bw.write(numberQuestion + " - " + question);
            bw.newLine();
            bw.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("Pergunta número " + numberQuestion + " registrada ao formulário!");
    }
}
