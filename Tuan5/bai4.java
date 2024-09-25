import java.util.*;
public class bai4 {
    public static void searchMax(int[] a,int n ){
        int max = 0,valueMax=0;
        for(int i = 0;i<n-1;i++){
            int count =0,value =0;
            for(int j = 0;j<n;j++){
                if(a[i]==a[j]){
                    count++;
                    value = a[i];
                }
            }
            if(count>=max){
                max = count;
                valueMax = a[i];
            }
        }
        System.out.println("gia tri"+ " " +valueMax +  " xuat hien nhieu nhat voi "+ max+ " lan");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap phan tu cua mang: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0;i<n;i++){
            a[i]= sc.nextInt();
        }
        searchMax(a,n);
    }
}
