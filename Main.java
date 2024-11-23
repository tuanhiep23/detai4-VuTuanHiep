import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo các đối tượng, truyền tham số vào nếu cần
        QuanLyHangHoa quanLyHangHoa = new QuanLyHangHoa(); // Đổi thành QuanLyHangHoa
        QuanLyXuatNhapKho quanLyXuatNhapKho = new QuanLyXuatNhapKho(quanLyHangHoa); // Đổi thành quanLyHangHoa
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        QuanLyKiemKe kiemKe = new QuanLyKiemKe(quanLyHangHoa); // Đổi thành quanLyHangHoa


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHệ thống Quản lý Kho hàng");
            System.out.println("1. Quản lý hàng hóa");
            System.out.println("2. Quản lý xuất nhập kho");
            System.out.println("3. Quản lý nhân viên");
            System.out.println("4. Kiểm kê");
            System.out.println("5. Kiểm tra hàng hóa hết hạn");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // Đọc giá trị không hợp lệ và yêu cầu nhập lại
            }
            choice = scanner.nextInt();
            scanner.nextLine();  // Xóa buffer

            switch (choice) {
                case 1:
                    menuQuanLyHangHoa(quanLyHangHoa, scanner); // Truyền đối tượng quanLyHangHoa
                    break;
                case 2:
                    quanLyXuatNhapKho.menuQuanLyXuatNhapKho();
                    break;
                case 3:
                    quanLyNhanVien.menuQuanLyNhanVien();
                    break;
                case 4:
                    kiemKe.menuQuanLyKiemKe();
                    break;
                case 5:
                    quanLyHangHoa.kiemTraHetHan();  // Gọi kiểm tra hàng hóa hết hạn
                    break;
                case 0:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 0);
    }

    // Menu quản lý hàng hóa
    public static void menuQuanLyHangHoa(QuanLyHangHoa quanLyHangHoa, Scanner scanner) {
        int choice;

        do {
            System.out.println("\nQuản lý Hàng Hóa");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Tìm sản phẩm theo ID");
            System.out.println("3. Tìm sản phẩm theo tên");
            System.out.println("4. Tìm sản phẩm theo loại");
            System.out.println("5. Cập nhật thông tin sản phẩm");
            System.out.println("6. Xóa sản phẩm theo ID");
            System.out.println("7. Xóa sản phẩm theo tên");
            System.out.println("8. Hiển thị tất cả sản phẩm");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // Đọc giá trị không hợp lệ và yêu cầu nhập lại
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa buffer sau khi nhập số

            switch (choice) {
                case 1:
                    quanLyHangHoa.themSanPham();
                    break;
                case 2:
                    quanLyHangHoa.timSanPhamTheoId();
                    break;
                case 3:
                    quanLyHangHoa.timSanPhamTheoTen();
                    break;
                case 4:
                    quanLyHangHoa.timSanPhamTheoLoai();
                    break;
                case 5:
                    quanLyHangHoa.capNhatThongTinSanPham();
                    break;
                case 6:
                    quanLyHangHoa.xoaSanPhamTheoId();
                    break;
                case 7:
                    quanLyHangHoa.xoaSanPhamTheoTen();
                    break;
                case 8:
                    quanLyHangHoa.hienThiTatCaSanPham();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 0);
    }
}
