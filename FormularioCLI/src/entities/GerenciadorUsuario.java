package entities;

import exceptions.NotAllowedInfoException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuario {
    private List<Usuario> usuarios = new ArrayList<>();

    public GerenciadorUsuario(){
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

    // Busca na lista usuarios os nomes e faz uma busca se alguma parte do nome de cada usuario bate com o padrao fornecido
    public void acessarUsuarios(String toFind){
        Boolean found = false;
        for(Usuario user : usuarios) {
            if(user.getName().contains(toFind)){
                System.out.println(user.getName());
                found = true;
            }
        }

        if(!found){
            System.out.println("Não existe um usuário cadastrado com esse nome");
        }
    }

    public void validarInformacoes(List<String> answers) throws NumberFormatException, NotAllowedInfoException{
        //validar se a idade está sendo informada em inteiro e altura em double
        try{
            Integer age = Integer.parseInt(answers.get(2));
            Double height = Double.parseDouble(answers.get(3).replace(",", "."));
        } catch(NumberFormatException n){
            throw new NumberFormatException();
        }

        String name = answers.get(0);
        String email = answers.get(1);
        String age = answers.get(2);
        String height = answers.get(3);

        if(name.length() < 10){
            throw new NotAllowedInfoException("O nome deve possuir mais de 10 caracteres!");
        } else if(!email.contains("@")){
            throw new NotAllowedInfoException("Por favor, insira um email real!");
        } else if(Integer.valueOf(age) < 18){
            throw new NotAllowedInfoException("O(a) usuário(a) deve possuir mais de 18 anos!");
        } else if(height.contains(",") && !height.contains(".")){
            throw new NotAllowedInfoException("A altura deve ser informada usando vírgulas para representar casas decimais!");
        }

        //verificar se o email vai ser duplicado
        for(Usuario usuario : usuarios){
            if(email.equals(usuario.getEmail())){
                throw new NotAllowedInfoException("O email já foi cadastrado!");
            }
        }

    }
}
