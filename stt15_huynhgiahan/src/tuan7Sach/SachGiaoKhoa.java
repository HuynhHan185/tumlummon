package tuan7Sach;

import java.time.LocalDate;

class SachGiaoKhoa extends Sach {
    private boolean tinhTrang; // Tình trạng sách (mới/cũ)

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tacGia, boolean tinhTrang) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double tinhThanhTien() {
        return tinhTrang ? soLuong * donGia : soLuong * donGia * 0.5;
    }
}
