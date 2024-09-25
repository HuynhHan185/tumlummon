package tuan2NganHang;

import java.util.Scanner;

public class Account {
	 // Các thuộc tính
    private long soTaiKhoan;
    private String tenTaiKhoan;
    private double soTien;
    // Hằng số lãi suất
    private static final double LAI_SUAT = 0.035;
    // Constructor mặc định
    public Account() {
        this.soTaiKhoan = 0;
        this.tenTaiKhoan = "";
        this.soTien = 0.0;
    }
    // Constructor đầy đủ tham số
    public Account(long soTaiKhoan, String tenTaiKhoan, double soTien) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.soTien = soTien;
    }
    // Constructor với số tài khoản và tên tài khoản, khởi tạo số tiền mặc định 50
    public Account(long soTaiKhoan, String tenTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.soTien = 50.0;
    }
    // Getter và Setter cho từng thuộc tính
    public long getSoTaiKhoan() {
        return soTaiKhoan;
    }
    public void setSoTaiKhoan(long soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }
    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }
    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }
    public double getSoTien() {
        return soTien;
    }
    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
    // Phương thức toString để trả về chuỗi chứa thông tin tài khoản với định dạng tiền tệ
    @Override
    public String toString() {
    	String str="";
    	str+= String.format("%15d%30s%15.2f",getSoTaiKhoan(), getTenTaiKhoan(),getBlance());
    	return str;
    }
    private Object getBlance() {
		// TODO Auto-generated method stub
		return null;
	}
	// Phương thức nạp tiền
    public void napTien(double soTienNap) {
        if (soTienNap > 0) {
            soTien += soTienNap;
            System.out.println("Nạp thành công! Số dư hiện tại: " + soTien);
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0.");
        }
    }
    // Phương thức rút tiền, phí rút tiền là 10 đơn vị
    public void rutTien(double soTienRut) {
        double phiRutTien = 10.0;
        if (soTienRut + phiRutTien <= soTien && soTienRut > 0) {
            soTien -= (soTienRut + phiRutTien);
            System.out.println("Rút thành công! Số dư hiện tại: " + soTien);
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc vượt quá số dư.");
        }
    }
    // Phương thức đáo hạn
    public void daoHan() {
        soTien += soTien * LAI_SUAT;
        System.out.println("Đáo hạn thành công! Số dư hiện tại: " + soTien);
    }
    // Phương thức chuyển khoản
    public void chuyenKhoan(Account taiKhoanKhac, double soTienChuyen) {
        if (soTienChuyen > 0 && soTienChuyen <= soTien) {
            soTien -= soTienChuyen;
            taiKhoanKhac.napTien(soTienChuyen);
            System.out.println("Chuyển khoản thành công! Số dư hiện tại: " + soTien);
        } else {
            System.out.println("Số tiền chuyển không hợp lệ hoặc vượt quá số dư.");
        }
    }
public class Main {
   public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            // Tạo các tài khoản
            Account acc1 = new Account(123456789, "Nguyen Van A", 500);
            Account acc2 = new Account(987654321, "Tran Thi B", 1000);
            // Hiển thị thông tin tài khoản
            System.out.println(acc1);
            System.out.println(acc2);
            // Thực hiện nạp tiền
            System.out.print("Nhập số tiền nạp vào tài khoản 1: ");
            double tienNap = scanner.nextDouble();
            acc1.napTien(tienNap);
            System.out.println(acc1);
            // Thực hiện rút tiền
            System.out.print("Nhập số tiền rút từ tài khoản 1: ");
            double tienRut = scanner.nextDouble();
            acc1.rutTien(tienRut);
            System.out.println(acc1);
            // Thực hiện đáo hạn
            acc1.daoHan();
            System.out.println(acc1);
            // Thực hiện chuyển khoản từ acc2 sang acc1
            System.out.print("Nhập số tiền chuyển từ tài khoản 2 sang tài khoản 1: ");
            double tienChuyen = scanner.nextDouble();
            acc2.chuyenKhoan(acc1, tienChuyen);
            System.out.println(acc1);
            System.out.println(acc2);
            scanner.close();
        }
    }
}
