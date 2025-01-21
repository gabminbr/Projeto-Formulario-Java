package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String name, email, age, height;
    private int id;

    public Usuario(){
    }

    public Usuario(String name, String email, String age, String height, int id){
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getHeight() {
        return height;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return String.format("%s\n" +
                "%s\n" +
                "%s\n" +
                "%.2s", getName(), getEmail(), getAge(), getHeight());
    }
}
