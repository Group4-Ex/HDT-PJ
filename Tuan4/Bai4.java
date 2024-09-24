import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        for (int i = 2; i <= n / 2; i++ )
            if(n % i == 0) {
                System.out.println(n + " khong phai la so nguyen to");
                return;
            }
        System.out.println(n + " la so nguyen to");
    }

}
