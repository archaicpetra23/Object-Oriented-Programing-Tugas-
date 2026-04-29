package edu.pradita.oop.session01;

public class HelloStudent {
    private String name;

    // TODO: Constructor ini masih kosong, lengkapi!
    public HelloStudent(String name) {
        // Bug: Lupa assign name
        this.name = name;
    }

    // TODO: Method ini return-nya salah, perbaiki!
    public String greet() {
        // Bug: Return string salah
        return "Hello, " + name + "!"; // Harusnya "Hello, [name]!"
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // Mahasiswa harus ganti "YourName" dengan nama mereka sendiri
        HelloStudent student = new HelloStudent("Razan");
        System.out.println(student.greet());
    }
}
