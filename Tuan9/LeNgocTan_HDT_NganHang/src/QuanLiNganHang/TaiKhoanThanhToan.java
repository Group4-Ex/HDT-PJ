package QuanLiNganHang;


import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoan {
    private double phiChuyen = 1500;
    private final double phiThuongNien = 60000;
    private double hanMuc = 5000000;
    private boolean checkPT = false;

    public TaiKhoanThanhToan(String soTaiKhoan, String tenChuTaiKhoan, String matKhau) {
        super(soTaiKhoan, tenChuTaiKhoan, matKhau, 0);
    }

    public TaiKhoanThanhToan() {
    }

    public double getPhiThuongNien() {
        return phiThuongNien;
    }

    public double getHanMuc() {
        return hanMuc;
    }

    public double getPhiChuyen() {
        return phiChuyen;
    }

    public void setPhiChuyen(double phiChuyen) {
        this.phiChuyen = phiChuyen;
    }


    public void setHanMuc() {
        if (CheckCls.checkSign(this.getMatKhau())) {
            int count = 5;
            double hanmuc;
            do {
                System.out.println("Xin chào chủ tài khoản: " + this.tenChuTaiKhoan);
                System.out.println("Lựa chọn hạn mức giao dịch của bạn");
                System.out.println("(Lưu ý, hạn mức tối thiểu là 500.000đ và tối đa là 10.000.000đ");
                try {
                    hanmuc = sc.nextDouble();
                    if (hanmuc >= 500000 && hanmuc <= 10000000) {
                        this.hanMuc = hanmuc;
                        System.out.println("Đã đặt hạn mức thành công!");
                        System.out.println("Tài khoản giao dịch của bạn có hạn mức là: " + this.hanMuc);
                        CheckCls.tapToContinue();
                        break;
                    } else {
                        System.out.println("Vui lòng nhập vào hạn mức đúng quy định!");
                        CheckCls.tapToContinue();
                        count--;
                        if (count == 0) {
                            System.out.println("Hệ thống phát hiện hành vi bất thường!");
                            System.out.println("Vui lòng thử lại sau!");
                            CheckCls.tapToContinue();
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Oops! hệ thống có chút lỗi, thử lại sau nha!");
                    sc.nextLine();
                    CheckCls.tapToContinue();
                    break;
                }

            } while (true);
        }
    }

    @Override
    public void napTien() {
        super.napTien();
        System.out.println("Tài khoản chính: " + this.getSoDu());
        if (this.getSoDu() >= 60000 && !checkPT) {
            this.setSoDu(this.getSoDu() - 60000);
            System.out.println("Hệ thống đã tự động thanh toán phí thường niên ");
            System.out.println("Số dư -60.000đ");
            checkPT = true;
        }
    }

    public void rutTien() {
        super.rutTien();
    }

    public void chuyenTien(QuanLiNguoiDung qlnd, NguoiDung nguoiDung) {
        int count = 5, checkTK = 3;
        System.out.println("Nhập vào số điện thoại người dùng cần chuyển");
        String sdtCT = sc.nextLine();
        if(sdtCT.equals(this.getSoTaiKhoan()))
        {
            System.out.println("Không thể chuyển tiền cho chính mình!");
            return;
        }
        if (qlnd.timNguoiDung(sdtCT) == null)
            System.out.println("Người dùng không tồn tại trong hệ thống");
        else {
            if (qlnd.timNguoiDung(sdtCT) != null) {
                NguoiDung nguoiNhan = qlnd.timNguoiDung(sdtCT);
                if (nguoiNhan.dsTK.isEmpty()) {
                    System.out.println("Người nhận chưa có tài khoản");
                } else
                    do {
                        System.out.println("Nhập vào số tài khoản người nhận");
                        String stk = sc.nextLine();

                        if (nguoiNhan.dsTK.get(0).getSoTaiKhoan().equals(stk)) {
                            System.out.println("Người nhận: " + nguoiNhan.getTenNguoiDung().toUpperCase());
                            System.out.println("Xác nhận tài khoản người nhận?");
                            do {
                                System.out.println("1. Xác nhận\n2. Hủy");
                                int chon = sc.nextInt();
                                sc.nextLine();
                                if (chon != 1 && chon != 2) {
                                    System.out.println("Vui lòng đưa ra lựa chọn chính xác!");
                                    count--;
                                } else if (chon == 1) {
                                    noiDungCK(nguoiNhan, nguoiDung);
                                    return;
                                } else return;
                            } while (count > 0);
                        } else {
                            System.out.println("Tài khoản người dùng không tồn tại");
                            checkTK--;
                        }
                    } while (checkTK >= 0);
            } else {
                System.out.println("Số điện thoại không tồn tại trong hệ thống.");
            }
        }
    }

    public void noiDungCK(NguoiDung nguoiNhan, NguoiDung nguoiDung) {
        TaiKhoanTinDung tktd = nguoiDung.findTKTD();
        if (this.getSoDu() > this.getPhiChuyen()) {
            apctBanking(nguoiNhan, this.getSoDu(), this, nguoiDung);
        } else {
            if (tktd != null) {
                System.out.println("Số dư tài khoản thanh toán của bạn không đủ: " + this.getSoDu());
                System.out.println("Hệ thống sẽ sử dụng tài khoản tín dụng cho giao dịch này");
                boolean ktraUseTKTD = tktd.chooseTD();
                if (ktraUseTKTD) {
                    apctBanking(nguoiNhan, tktd.getSoDu(), tktd, nguoiDung);
                } else {
                    System.out.println("Bạn đã từ chối sử dụng tài khoản tín dụng!");
                    System.out.println("Giao dịch thất bại!");
                }
            } else {
                System.out.println("Số dư tài khoản không đủ và bạn chưa có tài khoản tín dụng!");
                System.out.println("Giao dịch thất bại!");
            }
        }
    }

    public void apctBanking(NguoiDung nguoiNhan, double gioiHanChuyen, TaiKhoan tkUse, NguoiDung nguoiDung) {
        int count = 5;
        boolean checkCreateTD = false;
        if (tkUse instanceof TaiKhoanTinDung) checkCreateTD = true;
        if (gioiHanChuyen > this.getPhiChuyen()) {
            do {
                System.out.println("Hạn mức tối đa cho mỗi lần giao dịch của bạn là: " + this.hanMuc + "đ");
                System.out.println("Số tiền chuyển phải lớn hơn 0 và nhỏ hơn: " + (gioiHanChuyen - this.getPhiChuyen()));
                System.out.println("Nhập vào số tiền chuyển!");
                double tienChuyen = sc.nextDouble();
                if (tienChuyen > gioiHanChuyen && !checkCreateTD) {
                    if (nguoiDung.findTKTD() == null) {
                        count--;
                        if (count == 0) {
                            System.out.println("Vui lòng thử lại sau, bạn có thể tham gia chương trình tín dụng để tiếp tục giao dịch!");
                            break;
                        }
                        System.out.println("Lưu ý! số tiền giao dịch phải đảm bảo yêu cầu.");
                        CheckCls.tapToContinue();
                    } else {
                        System.out.println("Tài khoản của bạn không đủ điều kiện giao dịch!");
                        TaiKhoanTinDung tktd = nguoiDung.findTKTD();
                        boolean ktraUseTKTD = tktd.chooseTD();
                        if (ktraUseTKTD) {
                            apctBanking(nguoiNhan, tktd.getSoDu(), tktd, nguoiDung);
                            break;
                        } else {
                            System.out.println("Thao tác với tài khoản tín dụng đã bị hủy!");
                            System.out.println("Giao dịch thất bại!");
                            break;
                        }
                    }
                    continue;
                }

                if (tienChuyen > 0 && tienChuyen <= this.hanMuc && tienChuyen <= gioiHanChuyen - 1500) {
                    System.out.println("Vui lòng kiểm tra kĩ nộ dung chuyển tiền");
                    System.out.println("Người nhận: " + nguoiNhan.getTenNguoiDung());
                    System.out.println("Số tiền chuyển: " + tienChuyen);
                    System.out.println("Xác nhận thực hiện giao dịch?");
                    System.out.println("1. Xác nhận\n2. Hủy");
                    int choice;
                    try {
                        choice = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Thao tác lỗi, vui lòng thực hiện lại!");
                        sc.nextLine();
                        return;
                    }
                    if (choice == 1) {
                        System.out.println("Nhập lại mật khẩu xác nhận");
                        String mkCheck = sc.nextLine();
                        if (this.getMatKhau().equals(mkCheck)) {
                            Boolean checkGD = CheckCls.otpGiaoDich();
                            if (checkGD) {
                                double phiGD = (tkUse instanceof TaiKhoanTinDung) ? (tienChuyen * ((TaiKhoanTinDung) tkUse).getLaiSuatTinDung() / 100.0) : this.phiChuyen;
                                System.out.println("Giao dịch thành công!");
                                System.out.println("Tài khoản -" + tienChuyen);
                                tkUse.setSoDu(tkUse.getSoDu() - tienChuyen);
                                nguoiNhan.findTKTT().setSoDu(nguoiNhan.findTKTT().getSoDu() + tienChuyen);

//                                 Nếu sử dụng tài khoản tín dụng, cập nhật số nợ
                                if (tkUse instanceof TaiKhoanTinDung) {
                                    ((TaiKhoanTinDung) tkUse).setSoNoTinDung(
                                            ((TaiKhoanTinDung) tkUse).getSoNoTinDung() + tienChuyen + phiGD
                                    );
                                }
                                break;
                            }
                        }
                    } else return;
                } else {
                    System.out.println("Số tiền không hợp lệ hoặc vượt quá hạn mức quy định!");
                    count--;
                    if (count == 0) {
                        System.out.println("Oops! hệ thống đang bận, thử lại sau nha!");
                        break;
                    }
                }
            } while (true);
        } else
            System.out.println("Số dư tài khoản không đủ để giao dịch");
    }

    public void doiMatKhau(TaiKhoanTinDung tktd) {
        super.doiMatKhau();
        if (tktd != null) {
            System.out.println("Lưu ý! tài khoản tín dụng sẽ được đồng bộ mật khẩu mới!");
            tktd.setMatKhau(this.getMatKhau());
        }

    }

    public boolean checkTienNhap(TaiKhoanTinDung tktd) {
        Scanner sc = new Scanner(System.in);
        int count = 5;
        boolean check = false;
        if (this.getSoDu() <= 0) {
            System.out.println("Tài khoản không đủ số dư để thực hiện giao dịch!");
        } else {
            do {
                System.out.println("Nhập vào số tiền giao dịch: ");
                double soTien = sc.nextDouble();
                if (soTien <= 0 && soTien > this.getSoDu() && soTien > tktd.getSoNoTinDung()) {
                    System.out.println("Số tiền giao dịch phải lớn hơn 0, nhỏ hơn: " + this.getSoDu());
                    System.out.println("Lưu ý! số tiền chuyển không được vượt quá tổng dư nợ: " + tktd.getSoNoTinDung());
                    count--;
                } else {
                    boolean checkPass = CheckCls.checkMK(this.getMatKhau());
                    if (checkPass) {
                        this.setSoDu(this.getSoDu() - soTien);
                        tktd.setSoNoTinDung(tktd.getSoNoTinDung() - soTien);
                        tktd.setSoDu(tktd.getSoDu() + soTien);
                        System.out.println("Vui lòng đợi giây lát!");
                        check = true;
                        break;
                    }
                }
            } while (count >= 0);
        }
        return check;
    }

    public void thanhToanNoTD(TaiKhoanTinDung tktd) {
        int chon;
        if (tktd.getSoNoTinDung() == 0) {
            System.out.println("Không có dư nợ cần thanh toán!");
        } else {
            int count = 5;
            do {
                System.out.println("Tài khoản: ***" + this.getSoTaiKhoan().substring(3));
                System.out.println("Tổng dư nợ thẻ tín dụng: " + tktd.getSoNoTinDung());
                System.out.println("1. Thanh toán một phần dư nợ" + "\t" + "2. Thanh toán toàn bộ dư nợ" + "\t" + "3. Hủy");
                try {
                    chon = sc.nextInt();
                    sc.nextLine();
                    if (chon == 3)
                        break;
                    if (chon != 1 & chon != 2) {
                        System.out.println("Vui lòng nhập vào lựa chọn chính xác");
                        count--;
                    } else if (chon == 1) {
                        boolean checkThanhToan = checkTienNhap(tktd);
                        if (checkThanhToan) {
                            System.out.println("Thanh toán thành công!");
                            System.out.println("Dư nợ còn lại là: " + tktd.getSoNoTinDung() + "đ");
                            if (tktd.getSoNoTinDung() == 0) {
                                System.out.println("Dư nợ đã được tất toán");
                                System.out.println("Cảm ơn quý khách đã sử dụng dịch vụ");
                                System.out.println("Hạn mức tín dụng được +1.000.000đ");
                                tktd.setSoDu(tktd.getSoDu() + 1000000);
                            }
                            break;
                        }
                    } else {
                        if (this.getSoDu() < tktd.getSoNoTinDung()) {
                            System.out.println("Số dư tài khoản không đủ để thực hiện giao dịch!");
                            count--;
                        } else {
                            int chon2;
                            System.out.println("Tổng dư nợ cần phải thực hiện thanh toán là: " + tktd.getSoNoTinDung());
                            System.out.println("Bạn có muốn thực hiện thanh toán?");
                            System.out.println("1. Có\n2. Không");
                            try {
                                chon2 = sc.nextInt();
                                if (chon2 == 1) {
                                    boolean checkPass = CheckCls.checkMK(this.getMatKhau());
                                    if (checkPass) {
                                        this.setSoDu(this.getSoDu() - tktd.getSoNoTinDung());
                                        tktd.setSoDu(tktd.getSoDu() + tktd.getSoNoTinDung());
                                        tktd.setSoNoTinDung(0);
                                        System.out.println("Thanh toán thành công!");
                                        System.out.println("Dư nợ đã được tất toán");
                                        System.out.println("Cảm ơn quý khách đã sử dụng dịch vụ");
                                        System.out.println("Hạn mức tín dụng được +1.000.000đ");
                                        tktd.setSoDu(tktd.getSoDu() + 1000000);
                                        break;
                                    }
                                } else {
                                    System.out.println("Hủy tác vụ đang thực thi");
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Oops! lỗi rồi fen");
                                sc.nextLine();
                                break;
                            }
                        }

                    }
                } catch (Exception e) {
                    System.out.println("Oops! lỗi rồi fen ơi!");
                    sc.nextLine();
                    CheckCls.tapToContinue();
                    break;
                }
            } while (count >= 0);
        }
    }

    public void featureTKTT(NguoiDung nguoiDung, QuanLiNguoiDung qlnd) {
        //Thanh toán phí thường niên cho tài khoản nhận tiền từ tài khoản khác
        if (this.getSoDu() >= 60000 && !checkPT) {
            this.setSoDu(this.getSoDu() - 60000);
            System.out.println("Hệ thống đã tự động thanh toán phí thường niên ");
            System.out.println("Số dư -60.000đ");
            CheckCls.tapToContinue();
            checkPT = true;
        }
        int chon;
        do {
            System.out.println("Tài khoản người dùng: " + this.tenChuTaiKhoan.toUpperCase());
            System.out.println("1. Kiểm tra tài khoản");
            System.out.println("2. Chuyển tiền");
            System.out.println("3. Rút tiền");
            System.out.println("4. Nạp tiền");
            System.out.println("5. Tài khoản tiết kiệm");
            System.out.println("6. Đổi mật khẩu");
            System.out.println("7. Dặt hạn mức tài khoản");
            System.out.println("8. Tài khoản tín dụng");
            System.out.println("9. Thanh toán nợ tín dụng");
            System.out.println("0. Đăng xuất");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    System.out.println(this);
                    CheckCls.tapToContinue();
                    break;
                case 2:
                    chuyenTien(qlnd, nguoiDung);
                    CheckCls.tapToContinue();
                    break;
                case 3:
                    rutTien();
                    CheckCls.tapToContinue();
                    break;
                case 4:
                    napTien();
                    CheckCls.tapToContinue();
                    break;
                case 5: {
                    if (nguoiDung.findTKTK() == null) {
                        System.out.println("Bạn chưa tạo có khoản tiết kiệm");
                        nguoiDung.taoTKTK(this);
                    } else {
                        nguoiDung.findTKTK().signTKTK(this);
                    }
                }
                return;
                case 6:
                    doiMatKhau(nguoiDung.findTKTD());
                    CheckCls.tapToContinue();
                    return;
                case 7:
                    setHanMuc();
                    break;
                case 8: {
                    if (nguoiDung.findTKTD() != null)
                        nguoiDung.findTKTD().dangNhap();
                    else {
                        nguoiDung.taoTKTD(this);
                        break;
                    }
                }
                break;
                case 9:
                    thanhToanNoTD(nguoiDung.findTKTD());
                    CheckCls.tapToContinue();
                    break;
            }
        } while (chon != 0);
    }


    @Override
    public String toString() {
        return super.toString() + " " + "|| Số tài khoản: ***" + this.getSoTaiKhoan().substring(3) + "\nSố dư hiện tại: " + this.getSoDu() + "VND";
    }
}
