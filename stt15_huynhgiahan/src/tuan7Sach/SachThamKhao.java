package tuan7Sach;

import java.time.LocalDate;

class SachThamKhao extends Sach {
    private double thue; // Thuế

    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tacGia, double thue) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.thue = thue;
    }

    @Override
    public double tinhThanhTien() {
        return soLuong * donGia + thue;
    }
}
