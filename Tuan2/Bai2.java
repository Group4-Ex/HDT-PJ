import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap ten: ");
        String name = sc.nextLine();
        System.out.println("Moi ban nhap tuoi: ");
        int age = sc.nextInt();
        System.out.println("Moi ban nhap vao chieu cao cua ban than");
        float height = sc.nextFloat();
        if(height / 100 < 2 && height / 100 > 0)
            height = height / 100;
        System.out.println("Moi ban nhap vao can nang cua ban than");
        float weight = sc.nextFloat();
        System.out.println("Xin chao " + name + ", ban " + age + " tuoi, chieu cao " + height + "m, can nang " + weight + "kg");
    }
}
