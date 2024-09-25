package tuan1HCN_SV;

import java.util.Scanner;

public class SinhVien {
	private int maSV;
    private String hoTen;
    private float diemLT;
    private float diemTH;
    // Constructor mặc định
    public SinhVien() {
        this.maSV = 0;
        this.hoTen = "";
        this.diemLT = 0.0f;
        this.diemTH = 0.0f;
    }
    // Constructor đầy đủ
    public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }
    // Getter và Setter
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
    public float getDiemLT() {
        return diemLT;
    }
    public void setDiemLT(float diemLT) {
        this.diemLT = diemLT;
    }
    public float getDiemTH() {
        return diemTH;
    }
    public void setDiemTH(float diemTH) {
        this.diemTH = diemTH;
    }
    // Phương thức tính điểm trung bình
    public float tinhDiemTB() {
        return (diemLT + diemTH) / 2;
    }
    // Phương thức toString để mô tả đối tượng
    @Override
    public String toString() {
        return String.format("%-10d %-30s %5.2f %5.2f %5.2f", 
                maSV, hoTen, diemLT, diemTH, tinhDiemTB());
    }
    public class Main {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Tạo đối tượng sinh viên
            SinhVien sv1 = new SinhVien(1, "Nguyễn Văn A", 8.0f, 9.0f);
            SinhVien sv2 = new SinhVien(2, "Trần Thị B", 7.5f, 8.5f);
            SinhVien sv3 = new SinhVien(); // Tạo sinh viên bằng constructor mặc định
            // Nhập thông tin cho sv3
            System.out.print("Nhập mã sinh viên: ");
            sv3.setMaSV(scanner.nextInt());
            scanner.nextLine(); // Đọc dòng mới
            System.out.print("Nhập họ tên: ");
            sv3.setHoTen(scanner.nextLine());
            System.out.print("Nhập điểm LT: ");
            sv3.setDiemLT(scanner.nextFloat());
            System.out.print("Nhập điểm TH: ");
            sv3.setDiemTH(scanner.nextFloat());
            // In bảng danh sách sinh viên
            System.out.printf("%-10s %-30s %-10s %-10s %-10s\n", "MSSV", "Họ tên", "Điểm LT", "Điểm TH", "Điểm TB");
            System.out.println("---------------------------------------------------------------------");
            System.out.println(sv1);
            System.out.println(sv2);
            System.out.println(sv3);
            scanner.close();
        }
    }

}
