/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai7;

import java.util.Scanner;

/**
 *
 * @author AMIN
 */
public class Tuan5_bai7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ListStudent lstd = new ListStudent();

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n-------------------------Menu------------------------");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Tìm sinh viên");
            System.out.println("4. Sắp xếp danh sách sinh viên theo điểm tăng dần");
            System.out.println("0. Thoát");
            System.out.println("-----------------------------------------------------\n");
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    lstd.addStudent();
                    break;
                case 2:
                    lstd.removeStudent();
                    break;
                case 3:
                    lstd.findStudent();
                    break;
                case 4:
                    lstd.sortWithGpa();
                    break;
                case 5:
                    lstd.printListStudent();
            }
        } while (choice != 0);

    }

}
