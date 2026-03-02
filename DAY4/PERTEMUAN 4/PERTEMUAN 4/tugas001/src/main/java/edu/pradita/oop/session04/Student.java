package edu.pradita.oop.session04;

/**
 * Model Mahasiswa (MVC: Model)
 */
public class Student {

    private int nim;
    private String name;
    private String major;

    public Student() {
    }

    public Student(int nim, String name, String major) {
        this.nim = nim;
        this.name = name;
        this.major = major;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
