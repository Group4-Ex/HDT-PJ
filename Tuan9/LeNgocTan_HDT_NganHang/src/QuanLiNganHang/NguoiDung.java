package QuanLiNganHang;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class NguoiDung {
    private boolean checkTaoTKTK = false;
    private String soDienThoai;
    private String tenNguoiDung;
    private Scanner sc;
    private String cccd;
    private Date ngaySinh;
    ArrayList<TaiKhoan> dsTK;

    public NguoiDung() {
        sc = new Scanner(System.in);
        dsTK = new ArrayList<>();
    }
    public NguoiDung(String soDienThoai, String tenNguoiDung, String cccd, Date ngaySinh) {
        this.soDienThoai = soDienThoai;
        this.tenNguoiDung = tenNguoiDung;
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        dsTK = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void luaChonDK() {
        if (dsTK.isEmpty()) {
            System.out.println("Bạn có muốn tạo tài khoản thanh toán dưới tên " + this.tenNguoiDung + " không?");
            System.out.println("Có/Không");
            String luachon = sc.nextLine();
            if (luachon.equalsIgnoreCase("co"))
                dangKi();
        }
    }

    public void taoTKTK(TaiKhoanThanhToan tk) {
        if (!checkTaoTKTK) {
            System.out.println("Bạn có muốn tạo tài khoản tiết kiệm từ nguồn tiền của tài khoản thanh toán? (Có/Không)");
            String luaChon = sc.nextLine();

            if (luaChon.equalsIgnoreCase("Co")) {
                TaiKhoanTietKiem tktk = new TaiKhoanTietKiem();
                tktk = tktk.formatTKTK(tk);
                if (tktk != null) {
                    dsTK.add(tktk);
                    checkTaoTKTK = true;
                } else {
                    System.out.println("Đã xảy ra lỗi khi tạo tài khoản tiết kiệm.");
                    CheckCls.tapToContinue();
                }
            } else {
                System.out.println("Tài khoản tiết kiệm mang đến nhiều trải nghiệm thú vị mới. Mong quý khách hàng sẽ sớm trở lại!");
                CheckCls.tapToContinue();
            }
        }
    }
    public void taoTKTD(TaiKhoanThanhToan tktt){
        int chon, count = 5;

        if(dsTK.size() < 3)
        {
            try
            {
                do {
                    System.out.println("Bạn chưa có tài khoản tín dụng");
                    System.out.println("Để tiếp tục, bạn có muốn thiết lập một tài khoản tín dụng");
                    System.out.println("1. Có\n2. Không");
                    chon = sc.nextInt();
                    sc.nextLine();
                    if(chon != 1 && chon != 2)
                    {
                        System.out.println("Vui lòng đưa ra lựa chọn chính xác");
                        count--;
                        continue;
                    }
                    if(chon == 2)
                        break;
                    if (chon == 1)
                    {
                        TaiKhoanTinDung tktd = new TaiKhoanTinDung();
                        dsTK.add(tktd.createAccTD(tktt));
                        System.out.println("Thông tin bảo mật của bạn sẽ được đồng bộ từ tài khoản thanh toán!");
                        CheckCls.tapToContinue();
                        System.out.println("Đợi giây lát...");
                        System.out.println("Thiết lập tài khoản tín dụng thành công!");
                        System.out.println("Vui lòng đăng nhập lại để sử dụng");
                        CheckCls.tapToContinue();
                        break;
                    }
                }while (count >= 0);
            }
            catch (Exception e)
            {
                System.out.println("Oops! Lỗi rồi fen ơi!");
                sc.nextLine();
            }

        }

    }


    public void apctDangKi(QuanLiNguoiDung qlnd) {
        if (dsTK.isEmpty()) {
            String chon;
            do {
                System.out.println("Các bước tiếp theo sẽ tiến hành khai thác thông tin của bạn để phục vụ cho việc thiết lập tài khoản");
                System.out.println("Bạn có muốn tiếp tục?");
                System.out.println("Có/Không");
                chon = sc.nextLine();
                if (chon.equalsIgnoreCase("co")) {
                    dangKi();
                    break;
                }
                if (chon.equalsIgnoreCase("Khong"))
                    break;
            } while (true);
        }
        else
        {
            TaiKhoanThanhToan tktt = null;
            for (TaiKhoan tk : dsTK)
                if (tk instanceof TaiKhoanThanhToan) {
                    tktt = (TaiKhoanThanhToan) tk;

            }
            tktt.featureTKTT(this, qlnd);
        }
    }

    public void dangKi() {
        String mk;
        int count = 5;
        do {
            System.out.println("Vui lòng xác thực lại số điện thoại");
            String sdt = sc.nextLine();
            if (this.soDienThoai.equals(sdt)) {
                System.out.println("Đã xác thực!");
                break;
            } else {
                System.out.println("Số điện thoại nhập vào không chính xác!");
                count--;
                if(count == 0)
                {
                    System.out.println("Bạn đã xác thực sai quá nhiều lần");
                    CheckCls.tapToContinue();
                    return;
                }
            }
        } while (true);
        System.out.println("Tên của bạn sẽ được tự động cập nhật từ thông tin đã cung cấp");
        CheckCls.tapToContinue();
        mk = CheckCls.creatPass();
        if(mk == null)
            return;
        do {
            System.out.println("Bạn có muốn tạo số tài khoản theo sở thích riêng?");
            System.out.println("(Số điện thoại sẽ được sử dụng làm số tài khoản mặc định nếu)");
            System.out.println("Có/Không");
            String chon = sc.nextLine();
            if (chon.equalsIgnoreCase("co")) {
                System.out.println("Nhập vào số tài khoản của bạn");
                String stk = sc.nextLine();
                if (checkFormat(stk)) {
                    dsTK.add(new TaiKhoanThanhToan(stk, this.tenNguoiDung, mk));
                    System.out.println("Tạo tài khoản thanh toán thành công!");
                    System.out.println("Mật khẩu tài khoản thanh toán sẽ được cập nhật cho tài khoản người dùng!");
                    System.out.println("Vui lòng đăng nhập lại!\n");
                    return;
                }
            } else if (chon.equalsIgnoreCase("khong")) {
                System.out.println("Số điện thoại của bạn được chọn làm tài khoản mặc định!");
                dsTK.add(new TaiKhoanThanhToan(soDienThoai, this.tenNguoiDung, mk));
                System.out.println("Mật khẩu tài khoản thanh toán sẽ được cập nhật cho tài khoản người dùng!");
                System.out.println("Vui lòng đăng nhập lại!\n");
                return;
            } else {
                System.out.println(":)) Nhập lại nào bạn trẻ!");
            }
        } while (true);
    }


    public void menuLuaChonND(TaiKhoanThanhToan tktt, QuanLiNguoiDung qlnd) {
        int select;
        do {
            System.out.println("1. Tài khoản thanh toán trực tuyến");
            System.out.println("2. Tài khoản tiết kiệm của tôi");
            System.out.println("3. Thông tin người dùng");
            System.out.println("0. Thoát");
            System.out.println("Nhập vào lựa chọn: ");
            select = sc.nextInt();
            sc.nextLine();
            switch (select) {
                case 1:
                    apctDangKi(qlnd);
                    return;
                case 2: {
                    if (!dsTK.isEmpty()) {
                        if(checkTaoTKTK)
                        {
                            for (TaiKhoan tk : dsTK) {
                                if (tk instanceof TaiKhoanTietKiem) {
                                    ((TaiKhoanTietKiem) tk).signTKTK(tktt);
                                    break;
                                }
                            }
                        }

                        else {
                            System.out.println("Bạn chưa có tài khoản tiết kiệm. Vui lòng tạo tài khoản tiết kiệm trước.");
                            taoTKTK((TaiKhoanThanhToan) dsTK.get(0));
                        }
                    } else {
                        System.out.println("Chưa có tài khoản thanh toán!\nVui lòng thực hiện tạo tài khoản thanh toán trước khi tham gia chương trình tiết kiệm!");

                    }
                }
                break;
                case 3:
                    System.out.println(this);
                    CheckCls.tapToContinue();
                    break;
            }
        } while (select != 0);
    }

    private boolean checkFormat(String number) {
        boolean check = true;
        char[] strstk = number.toCharArray();
        for (char x : strstk) {
            if (!Character.isDigit(x)) {
                check = false;
                return check;
            }
        }
        return check;
    }
    public TaiKhoanTinDung findTKTD(){
        TaiKhoanTinDung tktd = null;
        for(TaiKhoan tk : dsTK)
            if(tk instanceof TaiKhoanTinDung)
                tktd = (TaiKhoanTinDung) tk;
        return tktd;
    }
    public TaiKhoanThanhToan findTKTT(){
        TaiKhoanThanhToan tktt = null;
        for(TaiKhoan tk : dsTK)
            if(tk instanceof TaiKhoanThanhToan)
                tktt = (TaiKhoanThanhToan) tk;
        return tktt;
    }
    public TaiKhoanTietKiem findTKTK(){
        TaiKhoanTietKiem tktk = null;
        for(TaiKhoan tk : dsTK)
            if(tk instanceof TaiKhoanTietKiem)
                tktk = (TaiKhoanTietKiem) tk;
        return tktk;
    }


    @Override
    public String toString() {
        SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = spdf.format(this.ngaySinh);
        return "Tên người dùng: " +this.tenNguoiDung.toUpperCase() + "\nSố điện thoại: *****" + soDienThoai.substring(5)+ "|| Ngày sinh: "+ ngaySinhStr+"\nCCCD Số: *****"+ this.cccd.substring(5);
    }
}
