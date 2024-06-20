package bankapp.models;

public class Person {
    protected String name;
    protected String role;
    protected String cpf;

    public Person(String name, String role, String cpf) {
        this.name = name;
        this.role = role;
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public String getCpf() {
        return this.cpf;
    }
}
