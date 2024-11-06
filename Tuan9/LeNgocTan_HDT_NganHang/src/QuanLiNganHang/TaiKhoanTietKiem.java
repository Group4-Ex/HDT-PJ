package QuanLiNganHang;


import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan {
    private int timeTK, kiHanTK;
    private final double laiSuat = 6.2;
    private double soDuTietKiem = 0;

    public TaiKhoanTietKiem(String soTaiKhoan, String tenChuTaiKhoan, String matKhau, int timeTK, int kiHanTK) {
        super(soTaiKhoan, tenChuTaiKhoan, matKhau);
        this.timeTK = timeTK;
        this.kiHanTK = kiHanTK;
    }

    public TaiKhoanTietKiem() {
        super();
    }

    public void napTien(TaiKhoanThanhToan tk) {
        do {
            double soTienNap = 0;
           if(tk.getSoDu() <= 0 )
           {
               System.out.println("Số dư không đủ để thực hiện giao dịch");
               break;
           }
            try {
                System.out.println("Nhập vào số tiền:(lớn hơn 0 và nhỏ hơn " + tk.getSoDu() + ")");
                soTienNap = sc.nextDouble();
                if (soTienNap >= 0 && soTienNap < tk.getSoDu()) {
                    this.soDuTietKiem += soTienNap;
                    tk.setSoDu(tk.getSoDu() - soTienNap);
                    System.out.println("Nạp tiền vào tài khoản tiết kiệm thành công");
                    System.out.println("Tài khoản chính -" + soTienNap);
                    break;
                } else
                    System.out.println("Số tiền phải lớn hơn 0!");
            } catch (Exception e) {
                System.out.println("Uppp, hệ thống có chút lỗi\nVui lòng nhập lại!: \n");
                sc.nextLine();
                break;
            }
        } while (true);
    }

    public void rutTien(TaiKhoanThanhToan tk) {
        System.out.println("Nếu rút tiền khỏi tài khoản tiết kiệm sẽ không còn được hưởng lãi suất hàng năm!");
        System.out.println("Bạn có muốn rút về tài khoản chính?:");
        System.out.println("1. Xác nhận\n2. Hủy");
        int chon;
        do {
            System.out.println("Đưa ra lựa chọn: ");
            chon = sc.nextInt();
            sc.nextLine();
            if (chon == 1) {
                boolean check = CheckCls.checkSign(this.getMatKhau());
                if (check) {
                    System.out.println("Nhập vào số tiền cần rút(lớn hơn 0 và nhỏ hơn " + this.soDuTietKiem);
                    double tienRut = sc.nextDouble();
                    if (tienRut > 0) {
                        boolean checkRT = CheckCls.otpGiaoDich();
                        if (checkRT) {
                            this.soDuTietKiem -= tienRut;
                            tk.setSoDu(tk.getSoDu() + tienRut);
                            System.out.println("Đã rút tiền về tài khoản chính thành công");
                            System.out.println("Tài khoản tiết kiệm -" + tienRut + "VND");
                        } else
                            System.out.println("Giao dịch không thành công");
                    }
                }
            }
        } while (chon != 2);
    }

    @Override
    public void doiMatKhau() {
        super.doiMatKhau();
    }

    public double tinhLaiKep() {
        double laiSuatDecimal = laiSuat / 100;

        int soLanGhepLai;
        double thoiGianNam;

        if (kiHanTK == 1) {
            soLanGhepLai = 12;
            thoiGianNam = (double) timeTK / 12;
        } else { // Tính theo năm
            soLanGhepLai = 1;
            thoiGianNam = timeTK;
        }

        double soTienSauLai = soDuTietKiem * Math.pow(1 + (laiSuatDecimal / soLanGhepLai), soLanGhepLai * thoiGianNam);
        return soTienSauLai;
    }

    public void hienThiThongTinLai() {
        System.out.println("\n=== THÔNG TIN LÃI SUẤT ===");
        System.out.println("Số dư hiện tại: " + String.format("%,.0f", soDuTietKiem) + " VND");
        System.out.println("Lãi suất năm: " + laiSuat + "%");

        if (kiHanTK == 1) {
            System.out.println("Kỳ hạn: " + timeTK + " tháng");
        } else {
            System.out.println("Kỳ hạn: " + timeTK + " năm");
        }

        double soTienSauLai = tinhLaiKep();
        double tienLai = soTienSauLai - soDuTietKiem;

        System.out.println("Tiền lãi dự kiến: " + String.format("%,.0f", tienLai) + " VND");
        System.out.println("Tổng số tiền sau kỳ hạn: " + String.format("%,.0f", soTienSauLai) + " VND");
        System.out.println("============================\n");
    }


    // Định dạng lại tài khoản tiết kiệm
    public TaiKhoanTietKiem formatTKTK(TaiKhoanThanhToan tk) {
        TaiKhoanTietKiem tktk = null;
        System.out.println("Bạn có muốn sử dụng thông tin người dùng hiện tại để sử dụng cho tài khoản tiết kiệm? (Có/Không)");
        String select = sc.nextLine();

        if (select.equalsIgnoreCase("Co")) {
            luaChonKiHan();
            tktk = new TaiKhoanTietKiem(tk.getSoTaiKhoan(), tk.getTenChuTaiKhoan(), tk.getMatKhau(), timeTK, kiHanTK);
        } else if (select.equalsIgnoreCase("Khong")) {
            String tenTK;
            do {
                System.out.println("Nhập vào tên/biệt danh cho tài khoản: ");
                tenTK = sc.nextLine();
            } while (tenTK.isEmpty());
            String matKhau = CheckCls.creatPass();
            if(matKhau != null)
            {
                luaChonKiHan();
                tktk = new TaiKhoanTietKiem(tk.getSoTaiKhoan(), tenTK, matKhau, timeTK, kiHanTK);
                System.out.println("Tạo tài khoản tiết kiệm thành công!\n");
            }else System.out.println("Tạo tài khoản không thành công!");
        } else
            System.out.println("Lựa chọn không hợp lệ!");
        return tktk;
    }


    public void luaChonKiHan() {
        Scanner sc = new Scanner(System.in);
        int time, kiHan, count = 5;
        do {
            System.out.println("1. Kỳ hạn theo tháng");
            System.out.println("2. Kỳ hạn theo năm");
            System.out.println("Mời đưa ra lựa chọn: ");
            kiHan = sc.nextInt();

            if (kiHan != 1 && kiHan != 2) {
                System.out.println("Vui lòng đưa ra lựa chọn chính xác");
            } else {
                if (kiHan == 1) {
                    System.out.println("Quý khách đã lựa chọn gửi tiết kiệm theo tháng");
                    do {
                        System.out.println("Mời nhập vào kỳ hạn tiết kiệm (6 tháng trở lên): ");
                        time = sc.nextInt();
                        if (time >= 6) {
                            System.out.println("Đã ghi nhận kỳ hạn tiết kiệm của bạn!");
                            System.out.println("Tài khoản tiết kiệm có kỳ hạn: " + time + " tháng\n");
                            this.timeTK = time;
                            this.kiHanTK = kiHan;
                            CheckCls.tapToContinue();
                            break;
                        } else {
                            System.out.println("Kỳ hạn tiết kiệm phải từ 6 tháng trở lên.");
                            count--;
                            if(count == 0)
                            {
                                System.out.println("Bug bug bug bug!");
                                CheckCls.tapToContinue();
                            }
                        }
                    } while (count >= 0);
                } else {
                    System.out.println("Quý khách đã lựa chọn gửi tiết kiệm theo năm!");
                    do {
                        System.out.println("Mời nhập vào kỳ hạn tiết kiệm (1 năm trở lên): ");
                        time = sc.nextInt();
                        if (time >= 1) {
                            System.out.println("Đã ghi nhận kỳ hạn tiết kiệm của bạn!");
                            System.out.println("Tài khoản tiết kiệm có kỳ hạn: " + time + " năm\n");
                            this.timeTK = time;
                            this.kiHanTK = kiHan;
                            CheckCls.tapToContinue();
                            break;
                        } else {
                            System.out.println("Kỳ hạn tiết kiệm phải từ 1 năm trở lên.");
                            count--;
                            System.out.println("Super buggggg!");
                            CheckCls.tapToContinue();
                        }
                    } while (count >= 0);
                }
                break;
            }
        } while (true);
    }

    //kiểm tra đăng nhập TKTK
    public void signTKTK(TaiKhoanThanhToan tk){
        System.out.println("Xin chào khách hàng: "+this.tenChuTaiKhoan.toUpperCase());
        System.out.println("Để đăng nhập vào tài khoản tiết kiệm quý khách vui lòng: ");
        int count = 5;
        do {
            boolean check = CheckCls.checkSign(this.getMatKhau());
            if(check)
            {
                featureTKTK(tk);
                break;
            }
            System.out.println("Xác thực thất bại");
            count--;
            System.out.println("Bạn còn "+count +" lần thử!");
        }while (count >= 0);
    }
    //Tính năng tài khoản tiết kiệm
    public void featureTKTK(TaiKhoanThanhToan tk) {

        int choice;
        System.out.println("Chào mừng khách hàng "+ this.tenChuTaiKhoan.toUpperCase()+" đến với không gian tiết kiệm!");
        do {
            System.out.println("Chủ Tài Khoản: "+this.tenChuTaiKhoan.toUpperCase());
            System.out.println("1. Xem thông tin tài khoản");
            System.out.println("2. Nạp tiền");
            System.out.println("3. Rút tiền");
            System.out.println("4. Thông tin lãi tiết kiệm");
            System.out.println("5. Đổi mật khẩu");
            System.out.println("0. Quay lại");
            System.out.println("Nhập vào lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(this);
                    CheckCls.tapToContinue();
                    break;
                case 2:
                    this.napTien(tk);
                    CheckCls.tapToContinue();
                    break;
                case 3:
                    this.rutTien(tk);
                    CheckCls.tapToContinue();
                    break;
                case 4:
                    hienThiThongTinLai();
                    CheckCls.tapToContinue();
                    break;
                case 5:
                    doiMatKhau();
                    return;
            }

        } while (choice != 0);
    }


    @Override
    public String toString() {
        return super.toString() + "|| Số dư tài khoản tiết kiệm: " + soDuTietKiem;
    }
}
