package tuan6ChuyenXe;
import java.text.DecimalFormat;
import java.util.Objects;
public class ChuyenXe {

		protected String maChuyenXe;
	    protected String hoTen;
	    protected int soXe;
	    protected double doanhThu;

	    public ChuyenXe(String maChuyenXe, String hoTen, int soXe, double doanhThu) {
	        this.maChuyenXe = maChuyenXe;
	        this.hoTen = hoTen;
	        this.soXe = soXe;
	        this.doanhThu = doanhThu;
	    }

	    public ChuyenXe() {
	    }

	    public String getMaChuyenXe() {
	        return maChuyenXe;
	    }

	    public void setMaChuyenXe(String maChuyenXe) {
	        this.maChuyenXe = maChuyenXe;
	    }

	    public String getHoTen() {
	        return hoTen;
	    }

	    public void setHoTen(String hoTen) {
	        this.hoTen = hoTen;
	    }

	    public int getSoXe() {
	        return soXe;
	    }

	    public void setSoXe(int soXe) {
	        this.soXe = soXe;
	    }

	    public double getDoanhThu() {
	        return doanhThu;
	    }

	    public void setDoanhThu(double doanhThu) throws Exception {
	        if (doanhThu > 0)
	            this.doanhThu = doanhThu;
	        else
	            throw new Exception("Doanh thu phải lớn hơn không");
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(maChuyenXe);
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        ChuyenXe other = (ChuyenXe) obj;
	        return Objects.equals(maChuyenXe, other.maChuyenXe);
	    }

	    @Override
	    public String toString() {
	        DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	        String doanhThuString = df.format(doanhThu);
	        return String.format("%-15s | %-20s | %-10d | %-15s", maChuyenXe, hoTen, soXe, doanhThuString);
	    }

	    // NgoaiThanh
	    public static class NgoaiThanh extends ChuyenXe {
	        private String noiDen;
	        private int soNgayDiDuoc;

	        public NgoaiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
	            super(maChuyenXe, hoTen, soXe, doanhThu);
	            this.noiDen = noiDen;
	            this.soNgayDiDuoc = soNgayDiDuoc;
	        }

	        public String getNoiDen() {
	            return noiDen;
	        }

	        public void setNoiDen(String noiDen) {
	            this.noiDen = noiDen;
	        }

	        public int getSoNgayDiDuoc() {
	            return soNgayDiDuoc;
	        }

	        public void setSoNgayDiDuoc(int soNgayDiDuoc) {
	            this.soNgayDiDuoc = soNgayDiDuoc;
	        }

	        @Override
	        public String toString() {
	            DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	            String doanhThuString = df.format(doanhThu);
	            return String.format("%-15s | %-20s | %-10d | %-15s | %-20s | %-15d", maChuyenXe, hoTen, soXe, doanhThuString, noiDen, soNgayDiDuoc);
	        }
	    }

	    // NoiThanh
	    public static class NoiThanh extends ChuyenXe {
	    	private int soTuyen;
	        private double soKm;

	        public NoiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, int soTuyen, double soKm) {
	            super(maChuyenXe, hoTen, soXe, doanhThu);
	            this.soTuyen = soTuyen;
	            this.soKm = soKm;
	        }

	        public int getSoTuyen() {
	            return soTuyen;
	        }

	        public void setSoTuyen(int soTuyen) {
	            this.soTuyen = soTuyen;
	        }

	        public double getSoKm() {
	            return soKm;
	        }

	        public void setSoKm(double soKm) {
	            this.soKm = soKm;
	        }

	        @Override
	        public String toString() {
	            DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	            DecimalFormat kmFormat = new DecimalFormat("#,##0.00 km");
	            String doanhThuString = df.format(doanhThu);
	            String kmString = kmFormat.format(soKm);
	            return String.format("%-15s | %-20s | %-10d | %-15s | %-10d | %-15s", maChuyenXe, hoTen, soXe, doanhThuString, soTuyen, kmString);
	        }
	    }

	    // DanhSachChuyenXe (without ArrayList)
	    public static class DanhSachChuyenXe {
	        private ChuyenXe[] DS;
	        private int count;

	        public DanhSachChuyenXe(int maxSize) {
	            DS = new ChuyenXe[maxSize];
	            count = 0;
	        }

	        public void them(ChuyenXe xe) throws Exception {
	            if (timKiem(xe.getMaChuyenXe()) == null) {
	                if (count < DS.length) {
	                    DS[count] = xe;
	                    count++;
	                } else {
	                    throw new Exception("Danh sách chuyến xe đã đầy");
	                }
	            } else {
	                throw new Exception("Mã chuyến xe đã trùng");
	            }
	        }

	        public int timKiemViTri(String maCX) {
	            for (int i = 0; i < count; i++) {
	                if (DS[i].getMaChuyenXe().equalsIgnoreCase(maCX)) {
	                    return i;
	                }
	            }
	            return -1;
	        }

	        public ChuyenXe timKiem(String maCX) {
	            int viTri = timKiemViTri(maCX);
	            return (viTri != -1) ? DS[viTri] : null;
	        }

	        public void xoa(String maCX) {
	            int viTri = timKiemViTri(maCX);
	            if (viTri != -1) {
	                for (int i = viTri; i < count - 1; i++) {
	                    DS[i] = DS[i + 1];
	                }
	                count--;
	            }
	        }

	        public void sua(ChuyenXe xe) {
	            int viTri = timKiemViTri(xe.getMaChuyenXe());
	            if (viTri != -1) {
	                DS[viTri] = xe;
	            }
	        }

	        public double tinhTongDoanhThuNoiThanh() {
	            double tongDoanhThu = 0;
	            for (int i = 0; i < count; i++) {
	                if (DS[i] instanceof NoiThanh) {
	                    tongDoanhThu += DS[i].getDoanhThu();
	                }
	            }
	            return tongDoanhThu;
	        }
}
	    public double tinhTongDoanhThuNgoaiThanh() {
            double tongDoanhThu = 0;
            for (int i = 0; i < count; i++) {
                if (DS[i] instanceof NgoaiThanh) {
                    tongDoanhThu += DS[i].getDoanhThu();
                }
            }
            return tongDoanhThu;
        }

        public void hienThiDanhSach() {
            for (int i = 0; i < count; i++) {
                System.out.println(DS[i].toString());
            }
        }
    }

    // Main class
    public static class Main {
        public static void main(String[] args) {
            try {
                DanhSachChuyenXe dsChuyenXe = new DanhSachChuyenXe(10);

                NoiThanh xeNoiThanh1 = new NoiThanh("NT01", "Nguyen Van A", 123, 1000000, 5, 50);
                NgoaiThanh xeNgoaiThanh1 = new NgoaiThanh("XT01", "Tran Van B", 456, 3000000, "Da Nang", 3);

                dsChuyenXe.them(xeNoiThanh1);
                dsChuyenXe.them(xeNgoaiThanh1);

                System.out.println("Danh sách các chuyến xe:");
                dsChuyenXe.hienThiDanhSach();

                System.out.println("Tổng doanh thu xe nội thành: " + dsChuyenXe.tinhTongDoanhThuNoiThanh());
                System.out.println("Tổng doanh thu xe ngoại thành: " + dsChuyenXe.tinhTongDoanhThuNgoaiThanh());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
} 

