import java.util.Scanner;

public class Bai1Tuan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap vao so can kiem tra");
        int n = sc.nextInt();
        if (n>0)
            System.out.println(+n+" la so duong");
        else if(n==0)
            System.out.println((+n+" la so 0"));
        else
            System.out.println(+n+" la so am");
    }
}
