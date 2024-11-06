package QuanLiNganHang;

import java.util.Random;
import java.util.Scanner;

public class CheckCls {
    public static void tapToContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter to continue");
        sc.nextLine();
    }

    static boolean kiemTraSoDienThoai(String sdt) {
        if (sdt.length() != 10) {
            return false;
        }

        for (char c : sdt.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return sdt.charAt(0) == '0';
    }


    static boolean kiemTraCCCD(String cccd) {
        if (cccd.length() != 12) {
            return false;
        }
        //chỉ chứa số
        for (char c : cccd.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean otpGiaoDich() {
        Random otp = new Random();
        Scanner sc = new Scanner(System.in);
        int count = 5;
        boolean check = false;
        do {
            int maOtpRutTien = 10000 + otp.nextInt(90000);
            System.out.println("Mã OTP xác thực là: " + maOtpRutTien);
            System.out.println("Nhập lại mã OTP xác nhận: ");
            int acptOTP = sc.nextInt();
            if (acptOTP == maOtpRutTien) {
                check = true;
                break;
            } else {
                count--;
                System.out.println("Bạn còn " + count + "/5 lần thử");
            }
        } while (count > 0);

        if (!check) {
            System.out.println("Xác thực OTP thất bại sau 5 lần thử.");
        }
        return check;
    }

    public static boolean checkMK(String mk) {
        boolean doDai = false;
        boolean soKT = false;
        boolean chuSo = false;
        char[] mangChuoi = mk.toCharArray();
        if (mangChuoi.length >= 6)
            doDai = true;
        for (char x : mangChuoi) {
            if (Character.isLetter(x))
                soKT = true;
            if (Character.isDigit(x))
                chuSo = true;
        }
        return doDai && soKT && chuSo;
    }

    public static boolean checkSign(String mkCheck) {
        boolean checkSign = false;
        System.out.println("Nhập vào mật khẩu xác thực");
        String mk = new Scanner(System.in).nextLine();
        if (mkCheck.equals(mk)) {
            boolean check = otpGiaoDich();
            if (check) {
                System.out.println("Xác thực thành công!");
                checkSign = true;
                tapToContinue();
            }

        }
        return checkSign;
    }

    public static boolean checkEmpty(String obj) {
        boolean check = false;
        if (obj.isEmpty()) {
            check = true;
            System.out.println("\"Không được để trống trường này!\"");
        }
        return check;
    }

    public static String creatPass() {
        Scanner sc = new Scanner(System.in);
        String mk = null;
        int count = 5;
        String mkNew;
        do {
            System.out.println("Mật khẩu yêu cầu ít nhất 6 kí tự\n(Chứa ít nhất 1 kí tự, 1 chữ số)");
            System.out.println("Nhập vào mật khẩu: ");
            mkNew = sc.nextLine();
            boolean check = checkEmpty(mkNew);
            if (!check) {
                if (CheckCls.checkMK(mkNew)) {
                    System.out.println("Nhập lại mật khẩu: ");
                    String mk2 = sc.nextLine();
                    if (mk2.equals(mkNew)) {
                        if (checkMK(mkNew)) {
                            mk = mkNew;
                            break;
                        }
                    } else {
                        {
                            System.out.println("Mật khẩu không khớp!");
                            count--;
                            if (count == 0) {
                                System.out.println("Oops! Thử lại sau nhé!");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Mật khẩu quá yếu!");
                    count--;
                    if (count == 0) {
                        System.out.println("Bạn thử hơi nhiều thì phải =))");
                        break;
                    }
                }
            }
        } while (count >= 0);
        return mk;
    }
}

