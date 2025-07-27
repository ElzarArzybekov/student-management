package Menu;

import Service.AdminService;
import Service.CourceService;
import Service.StudentService;
import Service.TeacherService;
import model.Course;
import model.Student;
import model.Student_Course;
import model.Teacher;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CourseMenu {
    private StudentService studentService;
    private TeacherService teacerService;
    private AdminService adminService;
    private CourceService courseService;

    public CourseMenu() {
        this.studentService = new StudentService();
        this.teacerService = new TeacherService();
        this.adminService = new AdminService();
        this.courseService = new CourceService();
    }
    public void courseMenu() {
        AdminMenu adminMenu = new AdminMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add new course");
            System.out.println("2. Enroll a student in a course");
            System.out.println("3. View list students of course");
            System.out.println("4. View all courses");
            System.out.println("5. Delete a course");
            System.out.println("6. Back");

            System.out.println("Choice: ");
            String choice1 = scanner.nextLine();
            switch (choice1) {
                case "1" :
                    System.out.println("Enter course name: ");
                    String courseName = scanner.nextLine();

                    System.out.println("Enter course description: ");
                    String courseDescription = scanner.nextLine();

                    List<Teacher> listTeacher = teacerService.getAllTeachers();
                    if (listTeacher.isEmpty()) {
                        System.out.println("No teacher found!");
                        break;
                    }
                    System.out.println("List of teacher found: ");
                    for (Teacher teacher : listTeacher) {
                        System.out.println(teacher);
                    }
                    System.out.println("Enter the teacher ID for the course: ");
                    int teacher_id = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter the credits for the course: ");
                    int credits = Integer.parseInt(scanner.nextLine());

                    boolean newCourse = courseService.addCourse(courseName, courseDescription, teacher_id, credits);
                    if (newCourse) {
                        System.out.println("Course added successfully");
                    }else {
                        System.out.println("Course not added");
                    }
                    break;
                    case "2" :
                        List<Course> listCourse = courseService.getAllCourses();
                        if (listCourse.isEmpty()) {
                            System.out.println("No courses found!");
                            break;
                        }
                        System.out.println("List of courses found: ");
                        for (Course course : listCourse) {
                            System.out.println(course);
                        }
                        System.out.println("Enter the course ID to add a student: ");
                        int course_id = Integer.parseInt(scanner.nextLine());

                        List<Student> listStudent = studentService.getAllStudents();
                        if (listStudent.isEmpty()) {
                            System.out.println("No student found!");
                            break;
                        }
                        System.out.println("List of students found: ");
                        for (Student student : listStudent) {
                            System.out.println(student);
                        }
                        System.out.println("Enter the student ID to add the course: ");
                        int student_id = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter the date enrolled: ");
                        LocalDate enrolledDate = LocalDate.parse(scanner.nextLine());

                        boolean addStudentToCourse = courseService.addStudentToCourse(course_id, student_id, enrolledDate);
                        if (addStudentToCourse) {
                            System.out.println("Student added to course successfully");
                        }else {
                            System.out.println("Student not added to course");
                        }
                        break;
                        case "3" :
                            List<Student_Course> studentAtCourse = courseService.getAllStudentCourses();
                            if (studentAtCourse.isEmpty()) {
                                System.out.println("No students found!");
                            }else {
                            System.out.println("List of students found: ");
                            for (Student_Course student : studentAtCourse) {
                                System.out.println(student);
                            }
                            }
                            break;
                            case "4" :
                                List<Course> viewAllCourses = courseService.getAllCourses();
                                if (viewAllCourses.isEmpty()) {
                                    System.out.println("No courses found!");
                                }else {
                                    System.out.println("List of courses found: ");
                                    for (Course course : viewAllCourses) {
                                        System.out.println(course);
                                    }
                                }
                                break;
                                case "5" :
                                    List<Course> listDeleteCourse = courseService.getAllCourses();
                                    if (listDeleteCourse.isEmpty()) {
                                        System.out.println("No courses found!");
                                        break;
                                    }
                                    System.out.println("List of courses found: ");
                                    for (Course course : listDeleteCourse) {
                                        System.out.println(course);
                                    }
                                    System.out.println("Enter the course ID to delete: ");
                                    int deleteCourseId = Integer.parseInt(scanner.nextLine());
                                    boolean deleteCourse = courseService.deleteCourse(deleteCourseId);
                                    if (deleteCourse) {
                                        System.out.println("Course deleted successfully");
                                    }else {
                                        System.out.println("Course not deleted");
                                    }
                                    break;
                                    case "6" :
                                       return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
