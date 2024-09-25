package tuan1HCN_SV;

import java.util.Scanner;

public class HinhChuNhat {
	 private double chieuDai;
	 private double chieuRong;
	    // Phương thức thiết lập và lấy giá trị
	 public void setChieuDai(double chieuDai) {
	        this.chieuDai = chieuDai;
	}
	 public double getChieuDai() {
	        return chieuDai;
	}
	 public void setChieuRong(double chieuRong) {
	        this.chieuRong = chieuRong;
    }
	 public double getChieuRong() {
	        return chieuRong; 
     }
	    // Phương thức tính diện tích
	  public double tinhDienTich() {
	        return chieuDai * chieuRong;
	 }
	    // Phương thức tnh chu vi
	  public double tinhChuVi() {
	        return 2 * (chieuDai + chieuRong);
	  }
	    // Phương thức hiển thị thông tin
@Override
public String toString() {
	     return String.format("%-10s %-10s %-12s %-12s", "Chiều dài", "Chiều rộng", "Diện tích", "Chu vi");
	    }
public static void main(String[] args) {
	        try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Nhập chiều dài: ");
				double dai = scanner.nextDouble();
				System.out.print("Nhập chiều rộng: ");
				double rong = scanner.nextDouble();
				HinhChuNhat hinhChuNhat = new HinhChuNhat();
				hinhChuNhat.setChieuDai(dai);
				hinhChuNhat.setChieuRong(rong);
				System.out.println(hinhChuNhat);
			}
	    }
}
