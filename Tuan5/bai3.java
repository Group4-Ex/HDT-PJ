import java.util.*;
public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap phan tu cua mang: ");
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        for(int i =0;i<n;i++){
            a[i]= sc.nextInt();
        }
        Arrays.sort(a);
        for(int x : a){
            System.out.print(x+ " ");
        }
    }
}
