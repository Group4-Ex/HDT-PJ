import java.util.*;
public class bai1 {
    public static int Sum(int[] a,int n){
        int tong = 0;
        for(int i = 0;i<n;i++){
            tong+=a[i];
        }
        return tong;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("nhap phan tu cua mang: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int x : a){
            System.out.print(x+ " ");
        }
        System.out.println("tong phan tu cua mang la: " + Sum(a,n));
    }
}
