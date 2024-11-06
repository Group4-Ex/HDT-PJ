/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ncm
 */
public class DanhSachSV {

    private ArrayList<SinhVien> listSV = new ArrayList();
    private Scanner sc = new Scanner(System.in);

    public void addSV() {
        String maSv, ten, ngaySinh;
        double dtb;

        System.out.print("Nhập mã sinh viên: ");
        maSv = sc.nextLine();
        System.out.print("Nhập họ và tên: ");
        ten = sc.nextLine();
        System.out.print("Nhập ngày sinh(dd/mm/yyyy): ");
        ngaySinh = sc.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        dtb = sc.nextDouble();
        listSV.add(new SinhVien(maSv, ten, ngaySinh, dtb));
        sc.nextLine();
        System.out.println("Thêm sinh viên thành công");
    }

    public void sort() {
        for (int i = 0; i < listSV.size() - 1; i++) {
            for (int j = i + 1; j < listSV.size(); j++) {
                if (listSV.get(i).getDtb() < listSV.get(j).getDtb()) {
                    SinhVien tmp = listSV.get(i);
                    listSV.set(i, listSV.get(j));
                    listSV.set(j, tmp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }
    
    public void printList() {
        for(SinhVien x : listSV) {
            x.print();
        }
    }
}
