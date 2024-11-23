import java.time.LocalDate;
import java.util.Scanner;

public class QuanLyXuatNhapKho {
    private QuanLyHangHoa quanLyHangHoa;
    private Scanner scanner;

    public QuanLyXuatNhapKho(QuanLyHangHoa quanLyHangHoa) {
        this.quanLyHangHoa = quanLyHangHoa;
        this.scanner = new Scanner(System.in); // Tạo Scanner chỉ một lần
    }

    // Menu cho Quản lý xuất nhập kho
    public void menuQuanLyXuatNhapKho() {
        int choice;
        do {
            System.out.println("\nChức năng Quản lý xuất nhập kho:");
            System.out.println("1. Nhập kho");
            System.out.println("2. Xuất kho");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn: ");

            // Kiểm tra lựa chọn hợp lệ (sử dụng while để đảm bảo nhập đúng kiểu dữ liệu)
            while (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // Xử lý việc người dùng nhập không phải số
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    nhapKho();
                    break;
                case 2:
                    xuatKho();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    // Nhập kho: Thêm sản phẩm vào kho
    public void nhapKho() {
        System.out.print("Nhập ID sản phẩm cần nhập kho: ");
        String idSanPham = scanner.next();

        // Kiểm tra số lượng nhập vào
        int soLuongNhap = -1;
        while (soLuongNhap <= 0) {
            System.out.print("Nhập số lượng sản phẩm cần nhập: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Số lượng phải là số nguyên. Vui lòng nhập lại.");
                scanner.next(); // Xử lý việc người dùng nhập không phải số nguyên
            }
            soLuongNhap = scanner.nextInt();
            if (soLuongNhap <= 0) {
                System.out.println("Số lượng phải lớn hơn 0!");
            }
        }

        boolean sanPhamDaTonTai = false;
        for (SanPham item : quanLyHangHoa.getSanPhams()) {
            if (item.getIdSanPham().equals(idSanPham)) {
                // Cập nhật số lượng tồn kho và ngày nhập
                int soLuongMoi = item.getSoLuong() + soLuongNhap;
                item.setSoLuong(soLuongMoi);
                item.setNgayNhap(LocalDate.now());  // Cập nhật ngày nhập kho
                System.out.println("Đã nhập " + soLuongNhap + " sản phẩm vào kho. Tổng số lượng hiện tại: " + soLuongMoi);
                sanPhamDaTonTai = true;
                break;
            }
        }

        if (!sanPhamDaTonTai) {
            System.out.println("Sản phẩm với ID " + idSanPham + " không tồn tại trong kho!");
        }
    }

    // Xuất kho: Giảm số lượng sản phẩm trong kho
    public void xuatKho() {
        System.out.print("Nhập ID sản phẩm cần xuất kho: ");
        String idSanPham = scanner.next();

        // Kiểm tra số lượng xuất vào
        int soLuongXuat = -1;
        while (soLuongXuat <= 0) {
            System.out.print("Nhập số lượng sản phẩm cần xuất: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Số lượng phải là số nguyên. Vui lòng nhập lại.");
                scanner.next(); // Xử lý việc người dùng nhập không phải số nguyên
            }
            soLuongXuat = scanner.nextInt();
            if (soLuongXuat <= 0) {
                System.out.println("Số lượng phải lớn hơn 0!");
            }
        }

        boolean sanPhamDaTonTai = false;
        for (SanPham item : quanLyHangHoa.getSanPhams()) {
            if (item.getIdSanPham().equals(idSanPham)) {
                if (item.getSoLuong() >= soLuongXuat) {
                    // Cập nhật số lượng tồn kho và ngày xuất
                    int soLuongMoi = item.getSoLuong() - soLuongXuat;
                    item.setSoLuong(soLuongMoi);
                    item.setNgayXuat(LocalDate.now());  // Cập nhật ngày xuất kho
                    inPhieuBaoCaoXuatKho(item, soLuongXuat);
                } else {
                    System.out.println("Số lượng xuất không hợp lệ. Kho không đủ sản phẩm!");
                }
                sanPhamDaTonTai = true;
                break;
            }
        }

        if (!sanPhamDaTonTai) {
            System.out.println("Sản phẩm với ID " + idSanPham + " không tồn tại trong kho!");
        }
    }

    // In phiếu báo cáo xuất kho
    private void inPhieuBaoCaoXuatKho(SanPham sanPham, int soLuongXuat) {
        System.out.println("\n--- Phiếu báo cáo xuất kho ---");
        System.out.println("Mã sản phẩm: " + sanPham.getIdSanPham());
        System.out.println("Tên sản phẩm: " + sanPham.getTenSanPham());
        System.out.println("Số lượng xuất: " + soLuongXuat);
        System.out.println("Đơn vị: " + sanPham.getDonVi());
        System.out.println("Ngày xuất: " + sanPham.getNgayXuat());
        System.out.println("Tổng giá trị: " + soLuongXuat * sanPham.getGia());
        System.out.println("-----------------------------------");
    }
}
