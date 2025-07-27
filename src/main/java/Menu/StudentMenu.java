package Menu;

import Service.*;
import model.Student;
import model.Student_Course;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    private StudentService studentService;
    private TeacherService teacerService;
    private AdminService adminService;
    private CourceService courseService;
    private GroupService groupService;

    public StudentMenu() {
        this.studentService = new StudentService();
        this.teacerService = new TeacherService();
        this.adminService = new AdminService();
        this.courseService = new CourceService();
        this.groupService = new GroupService();
    }
    public void studentMenu(Student student) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===Student Menu===");
            System.out.println("1. View my profile");
            System.out.println("2. View enrolled courses");
            System.out.println("3. View my group");
            System.out.println("4. Logout");

            System.out.println("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" :
                    System.out.println("Your profile");
                    System.out.println("Name: "+ student.getFullName());
                    System.out.println("Age: "+ student.getAge());
                    System.out.println("Email: "+ student.getEmail());
                    System.out.println("Group ID: "+ student.getGroupId());
                    break;
                    case "2" :
                        List<Student> listStudent = studentService.getAllStudents();
                        if (listStudent.isEmpty()) {
                            System.out.println("No student found!");
                            break;
                        }
                        System.out.println("List of students found: ");
                        for (Student student1 : listStudent) {
                            System.out.println(student);
                        }
                        System.out.println("Enter the student ID to add the course: ");
                        int student_id = Integer.parseInt(scanner.nextLine());
                        List<Student_Course> enrolledCourse = courseService.getEnrolCourseByStudentId(student_id);
                        if (enrolledCourse.isEmpty()) {
                            System.out.println("You have no enrolled courses found!");
                        }else {
                            System.out.println("You enrolled courses found: ");
                            for (Student_Course course1 : enrolledCourse) {
                                System.out.println(course1);
                            }
                        }
                        break;
                        case "3" :
                            System.out.println("Your group Id: "+ student.getGroupId());
                            break;
                            case "4" :
                                System.out.println("Goodbye!");
                                return;
                                default:
                                        System.out.println("Invalid choice!");
            }
        }
    }
}
