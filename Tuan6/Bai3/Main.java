//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaiKhoan user1 = new TaiKhoan("12345", "LE NGOC TAN");
        System.out.println(user1);
        user1.guiTien();
        System.out.println(user1);
        user1.guiTien();
        System.out.println(user1);
        user1.rutTien();
        System.out.println(user1);

    }
}