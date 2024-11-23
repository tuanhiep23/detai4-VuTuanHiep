import java.util.Scanner;

public class QuanLyKiemKe {
    private QuanLyHangHoa quanLyHangHoa;
    private Scanner scanner;

    public QuanLyKiemKe(QuanLyHangHoa quanLyHangHoa) {
        this.quanLyHangHoa = quanLyHangHoa;
        this.scanner = new Scanner(System.in);
    }

    public void menuQuanLyKiemKe() {
        int choice;
        do {
            System.out.println("\nChức năng Quản lý kiểm kê:");
            System.out.println("1. Kiểm kê định kỳ");
            System.out.println("2. Kiểm kê đột xuất");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    kiemKeDinhKy();
                    break;
                case 2:
                    kiemKeDotXuat();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public void kiemKeDinhKy() {
        System.out.println("\n--- Kiểm kê định kỳ ---");
        for (SanPham item : quanLyHangHoa.getSanPhams()) {
            System.out.println("Sản phẩm: " + item.getTenSanPham());
            int soLuongThucTe = nhapSoLuongThucTe(item);
            soSanhSoLuong(item, soLuongThucTe);
        }
    }

    public void kiemKeDotXuat() {
        System.out.println("\n--- Kiểm kê đột xuất ---");
        System.out.print("Nhập ID sản phẩm cần kiểm kê: ");
        String idSanPham = scanner.next();

        SanPham sanPham = timSanPhamTheoId(idSanPham);
        if (sanPham != null) {
            int soLuongThucTe = nhapSoLuongThucTe(sanPham);
            soSanhSoLuong(sanPham, soLuongThucTe);
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID: " + idSanPham);
        }
    }

    private int nhapSoLuongThucTe(SanPham sanPham) {
        int soLuongThucTe = -1;
        while (soLuongThucTe < 0) {
            System.out.print("Nhập số lượng thực tế của sản phẩm " + sanPham.getTenSanPham() + ": ");
            soLuongThucTe = scanner.nextInt();
            if (soLuongThucTe < 0) {
                System.out.println("Số lượng thực tế không thể là số âm!");
            }
        }
        return soLuongThucTe;
    }

    private void soSanhSoLuong(SanPham sanPham, int soLuongThucTe) {
        int soLuongTrenHeThong = sanPham.getSoLuong();
        if (soLuongThucTe != soLuongTrenHeThong) {
            System.out.println("Báo cáo chênh lệch:");
            System.out.println("Mã sản phẩm: " + sanPham.getIdSanPham());
            System.out.println("Tên sản phẩm: " + sanPham.getTenSanPham());
            System.out.println("Số lượng trên hệ thống: " + soLuongTrenHeThong);
            System.out.println("Số lượng thực tế: " + soLuongThucTe);
            System.out.println("Chênh lệch: " + (soLuongThucTe - soLuongTrenHeThong));
        } else {
            System.out.println("Số lượng khớp: Không có chênh lệch.");
        }
    }

    private SanPham timSanPhamTheoId(String idSanPham) {
        for (SanPham item : quanLyHangHoa.getSanPhams()) {
            if (item.getIdSanPham().equals(idSanPham)) {
                return item;
            }
        }
        return null;
    }
}
