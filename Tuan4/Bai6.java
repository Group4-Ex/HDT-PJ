import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao day so can kiem tra doi xung");
        String s = sc.nextLine();
        int n = s.length();
        for ( int i = 0; i < n/2; i++){
            //so sanh == truoc thi gap ki tu dau tien = nhau --> return 0 out code
            if(s.charAt(i) != s.charAt(n - i - 1)){
                System.out.println("Day so khong doi xung");
                return;
            }
        }
        System.out.println("Day so doi xung");
    }
}
