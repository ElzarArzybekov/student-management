package Menu;

import Service.*;
import model.*;

import java.util.List;
import java.util.Scanner;

public class TeacherMenu {
    private StudentService studentService;
    private TeacherService teacerService;
    private AdminService adminService;
    private CourceService courseService;
    private GroupService groupService;

    public TeacherMenu() {
        this.studentService = new StudentService();
        this.teacerService = new TeacherService();
        this.adminService = new AdminService();
        this.courseService = new CourceService();
        this.groupService = new GroupService();
    }
    public void teacherMenu(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===Teacher Menu===");
            System.out.println("1. View my profile");
            System.out.println("2. View my courses");
            System.out.println("3. View my groups");
            System.out.println("4. View students by my courses");
            System.out.println("5. Logout");

            System.out.println("Choice");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" :
                    System.out.println("Your profile: ");
                    System.out.println("Name: " + teacher.fullName);
                    System.out.println("Email: " + teacher.email);
                    System.out.println("Department: " + teacher.department);
                    break;
                    case "2" :
                        List<Course> listYourCourse = courseService.getTeacherCourses(teacher.getId());
                        if (listYourCourse.isEmpty()) {
                            System.out.println("No courses found");
                        }else {
                            System.out.println("Your courses: ");
                            for (Course c : listYourCourse) {
                                System.out.println(c);
                            }
                        }
                        break;
                        case "3" :
                            List<Group> listYourGroup = groupService.getTeacherGroup(teacher.getId());
                            if (listYourGroup.isEmpty()) {
                                System.out.println("No groups found");
                            }else {
                                System.out.println("Your groups: ");
                                for (Group g : listYourGroup) {
                                    System.out.println(g);
                                }
                            }
                            break;
                            case "4" :
                                List<Course> listYourCourseStudents = courseService.getTeacherCourses(teacher.getId());
                                if (listYourCourseStudents.isEmpty()) {
                                    System.out.println("No courses found");
                                    break;
                                }
                                    System.out.println("Your courses: ");
                                    for (Course c : listYourCourseStudents) {
                                        System.out.println(c);
                                }
                                System.out.println("Enter the course ID in which you want to see students: ");
                                    int courseID = Integer.parseInt(scanner.nextLine());
                                    List<Student_Course> students = courseService.getStudentCourseById(courseID);
                                    if (students.isEmpty()) {
                                        System.out.println("No students found");
                                    }else {
                                        System.out.println("Your students: ");
                                        for (Student_Course s : students) {
                                            System.out.println(s);
                                        }
                                    }
                                break;
                                    case "5" :
                                        System.out.println("Goodbye!");
                                        return;
                                        default:
                                                System.out.println("Invalid choice!");
            }
        }
    }
}
