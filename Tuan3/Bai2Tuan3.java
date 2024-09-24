import java.util.Scanner;

public class Bai2Tuan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap diem kiem tra");
        float dtb = sc.nextFloat();
        if(dtb >= 8 && dtb <= 10)
            System.out.println("Loai Gioi");
        else
        if(dtb >= 7)
            System.out.println("Loai Kha");
        else
        if(dtb >= 5)
            System.out.println("Loai Trung Binh");
        else
            System.out.println("Loai Yeu");
    }
}
