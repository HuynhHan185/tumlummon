package tuan5bai7SinhVien;

import java.util.Arrays;
import java.util.Scanner;

public class SinhVien {
	// Các thuộc tính
    private int maSV;
    private String hoTen;
    private String diaChi;
    private int soDienThoai;
    // Constructor mặc định
    public SinhVien() {
        this.maSV = 0;
        this.hoTen = "Không xác định";
        this.diaChi = "Không xác định";
        this.soDienThoai = 0;
    }
    // Constructor có tham số
    public SinhVien(int maSV, String hoTen, String diaChi, int soDienThoai) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }
    // Getter và Setter cho từng thuộc tính
    public int getMaSV() {
        return maSV;
    }
    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public int getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(int soDienThoai) {
        // Kiểm tra số điện thoại có đúng 7 chữ số không
        if (String.valueOf(soDienThoai).length() == 7) {
            this.soDienThoai = soDienThoai;
        } else {
            System.out.println("Số điện thoại không hợp lệ! Phải có 7 chữ số.");
            this.soDienThoai = 0;
        }
    }
    // Override phương thức toString
    @Override
    public String toString() {
        return String.format("Mã SV: %d, Họ tên: %s, Địa chỉ: %s, Số ĐT: %07d", maSV, hoTen, diaChi, soDienThoai);
    }
    
    public class QuanLySinhVien {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Nhập số lượng sinh viên
            System.out.print("Nhập số lượng sinh viên: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống
            // Tạo mảng sinh viên
            SinhVien[] danhSachSV = new SinhVien[n];
            // Nhập thông tin sinh viên
            for (int i = 0; i < n; i++) {
                System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 1));
                System.out.print("Mã sinh viên: ");
                int maSV = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống
                System.out.print("Họ tên: ");
                String hoTen = scanner.nextLine();
                System.out.print("Địa chỉ: ");
                String diaChi = scanner.nextLine();
                System.out.print("Số điện thoại (7 chữ số): ");
                int soDienThoai = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống
                // Khởi tạo đối tượng SinhVien và thêm vào mảng
                danhSachSV[i] = new SinhVien(maSV, hoTen, diaChi, soDienThoai);
            }
            // Sắp xếp danh sách sinh viên theo mã sinh viên
            Arrays.sort(danhSachSV, (sv1, sv2) -> Integer.compare(sv1.getMaSV(), sv2.getMaSV()));
            // Xuất danh sách sinh viên ra màn hình
            System.out.println("Danh sách sinh viên theo thứ tự tăng dần mã sinh viên:");
            for (SinhVien sv : danhSachSV) {
                System.out.println(sv);
            }
            // Đóng Scanner
            scanner.close();
        }
    }
}
