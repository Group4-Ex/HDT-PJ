package QuanLiNganHang;

import java.util.Scanner;

public class TaiKhoan {
    private String soTaiKhoan;
    protected String tenChuTaiKhoan;
    private double soDu;
    private String matKhau;
    protected Scanner sc = new Scanner(System.in);

    // Constructor
    public TaiKhoan() {

    }

    public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, String matKhau, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.matKhau = matKhau;
    }

    public void rutTien() {
        int count = 5;
       if(this.soDu <= 0)
           System.out.println("Tài khoản của bạn không đủ để thực hiện giao dịch");
       else
           do {
               try {
                   System.out.println("Nhập vào số tiền muốn rút(số tiền phải lớn hơn 0 và bé hơn " + this.soDu);
                   double soTien = sc.nextDouble();
                   if (soTien > soDu) {
                       {
                           System.out.println("Số dư không đủ");
                           count--;
                       }
                   } else if (soTien <= 0)
                   {
                       System.out.println("Số tiền rút phải lớn hơn 0");
                       count--;
                   }
                   else {
                      boolean check = CheckCls.otpGiaoDich();
                      if(check)
                      {
                          System.out.println("Rút tiền thành công");
                          System.out.println("Tài khoản -"+soTien);
                          soDu -= soTien;
                          break;
                      }
                   }
               } catch (Exception e) {
                   System.out.println("Upps! Hệ thống bug rồi, nhập lại giùm: \n");
                   sc.nextLine();
               }
           } while (count >= 0);
    }

    public void napTien() {
        int count = 5;
        do {
            try {
                System.out.println("Nhập vào số tiền: ");
                double soTien = sc.nextDouble();
                if (soTien > 0) {
                    soDu += soTien;
                    System.out.println("Nạp tiền thành công");
                    break;
                } else {
                    System.out.println("Số tiền phải lớn hơn 0!");
                    count--;
                }
            } catch (Exception e) {
                {
                    System.out.println("Oops, hệ thống có chút lỗi\nVui lòng nhập lại!: \n");
                    sc.nextLine();
                }
            }
        } while (count >= 0);
    }
    public void doiMatKhau(){
        int count = 5;
       do {
           System.out.println("Nhập vào mật khẩu cũ");
           String mkTest = sc.nextLine();
           if(mkTest.equals(this.matKhau)){
               System.out.println("Nhập vào mật khẩu mới");
               String newPass = CheckCls.creatPass();
               if(newPass != null)
               {
                   System.out.println("Mật khẩu đã được cập nhật!");
                   this.matKhau = newPass;
                   System.out.println("Vui lòng đăng nhập lại!");
                   break;
               }
           }
           else
           {
               System.out.println("Mật khẩu không khớp");
               count--;
           }
       }while (count > 0);
    }

    // Getter và Setter
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getTenChuTaiKhoan() {
        return tenChuTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public void setTenChuTaiKhoan(String tenChuTaiKhoan) {
        this.tenChuTaiKhoan = tenChuTaiKhoan;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "Tên tài khoản: " + this.tenChuTaiKhoan.toUpperCase();
    }


}
