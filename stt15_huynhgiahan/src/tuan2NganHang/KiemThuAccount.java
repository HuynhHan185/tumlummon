package tuan2NganHang;

public class KiemThuAccount {
	public static void main(String[] args) {
        Account taiKhoan1 = new Account(123456, "Nguyen Van A");
        taiKhoan1.napTien(1000);
        taiKhoan1.rutTien(500);
        taiKhoan1.daoHan();
        System.out.println(taiKhoan1);
    }
}
