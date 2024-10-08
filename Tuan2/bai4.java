import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap vao so tien muon gui");
        int money = sc.nextInt();
        System.out.println("Moi ban nhap vao so thang muon gui");
        int month = sc.nextInt();
        System.out.println("Moi ban nhap vao lai suat hang nam (don vi %)");
        float laiSuat = sc.nextFloat();
        // Tính tiền lãi kép A = P x (1 + r)^n
        float laiSuatThang = (laiSuat / 100) / 12;
        double tongTien = money * Math.pow(1 + laiSuatThang, month);
        System.out.println("So tien ban se nhan duoc sau %f " + month + " thang la: " + Math.round(tongTien) +" VND");
        System.out.println("Tong tien lai ban nhan duoc la: " + (tongTien - money) + " VND");


    }
}
