package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuario {
    private List<Usuario> usuarios;

    public GerenciadorUsuario(){
        usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario user, List<String> ans, int id){
        usuarios.add(user);
        salvarUsuarioArquivo(user, ans, id);
    }

    public void salvarUsuarioArquivo(Usuario user, List<String> ans, int id){
        String path = id + " - " + user.getName().replace(" ", "").toUpperCase() + ".txt";
        File file = new File(path);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for(String answer : ans){
                bw.write(answer);
                bw.newLine();
            }
            bw.flush();
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Usuario salvo em " + path);
    }

    public void listarUsuarios(){
        for(Usuario nomes : usuarios){
            System.out.println(nomes.getId() + " - " + nomes.getName());
        }
    }
}
