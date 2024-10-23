package NganHang;

import java.util.Scanner;

public class TaiKhoan {
    Scanner sc = new Scanner(System.in);
    private String soTK;
    private String tenTK;
    private double soDu;
    private String mk;
    public TaiKhoan(String soTK, String tenTK, String mk) {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.mk = mk;
    }

    public String getSoTK() {
        return soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getMk() {
        return mk;
    }

    @Override
    public String toString() {
        return "Chu TK: "+tenTK +"|| SoTK :" + soTK+" || So du hien tai: "+soDu;
    }

    public void rutTien(){
        System.out.println("Nhap vao so tien muon rut");
        int soTien = sc.nextInt();
        sc.nextLine();
        if(soTien > soDu)
            System.out.println("Khong du tien de rut");
        else
        {
            System.out.println("Rut tien thanh cong");
            soDu -= soTien;
        }
    }
    public void nopTien(){
        System.out.println("Nhap vao so tien muon nop");
        int soTien = new Scanner(System.in).nextInt();
        soDu += soTien;
        System.out.println("Nop tien thanh cong");
    }

    public void doiMatKhau(){
        int count = 0;
        do {
            System.out.println("Nhap vao mat khau cu");
            String mkCu = sc.nextLine();
            if(this.mk.equals(mkCu)){
                System.out.println("Nhap vao mat khau moi");
                String mkMoi = sc.nextLine();
                this.mk = mkMoi;
                System.out.println("Doi mat khau thanh cong");
                break;
            }
            else
            {
                System.out.println("Sai mat khau");
                count++;
            }
        }while (count < 5);
    }
}
