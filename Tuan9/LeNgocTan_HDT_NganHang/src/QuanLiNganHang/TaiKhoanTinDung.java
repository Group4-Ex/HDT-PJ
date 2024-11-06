package QuanLiNganHang;

public class TaiKhoanTinDung extends TaiKhoan{
    private final int laiSuatTinDung = 3;
//    private double soDuTinDung = 5000000;
    private double soNoTinDung;

    public TaiKhoanTinDung() {
    }

    public TaiKhoanTinDung(String soTaiKhoan, String tenChuTaiKhoan, String matKhau, double soDu) {
        super(soTaiKhoan, tenChuTaiKhoan, matKhau, soDu);
    }

    public int getLaiSuatTinDung() {
        return laiSuatTinDung;
    }

    public double getSoNoTinDung() {
        return soNoTinDung;
    }

    public void setSoNoTinDung(double soNoTinDung) {
        this.soNoTinDung = soNoTinDung;
    }
    public void dangNhap(){
           boolean checkSign = CheckCls.checkSign(this.getMatKhau());
           if(checkSign){
               menuTKTD();
           }
           else
           {
               System.out.println("Đăng nhập không thành công!");
               System.out.println("Vui lòng thử lại!");
               CheckCls.tapToContinue();
           }
    }

    public TaiKhoanTinDung createAccTD(TaiKhoanThanhToan tktt){
        TaiKhoanTinDung tktd = new TaiKhoanTinDung(tktt.getSoTaiKhoan(), tktt.getTenChuTaiKhoan(), tktt.getMatKhau(), 5000000);
        return tktd;
    }

    public boolean chooseTD(){
        boolean check = false;
        int choice1, count =3;
        String choiceStr;
        try {
           do {
               System.out.println("Bạn có muôn sử dụng tài khoản tín dụng cho giao dịch? ");
               System.out.println("1. Có!\n2. Không!");
               choice1 = sc.nextInt();
               sc.nextLine();
               if(choice1 != 1 && choice1 != 2)
               {
                   count--;
                   if(count == 0)
                   {
                       System.out.println("Oops! có chút lỗi ở đây, vui lòng thử lại sau.");
                       break;
                   }
               }
               else if(choice1 == 2)
                   break;
                else
               {
                   System.out.println("Phí tín dụng trên giao dịch là "+this.laiSuatTinDung+"% số tiền giao dịch");
                   System.out.println("Bạn xác nhận có muốn sử dụng tài khoản tín dụng để tiếp tục thanh toán!");
                   System.out.println("Nhập vào \"Xác nhận\" (Không phân biệt hoa thường hay có dấu!)");
                   choiceStr = sc.nextLine();
                   if(choiceStr.equalsIgnoreCase("Xac nhan"));
                   {
                       System.out.println("Xác nhận sử dụng tài khoản tín dụng!");
                       check = true;
                       CheckCls.tapToContinue();
                       break;
                   }
               }

           }while (true);
        }catch (Exception e)
        {
            System.out.println("Oops! lỗi rồi fen ơi!");
            sc.nextLine();
        }
        return check;
    }

    public void thongTinTD(){
        System.out.println("Xin chào người dùng: "+this.tenChuTaiKhoan.toUpperCase());
        System.out.println("Tài khoản tín dụng liên kết với ****"+this.getSoTaiKhoan().substring(3));
        System.out.println("Hạn mức tiêu dùng: "+this.getSoDu());
    }
    public void ktraGhiNo(){
        System.out.println("Xin chào người dùng: "+this.tenChuTaiKhoan.toUpperCase());
        System.out.println("Nợ tín dụng hện tại: "+this.soNoTinDung+"đ");
    }

    public void menuTKTD(){
       int chon;
       do {
           System.out.println("1. Thông tin tài khoản tín dụng");
           System.out.println("2. Kiểm tra ghi nợ");
           System.out.println("0. Thoát");
           System.out.println("Nhập vào lựa chọn");
           chon = sc.nextInt();
           switch (chon)
           {
               case 1:
                   thongTinTD();
                   CheckCls.tapToContinue();
                   break;
               case 2:
                   ktraGhiNo();
                   CheckCls.tapToContinue();
                   break;
           }
       }while (chon != 0);
    }

    @Override
    public String toString() {
        return super.toString()+"\nSố dư tài khoản tín dụng: "+this.getSoDu();
    }
}
