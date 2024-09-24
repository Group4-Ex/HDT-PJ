import java.util.Scanner;

public class Bai5Tuan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap vao ba canh cua tam giac");
        System.out.print("Canh a = ");
        float a = sc.nextFloat();
        System.out.print("Canh b = ");
        float b = sc.nextFloat();
        System.out.print("Canh c = ");
        float c = sc.nextFloat();
        if(a+b>c && a+c>b && b+c>a)
        {
            if(a == b && a == c && b == c )
                System.out.println("La tam giac va la tam giac deu ");
            if((a == b && b != c) || (b == a && a != c) || (c == a && a != b))
                System.out.println("La tam giac va la tam giac can ");
            if((a == b || a == c || b == c) && ((a*a + b*b == c*c ) || (a*a + c*c == b*b ) || (b*b + c*c == a*a )))
                System.out.println("La tam giac va la tam giac vuong can ");
            if((a*a + b*b == c*c ) || (a*a + c*c == b*b ) || (b*b + c*c == a*a))
                System.out.println("La tam giac va la tam giac vuong ");
            else
                System.out.println("La tam giac thuong ");
        }
        else
            System.out.println("Khong phai la tam giac");
    }
}
