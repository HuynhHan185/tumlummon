package tuan4PhanSo;

public class KiemThuPhanSo {
	public static void main(String[] args) {
        // Tạo đối tượng phân số và thực hiện các phép toán
        PhanSo r1 = new PhanSo(1, 2);
        PhanSo r2 = new PhanSo(3, 4);
        System.out.println("Phân số 1: " + r1);
        System.out.println("Phân số 2: " + r2);
        System.out.println("Cộng: " + r1.cong(r2));
        System.out.println("Trừ: " + r1.tru(r2));
        System.out.println("Nhân: " + r1.nhan(r2));
        System.out.println("Chia: " + r1.chia(r2));
        System.out.println("Nghịch đảo của phân số 1: " + r1.reciprocal());
        System.out.println("Nghịch đảo của phân số 2: " + r2.reciprocal());
        System.out.println("Phân số 1 và phân số 2 có bằng nhau không? " + r1.equals(r2));
    }
}
