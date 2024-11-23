public class NhanVien {
    private String id;
    private String name;
    private int age;
    private String department;

    public NhanVien(String id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + name + ", Tuổi: " + age + ", Phòng ban: " + department;
    }
}
