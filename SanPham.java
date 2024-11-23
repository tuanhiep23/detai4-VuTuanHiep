import java.io.Serializable;
import java.time.LocalDate;

class SanPham implements Serializable {
    private String idSanPham;
    private String tenSanPham;
    private int soLuong;
    private double gia;
    private String donVi;
    private String nhaCungCap;
    private String loai;
    private LocalDate ngayNhap;
    private LocalDate ngayXuat;

    public SanPham(String idSanPham, String tenSanPham, int soLuong, double gia, String donVi,
                   String nhaCungCap, String loai, LocalDate ngayNhap, LocalDate ngayXuat) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.gia = gia;
        this.donVi = donVi;
        this.nhaCungCap = nhaCungCap;
        this.loai = loai;
        this.ngayNhap = ngayNhap;
        setNgayXuat(ngayXuat);
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        if (ngayNhap != null) {
            this.ngayNhap = ngayNhap;
        } else {
            System.out.println("Ngày nhập không được để trống.");
        }
    }

    public LocalDate getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(LocalDate ngayXuat) {
        if (ngayXuat != null && ngayXuat.isAfter(ngayNhap)) {
            this.ngayXuat = ngayXuat;
        } else {
            System.out.println("Ngày xuất kho phải sau ngày nhập kho.");
        }
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "ID: '" + idSanPham + '\'' +
                ", Tên: '" + tenSanPham + '\'' +
                ", Số lượng: " + soLuong +
                ", Giá: " + gia +
                ", Ngày nhập: " + ngayNhap +
                ", Ngày xuất: " + ngayXuat +
                '}';
    }
}
