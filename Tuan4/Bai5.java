import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao 2 so a va b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a;
        int d = b;
        while ( a != b){
            if ( a > b)
                a -=b;
            else
                b -= a;
        }
        System.out.println("Uoc chung lon nhat cua a va b la: " + a);
        System.out.println("Boi chung nho nhat cua a va b la: " +c * d / a);
    }
}
