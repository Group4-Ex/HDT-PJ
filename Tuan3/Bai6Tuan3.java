import javax.xml.transform.Source;
import java.util.Scanner;

public class Bai6Tuan3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Moi nhap vao hai so can tinh");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        System.out.println("Xin moi nhap lua chon phep tinh");
        System.out.println("1. Phep cong");
        System.out.println("2. Phep tru");
        System.out.println("3. Phep nhan");
        System.out.println("4. Phep chia");
        int pt = sc.nextInt();
        switch(pt)
        {
            case 1:
                System.out.println("Ket qua = "+(a+b));
                break;
            case 2 :
                System.out.println("Ket qua = "+(a-b));
                break;
            case 3 :
                System.out.println("Ket qua = "+(a*b));
                break;
            case 4 :
                System.out.println("Ket qua = "+(a/b));
                break;
            default:
                System.out.println("Lua chon khong hop le");
        }
    }
}
