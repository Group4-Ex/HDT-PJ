/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7;

/**
 *
 * @author AMIN
 */
public class Student {

    private String idStudent;
    private String name;
    private double gpa;

    public Student(String IdStudent, String name, double gpa) {
        this.idStudent = IdStudent;
        this.name = name;
        this.gpa = gpa;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void showProfile() {
        System.out.printf("|%-10s|%-10s|%4.1f|", idStudent, name, gpa);
    }

}
