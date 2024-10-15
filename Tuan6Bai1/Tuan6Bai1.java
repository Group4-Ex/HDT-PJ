import java.util.Scanner;
class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;
    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
    public double dienTich() {
        return chieuDai * chieuRong;
    }
    public double chuVi() {
        return 2 * (chieuDai + chieuRong);
    }
    public void hienThiKetQua() {
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
        System.out.println("Diện tích: " + dienTich());
        System.out.println("Chu vi: " + chuVi());
    }
}
public class Tuan6Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        double chieuDai = sc.nextDouble();
        System.out.print("Nhập chiều rộng: ");
        double chieuRong = sc.nextDouble();
        HinhChuNhat hcn = new HinhChuNhat(chieuDai, chieuRong);
        hcn.hienThiKetQua();
    }
}
