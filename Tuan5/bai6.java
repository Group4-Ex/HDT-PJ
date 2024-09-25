import java.util.*;
public class bai6 {
    public static void nhapDanhSach(ArrayList<Integer> arr, int n){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            int tmp = sc.nextInt();
            arr.add(tmp);
        }
    }
    public static void xuatDanhSach(ArrayList<Integer> arr){
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("nhap so luong phan tu trong danh sach:");
        int n = sc.nextInt();
        nhapDanhSach(arr,n);
        xuatDanhSach(arr);
        System.out.println("");
        System.out.println("nhap vi tri muon them vao:");
        int k = sc.nextInt();
        System.out.println("nhap gia tri muon them vao:");
        int l = sc.nextInt();
        arr.add(k,l);
        xuatDanhSach(arr);
        System.out.println("");
        System.out.println("nhap vi tri muon xoa:");
        int m = sc.nextInt();
        arr.remove(m);
        xuatDanhSach(arr);
    }
}
