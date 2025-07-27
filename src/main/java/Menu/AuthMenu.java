package Menu;

import Service.AdminService;
import Service.StudentService;
import Service.TeacherService;
import model.Admin;
import model.Student;
import model.Teacher;

import java.util.Scanner;

public class AuthMenu {
    AdminMenu adminMenu = new AdminMenu();
    private StudentService studentService;
    private TeacherService teacerService;
    private AdminService adminService;

    public AuthMenu() {
        this.studentService = new StudentService();
        this.teacerService = new TeacherService();
        this.adminService = new AdminService();
    }
    Scanner scanner = new Scanner(System.in);
    public void authMenu(){
        while (true){
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Teacher");
        System.out.println("3. Login as Admin");
        System.out.println("4. Exit");

        System.out.println("Choice: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Enter your full name: ");
                String logName = scanner.nextLine();
                System.out.println("Enter your email: ");
                String logEmail = scanner.nextLine();
                Student loggedIn = studentService.login(logName, logEmail);
                if (loggedIn != null) {
                    System.out.println("Logged in successfully");
                    StudentMenu studentMenu = new StudentMenu();
                    studentMenu.studentMenu(loggedIn);
                } else {
                    System.out.println("Login failed");
                }
                break;
            case "2":
                System.out.println("Enter your full name: ");
                String logName1 = scanner.nextLine();
                System.out.println("Enter your email: ");
                String logEmail1 = scanner.nextLine();
                Teacher loggedIn1 = teacerService.login(logName1, logEmail1);
                if (loggedIn1 != null) {
                    System.out.println("Logged in successfully");
                    TeacherMenu  teacherMenu = new TeacherMenu();
                    teacherMenu.teacherMenu(loggedIn1);
                } else {
                    System.out.println("Login failed");
                }
                break;
            case "3":
                System.out.println("Enter your name: ");
                String logName2 = scanner.nextLine();
                System.out.println("Enter your password: ");
                String logPassword = scanner.nextLine();
                Admin loggedIn2 = adminService.login(logName2, logPassword);
                if (loggedIn2 != null) {
                    System.out.println("Logged in successfully");
                    adminMenu.adminMenu();
                } else {
                    System.out.println("Login failed");
                }
                break;
            case "4":
                System.out.println("Goodbye.");
                return;
            default:
                System.out.println("Invalid Choice");
        }
        }
    }
}
