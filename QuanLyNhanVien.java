import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhanVien {
    private List<NhanVien> danhSachNhanVien;

    public QuanLyNhanVien() {
        this.danhSachNhanVien = new ArrayList<>();
    }

    // Menu cho Quản lý nhân viên
    public void menuQuanLyNhanVien() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChức năng Quản lý nhân viên:");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Xem thông tin nhân viên");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn: ");

            // Kiểm tra lựa chọn hợp lệ
            while (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // Xử lý việc người dùng nhập không phải số
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    themNhanVien();
                    break;
                case 2:
                    xemThongTinNhanVien();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    // Thêm nhân viên mới
    public void themNhanVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID nhân viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi nhân viên: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Xử lý dòng nhập sau khi nhập số
        System.out.print("Nhập phòng ban: ");
        String department = scanner.nextLine();

        NhanVien nhanVienMoi = new NhanVien(id, name, age, department);
        danhSachNhanVien.add(nhanVienMoi);
        System.out.println("Đã thêm nhân viên: " + nhanVienMoi);
    }

    // Xem thông tin tất cả nhân viên
    public void xemThongTinNhanVien() {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Không có nhân viên nào trong danh sách.");
        } else {
            System.out.println("\nDanh sách nhân viên:");
            for (NhanVien nhanVien : danhSachNhanVien) {
                System.out.println(nhanVien);
            }
        }
    }

    // Trả về danh sách nhân viên
    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }
}
