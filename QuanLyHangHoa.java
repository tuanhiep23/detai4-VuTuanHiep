import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuanLyHangHoa {
    private ArrayList<SanPham> sanPhams;
    private Scanner scanner;

    public QuanLyHangHoa() {
        this.sanPhams = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Tìm sản phẩm theo ID
    public void timSanPhamTheoId() {
        System.out.print("Nhập ID bạn muốn tìm: ");
        String idSanPham = scanner.nextLine();

        boolean timThay = false;
        for (SanPham item : sanPhams) {
            if (item.getIdSanPham().equals(idSanPham)) {
                System.out.println("Thông tin sản phẩm là: " + item);
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm với ID: " + idSanPham);
        }
    }

    // Tìm sản phẩm theo tên
    public void timSanPhamTheoTen() {
        System.out.print("Nhập tên sản phẩm bạn muốn tìm: ");
        String tenSanPham = scanner.nextLine();

        boolean timThay = false;
        for (SanPham item : sanPhams) {
            if (item.getTenSanPham().equalsIgnoreCase(tenSanPham)) {
                System.out.println("Thông tin sản phẩm là: " + item);
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm với tên: " + tenSanPham);
        }
    }

    // Tìm sản phẩm theo loại
    public void timSanPhamTheoLoai() {
        System.out.print("Nhập loại bạn muốn tìm kiếm: ");
        String loai = scanner.nextLine();

        boolean timThay = false;
        for (SanPham item : sanPhams) {
            if (item.getLoai().equalsIgnoreCase(loai)) {
                System.out.println("Thông tin sản phẩm là: " + item);
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm trong loại này!");
        }
    }

    // Cập nhật thông tin sản phẩm
    public void capNhatThongTinSanPham() {
        System.out.print("Nhập ID sản phẩm bạn muốn sửa thông tin: ");
        String idSanPham = scanner.nextLine();

        boolean daCapNhat = false;

        for (SanPham item : sanPhams) {
            if (item.getIdSanPham().equals(idSanPham)) {
                System.out.println("Thông tin hiện tại của sản phẩm: " + item);

                System.out.print("Nhập tên sản phẩm mới: ");
                String tenSanPham = scanner.nextLine();

                int soLuong = -1;
                while (soLuong < 0) {
                    System.out.print("Nhập số lượng sản phẩm: ");
                    soLuong = scanner.nextInt();
                    if (soLuong < 0) {
                        System.out.println("Số lượng phải là số không âm!");
                    }
                }

                double gia = -1;
                while (gia <= 0) {
                    System.out.print("Nhập giá sản phẩm: ");
                    gia = scanner.nextDouble();
                    if (gia <= 0) {
                        System.out.println("Giá sản phẩm phải lớn hơn 0!");
                    }
                }
                scanner.nextLine(); // Xóa buffer sau nextDouble()

                System.out.print("Nhập đơn vị sản phẩm: ");
                String donVi = scanner.nextLine();
                System.out.print("Nhập nhà cung cấp sản phẩm: ");
                String nhaCungCap = scanner.nextLine();
                System.out.print("Nhập loại sản phẩm: ");
                String loai = scanner.nextLine();

                System.out.print("Nhập ngày xuất (yyyy-MM-dd): ");
                String ngayXuatStr = scanner.nextLine();
                LocalDate ngayXuat = null;
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    ngayXuat = LocalDate.parse(ngayXuatStr, formatter);
                } catch (Exception e) {
                    System.out.println("Ngày xuất không hợp lệ!");
                }

                item.setTenSanPham(tenSanPham);
                item.setSoLuong(soLuong);
                item.setGia(gia);
                item.setDonVi(donVi);
                item.setNhaCungCap(nhaCungCap);
                item.setLoai(loai);
                item.setNgayXuat(ngayXuat);

                System.out.println("Cập nhật thông tin sản phẩm thành công!");
                daCapNhat = true;
                break;
            }
        }
        if (!daCapNhat) {
            System.out.println("Không tìm thấy sản phẩm với ID đã cho!");
        }
    }

    // Xóa sản phẩm theo ID
    public void xoaSanPhamTheoId() {
        System.out.print("Nhập ID sản phẩm bạn muốn xóa: ");
        String idSanPham = scanner.nextLine();

        boolean daXoa = false;

        for (int i = 0; i < sanPhams.size(); i++) {
            if (sanPhams.get(i).getIdSanPham().equals(idSanPham)) {
                sanPhams.remove(i);
                System.out.println("Đã xóa sản phẩm với ID: " + idSanPham);
                daXoa = true;
                break;
            }
        }
        if (!daXoa) {
            System.out.println("Không tìm thấy sản phẩm với ID: " + idSanPham);
        }
    }

    // Xóa sản phẩm theo tên
    public void xoaSanPhamTheoTen() {
        System.out.print("Nhập tên sản phẩm bạn muốn xóa: ");
        String tenSanPham = scanner.nextLine();

        boolean daXoa = false;

        // Duyệt qua danh sách sanPhams để tìm và xóa các sản phẩm có tên trùng
        for (int i = 0; i < sanPhams.size(); i++) {
            if (sanPhams.get(i).getTenSanPham().equalsIgnoreCase(tenSanPham)) {
                sanPhams.remove(i);
                System.out.println("Đã xóa sản phẩm với tên: " + tenSanPham);
                daXoa = true;
                i--; // Điều chỉnh chỉ số sau khi xóa để không bỏ qua phần tử tiếp theo
            }
        }

        if (!daXoa) {
            System.out.println("Không tìm thấy sản phẩm với tên: " + tenSanPham);
        }
    }

    // Thêm sản phẩm mới vào kho
    public void themSanPham() {
        System.out.print("Nhập ID sản phẩm: ");
        String idSanPham = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = scanner.nextLine();

        int soLuong = -1;
        while (soLuong < 0) {
            System.out.print("Nhập số lượng sản phẩm: ");
            soLuong = scanner.nextInt();
            if (soLuong < 0) {
                System.out.println("Số lượng phải là số không âm!");
            }
        }

        double gia = -1;
        while (gia <= 0) {
            System.out.print("Nhập giá sản phẩm: ");
            gia = scanner.nextDouble();
            if (gia <= 0) {
                System.out.println("Giá sản phẩm phải lớn hơn 0!");
            }
        }
        scanner.nextLine(); // Xóa buffer sau nextDouble()

        System.out.print("Nhập đơn vị sản phẩm: ");
        String donVi = scanner.nextLine();
        System.out.print("Nhập nhà cung cấp sản phẩm: ");
        String nhaCungCap = scanner.nextLine();
        System.out.print("Nhập loại sản phẩm: ");
        String loai = scanner.nextLine();

        System.out.print("Nhập ngày xuất (yyyy-MM-dd): ");
        String ngayXuatStr = scanner.nextLine();
        LocalDate ngayXuat = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            ngayXuat = LocalDate.parse(ngayXuatStr, formatter);
        } catch (Exception e) {
            System.out.println("Ngày xuất không hợp lệ!");
        }

        SanPham sanPhamMoi = new SanPham(idSanPham, tenSanPham, soLuong, gia, donVi, nhaCungCap, loai, LocalDate.now(), ngayXuat);
        sanPhams.add(sanPhamMoi);

        System.out.println("Sản phẩm đã được thêm vào kho!");
    }

    // Hiển thị tất cả sản phẩm trong kho
    public void hienThiTatCaSanPham() {
        if (sanPhams.isEmpty()) {
            System.out.println("Kho không có sản phẩm nào!");
        } else {
            for (SanPham item : sanPhams) {
                System.out.println(item);
            }
        }
    }

    // Kiểm tra sản phẩm hết hạn hoặc gần hết hạn
    public void kiemTraHetHan() {
        LocalDate today = LocalDate.now();
        boolean daHienThi = false;

        for (SanPham item : sanPhams) {
            if (item.getNgayXuat().isBefore(today.plusMonths(1)) && item.getNgayXuat().isAfter(today)) {
                System.out.println("Sản phẩm gần hết hạn: " + item);
                daHienThi = true;
            }
        }
        if (!daHienThi) {
            System.out.println("Không có sản phẩm gần hết hạn.");
        }
    }

    // Kiểm tra tồn kho
    public void kiemTraTonKho() {
        System.out.print("Nhập tên sản phẩm bạn muốn kiểm tra tồn kho: ");
        String tenSanPham = scanner.nextLine();

        boolean timThay = false;
        for (SanPham item : sanPhams) {
            if (item.getTenSanPham().equalsIgnoreCase(tenSanPham)) {
                System.out.println("Sản phẩm tồn kho: " + item);
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm với tên: " + tenSanPham);
        }
    }

    public SanPham[] getSanPhams() {
        return new SanPham[0];
    }
}
