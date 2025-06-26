import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordManager manager = new StudentRecordManager();

        while (true) {
            System.out.println("\n--- Student Record Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Mark");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Mark: ");
                    int mark = sc.nextInt();
                    manager.addStudent(new Student(id, name, mark));
                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    manager.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter New Mark: ");
                    int newMark = sc.nextInt();
                    manager.updateMark(updateId, newMark);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteStudent(deleteId);
                    break;

                case 6:
                    System.out.println(" Exiting...");
                    Myconnection.closeConnection();
                    return;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
