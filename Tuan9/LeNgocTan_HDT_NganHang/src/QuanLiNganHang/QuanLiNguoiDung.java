package QuanLiNganHang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class QuanLiNguoiDung {
    HashMap<String, NguoiDung> dsNguoiDung;
    private Scanner sc;
    SimpleDateFormat spfm = new SimpleDateFormat();

    public NguoiDung timNguoiDung(String sdt) {
        return dsNguoiDung.get(sdt);
    }

    public QuanLiNguoiDung() {
        dsNguoiDung = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void dangKiTaiKhoan(){
        String sdt, tentk, cccd;
        Date ngaysinh;
        SimpleDateFormat spfm = new SimpleDateFormat("dd/MM/yyyy");

        do {
            System.out.println("Nhập vào số điện thoại của bạn: ");
            sdt = sc.nextLine();
            if(sdt.isEmpty()) {
                System.out.println("Không được để trống số điện thoại!");
                continue;
            }

            if(!CheckCls.kiemTraSoDienThoai(sdt)) {
                System.out.println("Số điện thoại không hợp lệ! Số điện thoại phải có 10 chữ số và bắt đầu bằng số 0");
                continue;
            }

            if(!dsNguoiDung.isEmpty() && dsNguoiDung.containsKey(sdt)) {
                System.out.println("Người dùng đã được đăng ký!");
                return;
            }

            System.out.println("Đã ghi nhận số điện thoại!");
            break;

        } while (true);

        do {
            System.out.println("Nhập vào tên người dùng");
            tentk = sc.nextLine();
            if(tentk.isEmpty())
                System.out.println("Tên tài khoản không được để trống");
            else
                break;
        } while (true);

        do {
            System.out.println("Nhập vào số CCCD (12 chữ số):");
            cccd = sc.nextLine();
            if (cccd.isEmpty()) {
                System.out.println("CCCD không được để trống!");
                continue;
            }

            if (!CheckCls.kiemTraCCCD(cccd)) {
                System.out.println("CCCD không hợp lệ! CCCD phải có đúng 12 chữ số");
                continue;
            }
            break;
        } while (true);

        try {
            System.out.println("Nhập vào ngày sinh (dd/MM/yyyy): ");
            String ngaySinhSTR = sc.nextLine();
            ngaysinh = spfm.parse(ngaySinhSTR);
        } catch (ParseException e) {
            System.out.println("Định dạng ngày không hợp lệ");
            Calendar date = new GregorianCalendar();
            date.set(1111, Calendar.JANUARY, 1);
            ngaysinh = date.getTime();
        }

        dsNguoiDung.put(sdt, new NguoiDung(sdt, tentk, cccd, ngaysinh));
        System.out.println("Đăng ký tài khoản thành công!");

    }

    public void dangNhap(QuanLiNguoiDung qlnd){
        System.out.println("Nhập số điện thoại: ");
        String sdtKT = sc.nextLine();
        if(dsNguoiDung.containsKey(sdtKT))
        {
            int count = 5;
               if(!(dsNguoiDung.get(sdtKT).dsTK.isEmpty())){
                   do {
                       System.out.println("Nhập vào mật khẩu");
                       System.out.println("\"Mật khẩu của bạn được đồng bộ từ tài khoản thanh toán!\"");
                       String mmkCheck =sc.nextLine();
                       if(dsNguoiDung.get(sdtKT).dsTK.get(0).getMatKhau().equals(mmkCheck))
                           break;
                       else
                       {
                           count--;
                           if(count <= 0)
                               return;
                           System.out.println("Nhập sai mật khẩu");
                           System.out.println("Bạn còn "+count +" lần thử!");

                       }
                   }while (count > 0);
               }
            boolean checkDN = CheckCls.otpGiaoDich();
            if(checkDN)
            {
                System.out.println("Chào mừng "+ dsNguoiDung.get(sdtKT).getTenNguoiDung().toUpperCase());
                NguoiDung nguoiDung = dsNguoiDung.get(sdtKT);
                TaiKhoanThanhToan tktt = new TaiKhoanThanhToan();
                for(TaiKhoan tk : nguoiDung.dsTK){
                    if(tk instanceof TaiKhoanThanhToan)
                    {
                        tktt = (TaiKhoanThanhToan) tk;
                    }
                }
                nguoiDung.menuLuaChonND(tktt, qlnd);
            }
        }
        else
            System.out.println("Người dùng không tồn tại!");
    }

    public void menuNguoiDung(){
        int choice;
        do {
            System.out.println("1. Đăng kí người dùng");
            System.out.println("2. Truy cập tài khoản người dùng");
            System.out.println("3. Thoát");
            try{
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch (Exception e)
            {
            System.out.println("Oops!, lỗi rồi fen ơi");
            sc.nextLine();
            break;
            }
            switch (choice)
            {
                case 1:
                    dangKiTaiKhoan();
                    break;
                case 2:
                    dangNhap(this);
                    break;
            }
        }while (choice != 3);
    }
}