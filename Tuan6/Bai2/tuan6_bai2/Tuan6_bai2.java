/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tuan6_bai2;

import data.DanhSachSV;
import java.util.Scanner;

/**
 *
 * @author AMIN
 */
public class Tuan6_bai2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        DanhSachSV dsSV = new DanhSachSV();
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("---------------------MENU---------------------------");
            System.out.println(" 1. Thêm vào 1 sinh viên mới.");
            System.out.println(" 2. Sắp xếp sinh viên theo điểm trung bình giảm dần.");
            System.out.println(" 3. In danh sách sinh viên.");
            System.out.println(" 0. thoát.");
            System.out.println("----------------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    dsSV.addSV();
                    break;
                case 2: 
                    dsSV.sort();
                    break;
                case 3:
                    dsSV.printList();
            }
        } while (choice != 0);
    }
    
}
