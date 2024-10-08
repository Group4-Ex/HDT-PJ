import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap vao so nguyen a: ");
        int a = sc.nextInt();
        System.out.println("Moi ban nhap vao so nguyen b: ");
        int b = sc.nextInt();
        System.out.println("Tong cua " + a + " va " + b + " la: " + (a + b));
        System.out.println("Hieu cua " + a + " va " + b + " la: " + (a - b));
        System.out.println("Tich cua " + a + " va " + b + " la: " + (a * b));
        System.out.println("Thuong cua " + a + " va " + b + " la: " +((float) a / b));
        System.out.println("Phan du cua " + a + " va " + b + " la: " + (a % b));
    }
}
