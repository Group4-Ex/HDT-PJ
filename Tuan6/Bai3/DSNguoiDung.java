package NganHang;
import java.util.ArrayList;
import java.util.Scanner;

public class DSNguoiDung {
    Scanner sc = new Scanner(System.in);
    ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
    String soDT, mk, tenTK;

    public void dangKi() {
        boolean check;
        do {
            check = false;
            System.out.println("Nhap vao so dien thoai");
            soDT = sc.nextLine();
            if(!soDT.isEmpty())
            {
                if(dsTK.isEmpty())
                {
                    System.out.println("Da ghi nhan so tai khoan");
                    check =true;
                }else
                    for(TaiKhoan tk : dsTK)
                    {
                        if(!tk.getSoTK().equals(soDT)) {
                            System.out.println("Da ghi nhan so dien thoai");
                            check = true;
                            break;
                        }
                        else
                        {
                            System.out.println("Tai khoan da ton tai");
                            break;
                        }
                    }
            }else {
                System.out.println("So dien thoai khong duoc de trong");
            }
        }
        while (!check);

        if(check) {

            check = false;
            do {
                System.out.println("Nhap vao ten tai khoan");
                tenTK = sc.nextLine();
                if (!tenTK.isEmpty())
                    check = true;
                else
                    System.out.println("Ten tai khoan khong duoc de trong");
            } while (check == false);
            if (check) {
                check = false;
                do {
                    System.out.println("Nhap vao mat khau");
                    mk = sc.nextLine();
                    if (!mk.isEmpty()) {
                        System.out.println("Nhap lai mat khau");
                        String mk2 = sc.nextLine();
                        if(mk2.equals(mk))
                            check = true;
                        else
                            System.out.println("Mat khau khong khop");
                    }

                    else
                        System.out.println("Mat khau khong duoc de trong");
                } while (check == false);
                if (check) {
                    TaiKhoan tk = new TaiKhoan(soDT, tenTK, mk);
                    dsTK.add(tk);
                    System.out.println("Dang ki thanh cong");
                }
            }

        }

    }
    public void dangNhap(){
        System.out.println("Nhap vao so dien thoai");
        String sdt = sc.nextLine();
        if(!dsTK.isEmpty()) {
            for (TaiKhoan tk : dsTK) {
                if (tk.getSoTK().equals(sdt)) {
                    do {
                        System.out.println("Nhap vao mat khau");
                        String mk = sc.nextLine();
                        if (tk.getMk().equals(mk)) {
                            System.out.println("Dang nhap thanh cong");
                            menu(tk);
                            return;
                        } else
                            System.out.println("Sai mat khau");
                    }
                    while (true);
                }
            }
            System.out.println("Tai khoan khong ton tai");
        }
        else
            System.out.println("Chua co tai khoan nao");

    }
    public void luaChon(){
        int chon;
        do {
            System.out.println("1. Dang ki tai khoan");
            System.out.println("2. Dang nhap");
            System.out.println("0. Thoat");
            System.out.println("Nhap vao lua chon cua ban");
            chon = new Scanner(System.in).nextInt();
            switch (chon){
                case 1:
                    dangKi();
                    break;
                case 2:
                    dangNhap();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung dich vu");
                    break;
                default:
                    System.out.println("Nhap sai, moi nhap lai");
            }
        }while (chon != 0);
    }

    public void menu(TaiKhoan tk){
                int choice;
                do {
                    System.out.println("Moi dua ra lua chon");
                    System.out.println("1. Nap tien\n2. Rut tien\n3. Xem so du\n4. Doi mat khau\n0. Dang xuat");
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice){
                        case 1:
                            tk.nopTien();
                            break;
                        case 2:
                            tk.rutTien();
                            break;
                        case 3:
                            System.out.println(tk);
                            break;
                        case 4:
                            tk.doiMatKhau();
                            break;
                    }
                }while(choice != 0);
            }
        }

