package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOptions {
    static GerenciadorUsuario gerenciador = new GerenciadorUsuario();
    static Scanner sc = new Scanner(System.in);

    public static void opt1(List<String> qst, List<String> ans, int id){
        for (String s : qst) {
            System.out.println(s + " ");
            ans.add(sc.nextLine());
        }

        Usuario user = new Usuario(ans.get(0), ans.get(1), ans.get(2), ans.get(3), id);
        gerenciador.cadastrarUsuario(user, ans, id);
    }

    public static void opt2(){
        gerenciador.listarUsuarios();
    }

    public static void opt3(File file, int numberQuestion){
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

    public static void opt4(File file){
        System.out.print("Informe o número da pergunta que deseja deletar (não pode deletar" +
                "as perguntas de 1 - 4): ");
        int perguntaDeletada = Integer.parseInt(sc.nextLine());
        if(perguntaDeletada <= 4){
            System.out.println("Não foi possível apagar!");
        }
        else {
            List<String> questionario = new ArrayList<>();

            // Fazer a leitura e gravar as novas perguntas agora sem a que foi especificada para deletar

            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String line = br.readLine();
                while(line != null){
                    if(line.startsWith(String.valueOf(perguntaDeletada))){
                        line = br.readLine();
                        continue;
                    }
                    questionario.add(line);
                    line = br.readLine();
                }
            } catch(IOException e){
                e.printStackTrace();
            }

            // Sobrescrever o arquivo questionario.txt com a pergunta já deletada

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                for(String line : questionario) {
                    bw.write(line);
                    bw.newLine();
                }
                bw.flush();
            } catch(IOException e){
                e.printStackTrace();
            }

            System.out.println("o arquivo de questionário foi modificado!");
        }
    }
}
