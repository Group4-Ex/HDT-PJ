import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bang cuu chuong tu 1 toi 10: ");
        for (int i = 1; i <= 10; i++)
            for (int j = 1; j <= 10; j++)
                System.out.println(i + "x" + j + "=" + i*j);
    }
}
