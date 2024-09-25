package tuan5bai8CD;

import java.util.Scanner;

public class CD {
	private int maCD;
    private String tuaCD;
    private String caSy;
    private int soBaiHat;
    private double giaThanh;
    // Constructor
    public CD(int maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }
    // Getters and Setters
    public int getMaCD() {
        return maCD;
    }
    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }
    public String getTuaCD() {
        return tuaCD;
    }
    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }
    public String getCaSy() {
        return caSy;
    }
    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }
    public int getSoBaiHat() {
        return soBaiHat;
    }
    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat;
    }
    public double getGiaThanh() {
        return giaThanh;
    }
    public void setGiaThanh(double giaThanh) {
        this.giaThanh = giaThanh;
    }
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-20s %-15s %-20.2f", 
            maCD, tuaCD, caSy, soBaiHat, giaThanh);
    }
    public static String getHeader() {
        return String.format("%-10s %-20s %-20s %-15s %-20s", "Mã CD", "Tựa CD", "Ca Sỹ", "Số bài hát", "Giá thành");
    }
    
    public class TestCD {
    	public void nhapCD() {

    		try (Scanner scanner = new Scanner(System.in)) {
				CDList cdList = new CDList();
				while (true) {

					System.out.print("Chọn chức năng: ");
					int chucNang = scanner.nextInt();
					scanner.nextLine(); // Đọc dòng mới

					switch (chucNang) {
					case 1:

						System.out.println("\t Nhập 2 CD: ");
						for (int i = 1; i < 3; i++) {
							System.out.print("Nhập mã CD: " + (i) + ": ");
							int maCD = scanner.nextInt();
							scanner.nextLine();
							System.out.print("Nhập tựa CD: " + (i) + ": ");
							String tuaCD = scanner.nextLine();
							System.out.print("Nhập ca sỹ: " + (i) + ": ");
							String caSy = scanner.nextLine();
							System.out.print("Nhập số bài hát: ");
							int soBaiHat = scanner.nextInt();
							System.out.print("Nhập giá thành: ");
							double giaThanh = scanner.nextDouble();
							scanner.nextLine();
							CD cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
							if (cdList.themCD(cd)) {
								System.out.println("Thêm CD thành công!");
							} else {
								System.out.println("Thêm CD thất bại!");
							}
						}
						break;

					case 2:
						System.out.println("Số lượng CD hiện có: " + cdList.getSoLuongCD());
						break;
					case 3:
						System.out.println("Tổng giá thành của các CD: " + cdList.tongGiaThanh());
						break;
					case 4:
						cdList.sapXepTheoGiaThanh();
						System.out.println("Danh sách CD đã được sắp xếp giảm dần theo giá thành.");
						break;
					case 5:
						cdList.sapXepTheoGiaThanh();
						System.out.println("Danh sách CD đã được sắp xếp tăng dần theo tựa CD.");
						break;
					case 6:
						System.out.println("Danh sách CD:");
						System.out.println(CD.getHeader());
						cdList.xuatDanhSach();
						break;
					case 0:
						System.out.println("Thoát chương trình.");
						return;
					default:
						System.out.println("Chọn chức năng không hợp lệ.");
						break;
					}
				}
			}
    	}

    	public void menu() {
    		System.out.println("Menu:");
    		System.out.println("1. Thêm CD");
    		System.out.println("2. Tính số lượng CD");
    		System.out.println("3. Tính tổng giá thành");
    		System.out.println("4. Sắp xếp danh sách CD giảm dần theo giá thành");
    		System.out.println("5. Sắp xếp danh sách CD tăng dần theo tựa CD");
    		System.out.println("6. Xuất toàn bộ danh sách");
    		System.out.println("0. Thoát");
    	}

    	public void main(String[] args) {
    		menu();
    		nhapCD();
    	}
    }   
}