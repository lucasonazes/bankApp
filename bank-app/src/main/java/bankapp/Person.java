package bankapp;

public class Person {
    protected String name;
    protected int age;
    protected String rg;
    protected String cpf;

    public Person(String name, int age, String rg, String cpf) {
        this.name = name;
        this.age = age;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        if (id.length() == 11) {
            this.cpf = id;
        } else {
            this.rg = id;
        }
    }

    public void getPerson() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        if (this.rg != null) {
            System.out.println("RG: " + this.rg);
        }
        if (this.cpf != null) {
            System.out.println("CPF: " + this.cpf);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRg() {
        return this.rg;
    } 
}
