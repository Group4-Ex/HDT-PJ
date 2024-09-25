import java.util.*;
public class bai2 {
    public static void daoNguoc(int[] a ,int n){
        int left = 0,right = n-1;
        while(left<=right){
            int tmp = a[left];
            a[left] = a[right];
            a[right]=tmp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap phan tu cua mang: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0;i<n;i++){
            a[i]= sc.nextInt();
        }
        daoNguoc(a,n);
        for(int x : a){
            System.out.print(x+ " ");
        }
    }
}
