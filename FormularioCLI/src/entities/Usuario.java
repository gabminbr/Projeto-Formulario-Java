package entities;

public class Usuario {
    private String name;
    private String email;
    private Integer age;
    private Double height;

    public Usuario(){
    }

    public Usuario(String name, String email, Integer age, Double height){
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
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

    public String toString(){
        return String.format("%s\n" +
                "%s\n" +
                "%d\n" +
                "%.2f", getName(), getEmail(), getAge(), getHeight());
    }
}
