import java.util.Scanner;

public class Bai3Tuan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap vao cac gia tri cua a b c");
        double a,b,c,x,x1,x2,dt;
        System.out.print("a = ");
        a = sc.nextDouble();
        System.out.print("b = ");
        b = sc.nextDouble();
        System.out.print("c = ");
        c = sc.nextDouble();
        if(a==0)
            if(b==0)
                if(c==0)
                    System.out.println("Phuong trinh vo so nghiem");
                else
                    System.out.println("Phuong trinh vo nghiem");
            else
            {
                x = -c/b;
                System.out.println("Phuong trinh co 1 nghiem la "+x);
            }
        else
        {
            dt = b*b - 4*a*c;
            if(dt==0)
            {
                x = -b/(2*a);
                System.out.println("Phuong trinh co 1 nghiem kep la "+x);
            }
            else if(dt>0)
            {
                x1 = (-b + Math.sqrt(dt))/(2*a);
                x2 = (-b - Math.sqrt(dt))/(2*a);
                System.out.println("Phuong trinh co hai nghiem la x1 = "+x1+"\n va x2 = "+x2);
            }
            else
                System.out.println("Phuong trinh vo nghiem");
        }
    }
}
