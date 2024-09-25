/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author AMIN
 */
public class ListStudent {

    private ArrayList<Student> listStudent = new ArrayList();
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        String id;
        String name;
        double gpa;
        int pos; // lưu vị trí tìm thấy
        do {

            System.out.print("Nhập id: ");
            id = sc.nextLine();
            pos = searchStudentById(id);
            if (pos >= 0) {
                System.out.println("Mã sinh viên này đã tồn tại");
            }
        } while (pos > -1);
        System.out.print("Nhập tên: ");
        name = sc.nextLine();
        System.out.print("Nhập điểm gpa: ");
        gpa = sc.nextDouble();

        listStudent.add(new Student(id, name, gpa));
        System.out.println("Thêm sinh viên thành công");
        sc.nextLine();
    }

    public void removeStudent() {
        System.out.print("Nhập id cần xóa: ");
        String id = sc.nextLine();
        int pos = searchStudentById(id);
        if (pos == -1) {
            System.out.println("Sinh viên này không có trong danh sách");
        } else {
            listStudent.remove(pos);
            System.out.println("Xóa thành công");
        }
    }

    public void findStudent() {
        System.out.print("Nhập id cần tìm: ");
        String id = sc.nextLine();
        int pos; // lưu vị trí tìm đc
        pos = searchStudentById(id);
        if (pos > -1) {
            listStudent.get(pos).showProfile();
        }
        System.out.println();
    }

    public int searchStudentById(String id) {

        if (listStudent.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getIdStudent().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void sortWithGpa() {
        int n = listStudent.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listStudent.get(i).getGpa() > listStudent.get(j).getGpa()) {
                    Collections.swap(listStudent, i, j);
                }
            }
        }
        System.out.println("Sắp xếp thành công");
    }
    
    public void printListStudent() {
        System.out.println("-----------------------------------------------------\n");
        System.out.println("Đây là danh sách sinh viên: \n");
        System.out.println("|   Mã Sv  |  Tên Sv  | Gpa|"); 
        for(Student i : listStudent) {
            i.showProfile();
            System.out.println();
        }
    }
}
