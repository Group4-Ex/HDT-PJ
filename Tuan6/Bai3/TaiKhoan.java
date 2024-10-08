
import java.util.Scanner;

public class TaiKhoan {
    private String soTK;
    private String tenTK;
    private long soDuTK = 0;

    public TaiKhoan(String soTK, String tenTK) {
        this.soTK = soTK;
        this.tenTK = tenTK;
    }
    public TaiKhoan(){};

    public void guiTien(){
        System.out.println("Nhap vao so tien can gui: ");
        long soTien = new Scanner(System.in).nextInt();
        soDuTK += soTien;
    }
    public void rutTien(){
        System.out.println("Nha so tien muon rut: ");
        int soTien = new Scanner(System.in).nextInt();
        if(soTien > soDuTK)
            System.out.println("So tien khong du de rut.");
        else {
            System.out.println("Rut thanh cong");
            soDuTK -= soTien;
        }
    }

    public String getTenTK() {
        return tenTK;
    }

    public double getSoDuTK() {
        return soDuTK;
    }

    @Override
    public String toString() {
        return "Chu tai Khoan: "+tenTK+" || So du hien tai: "+ soDuTK;
    }
}
