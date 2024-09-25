package tuan3XeMay;

import java.util.Scanner;

public class Vehicle {
	private String chuSoHuu; // Chủ sở hữu
    private double triGiaXe; // Trị giá xe
    private int dungTichXyLanh; // Dung tích xylanh
    // Constructor để khởi tạo đối tượng Vehicle
    public Vehicle(String chuSoHuu, double triGiaXe, int dungTichXyLanh) {
        this.chuSoHuu = chuSoHuu;
        this.triGiaXe = triGiaXe;
        this.dungTichXyLanh = dungTichXyLanh;
    }
    // Getter và Setter
    public String getChuSoHuu() {
        return chuSoHuu;
    }
    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }
    public double getTriGiaXe() {
        return triGiaXe;
    }
    public void setTriGiaXe(double triGiaXe) {
        this.triGiaXe = triGiaXe;
    }
    public int getDungTichXyLanh() {
        return dungTichXyLanh;
    }
    public void setDungTichXyLanh(int dungTichXyLanh) {
        this.dungTichXyLanh = dungTichXyLanh;
    }
    // Phương thức tính thuế trước bạ
    public double tinhThueTruocBa() {
        if (dungTichXyLanh < 100) {
            return triGiaXe * 0.01;
        } else if (dungTichXyLanh <= 200) {
            return triGiaXe * 0.03;
        } else {
            return triGiaXe * 0.05;
        }
    }
    // Phương thức xuất thông tin xe và thuế trước bạ
    @Override
    public String toString() {
        return String.format("%-20s %10.2f %10d %10.2f", chuSoHuu, triGiaXe, dungTichXyLanh, tinhThueTruocBa());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle xe1 = null, xe2 = null, xe3 = null;
        int luaChon;
        do {
            System.out.println("\nMenu lựa chọn:");
            System.out.println("1. Nhập thông tin và tạo các đối tượng xe1, xe2, xe3");
            System.out.println("2. Xuất bảng kê khai tiền thuế trước bạ của các xe");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ ký tự xuống dòng sau khi nhập số
            switch (luaChon) {
                case 1:
                    // Nhập thông tin cho xe1, xe2, xe3
                    System.out.println("Nhập thông tin xe 1:");
                    xe1 = nhapThongTinXe(scanner);
                    System.out.println("Nhập thông tin xe 2:");
                    xe2 = nhapThongTinXe(scanner);
                    System.out.println("Nhập thông tin xe 3:");
                    xe3 = nhapThongTinXe(scanner);
                    break;
                case 2:
                    // Xuất thông tin và thuế của các xe
                    System.out.println("\nThông tin xe 1:");
                    if (xe1 != null) {
                        System.out.println(xe1);
                    } else {
                        System.out.println("Xe 1 chưa được nhập thông tin.");
                    }
                    System.out.println("\nThông tin xe 2:");
                    if (xe2 != null) {
                        System.out.println(xe2);
                    } else {
                        System.out.println("Xe 2 chưa được nhập thông tin.");
                    }
                    System.out.println("\nThông tin xe 3:");
                    if (xe3 != null) {
                        System.out.println(xe3);
                    } else {
                        System.out.println("Xe 3 chưa được nhập thông tin.");
                    }
                    break;
                case 3:
                    // Thoát chương trình
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (luaChon != 3);
        scanner.close();
    }
    // Hàm nhập thông tin xe từ người dùng
    public static Vehicle nhapThongTinXe(Scanner scanner) {
        System.out.print("Nhập tên chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.print("Nhập trị giá xe (VND): ");
        double triGiaXe = scanner.nextDouble();
        System.out.print("Nhập dung tích xy lanh (cc): ");
        int dungTichXyLanh = scanner.nextInt();
        scanner.nextLine();  // Đọc bỏ ký tự xuống dòng
        return new Vehicle(chuSoHuu, triGiaXe, dungTichXyLanh);
    } 
}
