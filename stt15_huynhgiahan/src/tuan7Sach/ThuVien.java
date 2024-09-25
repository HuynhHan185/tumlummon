package tuan7Sach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

	class ThuVien {
	    private List<Sach> danhSachSach;

	    public ThuVien() {
	        danhSachSach = new ArrayList<>();
	    }

	    public void themSach(Sach sach) {
	        danhSachSach.add(sach);
	    }

	    public void inDanhSach() {
	        danhSachSach.forEach(System.out::println);
	    }

	    // Sắp xếp sách theo tác giả nếu trùng
	    public void sapXepTheoTacGia() {
	        Collections.sort(danhSachSach);
	    }

	    // Tính tổng thành tiền sách giáo khoa
	    public double tinhTongThanhTienSachGiaoKhoa() {
	    	return danhSachSach.stream()
	                .filter(sach -> sach instanceof SachGiaoKhoa)
	                .mapToDouble(Sach::tinhThanhTien)
	                .sum();
	        }

	        // Tính tổng thành tiền sách tham khảo
	        public double tinhTongThanhTienSachThamKhao() {
	            return danhSachSach.stream()
	                .filter(sach -> sach instanceof SachThamKhao)
	                .mapToDouble(Sach::tinhThanhTien)
	                .sum();
	        }

	        // Tính trung bình đơn giá sách tham khảo
	        public double tinhTrungBinhDonGiaSachThamKhao() {
	            return danhSachSach.stream()
	                .filter(sach -> sach instanceof SachThamKhao)
	                .mapToDouble(sach -> sach.donGia)
	                .average()
	                .orElse(0.0);
	        }
}
