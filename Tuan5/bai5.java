import java.util.*;
public class bai5 {
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int tmp = sc.nextInt();
            arr.add(tmp);
        }
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
