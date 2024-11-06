package QuanLiNganHang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        QuanLiNguoiDung qlnd = new QuanLiNguoiDung();

        SimpleDateFormat spfm = new SimpleDateFormat("dd/MM/yyyy");
        String ngaysinh = "12/12/2000";
        Date ngaySinh = spfm.parse(ngaysinh);

        NguoiDung nd1 = new NguoiDung("0332233801", "Tan","111111111111",ngaySinh);
        NguoiDung nd2 = new NguoiDung("0332233802", "Tan","111111111111",ngaySinh);
        qlnd.dsNguoiDung.put("0332233801",nd1);
        qlnd.dsNguoiDung.put("0332233802",nd2);
        TaiKhoanThanhToan tk1 = new TaiKhoanThanhToan("0332233801","Tan","tan123");
        TaiKhoanThanhToan tk2 = new TaiKhoanThanhToan("0332233802","Tan","tan123");
        nd1.dsTK.add(tk1);
        nd2.dsTK.add(tk2);
        qlnd.menuNguoiDung();
    }
}
