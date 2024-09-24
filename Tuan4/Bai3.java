import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        float gt = 1;
        for (int i = 1; i <= n; i++){
            gt *= i;
        }
        System.out.println("Giai thua cua " + n + " la: " + gt);
    }
}
