package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String name;
    private String email;
    private Integer age;
    private Double height;
    private int id;

    public Usuario(){
    }

    public Usuario(String name, String email, Integer age, Double height, int id){
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

    public Integer getAge() {
        return age;
    }

    public Double getHeight() {
        return height;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return String.format("%s\n" +
                "%s\n" +
                "%d\n" +
                "%.2f", getName(), getEmail(), getAge(), getHeight());
    }
}
