import java.sql.*;

public class StudentRecordManager {
    public void addStudent(Student student) {
        String sql = "INSERT INTO studentrecord (id, Name1, Mark) VALUES (?, ?, ?)";
        try (Connection conn = Myconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, student.getID());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getMark());
            ps.executeUpdate();
            System.out.println("✅ Student added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAllStudents() {
        String sql = "SELECT * FROM studentrecord";
        try (Connection conn = Myconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("Name1") +
                        ", Mark: " + rs.getInt("Mark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student searchStudent(int id) {
        String sql = "SELECT * FROM studentrecord WHERE id = ?";
        try (Connection conn = Myconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("✅ Found: ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("Name1") +
                        ", Mark: " + rs.getInt("Mark"));
                return new Student(rs.getInt("id"), rs.getString("Name1"), rs.getInt("Mark"));
            } else {
                System.out.println(" Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateMark(int id, int newMark) {
        String sql = "UPDATE studentrecord SET Mark = ? WHERE id = ?";
        try (Connection conn = Myconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newMark);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? " Mark updated." : " Student not found.");
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM studentrecord WHERE id = ?";
        try (Connection conn = Myconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student deleted." : " Student not found.");
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
