/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author AMIN
 */
public class SinhVien {
    
    private String maSv;
    private String ten;
    private String ngaySinh;
    private double dtb;
    
    public SinhVien(String maSv, String ten, String ngaySinh, double dtb) {
        this.maSv = maSv;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.dtb = dtb;
    }
    
    public String getMaSv() {
        return maSv;
    }
    
    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }
    
    public String getTen() {
        return ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public String getNgaySinh() {
        return ngaySinh;
    }
    
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public double getDtb() {
        return dtb;
    }
    
    public void setDtb(double dtb) {
        this.dtb = dtb;
    }
    
    public void print() {
        System.out.printf("|%14s|%-20s|%10s|%4.1f|\n", maSv, ten, ngaySinh, dtb);
    }
   
}
