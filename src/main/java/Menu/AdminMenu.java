package Menu;

import Service.AdminService;
import Service.GroupService;
import Service.StudentService;
import Service.TeacherService;
import model.Group;
import model.Student;
import model.Teacher;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private StudentService studentService;
    private TeacherService teacerService;
    private AdminService adminService;
    private GroupService groupService;

    public AdminMenu() {
        this.studentService = new StudentService();
        this.teacerService = new TeacherService();
        this.adminService = new AdminService();
        this.groupService = new GroupService();
    }
    Scanner  scanner = new Scanner(System.in);
    public void adminMenu() {
        while (true) {
            System.out.println("======= Admin Menu =======");
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. View all students");
            System.out.println("4. View all teachers");
            System.out.println("5. Update student info");
            System.out.println("6. Update teacher info");
            System.out.println("7. Delete student");
            System.out.println("8. Delete teacher");
            System.out.println("9. Course");
            System.out.println("10. Group");
            System.out.println("0. Logout");
            System.out.println("=========================");
            System.out.println("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" :
                    System.out.println("Enter student full name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter student age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter student email: ");
                    String newEmail = scanner.nextLine();

                    List<Group> AllGroups = groupService.findAllGroups();
                    if (AllGroups.isEmpty()) {
                        System.out.println("No groups found!");
                        break;
                    }
                    System.out.println("List of groups: ");
                    for (Group group : AllGroups) {
                        System.out.println(group);
                    }

                    System.out.println("Enter group id to add student");
                    int group_id = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter enrollment date: ");
                    LocalDate enrollDate =  LocalDate.parse(scanner.nextLine());
                    boolean added = studentService.addNewStudent(newName, newAge, newEmail, group_id, enrollDate, 0);
                    if (added) {
                        System.out.println("Student added successfully!");
                    }else {
                        System.out.println("Failed to add student.");
                    }

                    break;
                    case "2" :
                        System.out.println("Enter teacher full name: ");
                        String newName1 = scanner.nextLine();
                        System.out.println("Enter teacher email: ");
                        String newEmail1 = scanner.nextLine();
                        System.out.println("Enter teacher department: ");
                        String newDepartment1 = scanner.nextLine();
                        boolean added1 = teacerService.addNewTeacher(newName1, newEmail1, newDepartment1);
                        if (added1) {
                            System.out.println("Teacher added successfully!");
                        }else {
                            System.out.println("Failed to add teacher.");
                        }
                        break;
                        case "3" :
                            List<Student> students = studentService.getAllStudents();
                            if (students.isEmpty()) {
                                System.out.println("No students found!");
                            }else {
                                for (Student student : students) {
                                    System.out.println(student);
                                }
                            }
                            break;
                            case "4" :
                                List<Teacher> teachers = teacerService.getAllTeachers();
                                if (teachers.isEmpty()) {
                                    System.out.println("No teachers found!");
                                }else {
                                    for (Teacher teacher : teachers) {
                                        System.out.println(teacher);
                                    }
                                }
                                break;
                                case "5" :
                                    List<Student> students1 = studentService.getAllStudents();
                                    if (students1.isEmpty()) {
                                        System.out.println("No students found!");
                                        break;
                                    }
                                    System.out.println("List of students found: ");
                                    for (Student student : students1) {
                                        System.out.println(student);
                                    }
                                    System.out.println("Enter the ID of the student you want to change");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Enter a new name for the student: ");
                                    String newNameSt = scanner.nextLine();
                                    System.out.println("Enter a new age for the student: ");
                                    int age = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Enter a new email for the student: ");
                                    String newEmailSt = scanner.nextLine();

                                    List<Group> newGroup = groupService.findAllGroups();
                                    if (newGroup.isEmpty()) {
                                        System.out.println("No groups found!");
                                        break;
                                    }
                                    System.out.println("List of groups: ");
                                    for (Group group  : newGroup) {
                                        System.out.println(group);
                                    }

                                    System.out.println("Enter the new group ID to student: ");
                                    int newGroupId = Integer.parseInt(scanner.nextLine());

                                    System.out.println("Enter the new enrollment date: ");
                                    LocalDate newDate = LocalDate.parse(scanner.nextLine());
                                    boolean NewInfoStudent = studentService.changeStudent(id, newNameSt, newEmailSt, age, newGroupId, newDate, 0);
                                    if (NewInfoStudent) {
                                        System.out.println("Student changed sucessfully!");
                                    }else {
                                        System.out.println("Failed to change student.");
                                    }
                                    break;
                                    case "6" :
                                        List<Teacher> teachers1 = teacerService.getAllTeachers();
                                        if (teachers1.isEmpty()) {
                                            System.out.println("No teacher found!");
                                            break;
                                        }
                                        System.out.println("List of teacher found: ");
                                        for (Teacher teacher : teachers1) {
                                            System.out.println(teacher);
                                        }
                                        System.out.println("Enter the ID of the teacher you want to change");
                                        int id1 = Integer.parseInt(scanner.nextLine());
                                        System.out.println("Enter a new name for the teacher: ");
                                        String newNameTch = scanner.nextLine();
                                        System.out.println("Enter a new department for the teacher: ");
                                        String newDepartmentTch = scanner.nextLine();
                                        System.out.println("Enter a new email for the teacher: ");
                                        String newEmailTch = scanner.nextLine();
                                        boolean NewInfoTch = teacerService.changeTeacher(id1, newNameTch, newDepartmentTch, newEmailTch);
                                        if (NewInfoTch) {
                                            System.out.println("Teacher changed sucessfully!");
                                        }else {
                                            System.out.println("Failed to change teacher.");
                                        }

                                        break;
                                        case "7" :
                                            List<Student> listStudent = studentService.getAllStudents();
                                            if (listStudent.isEmpty()) {
                                                System.out.println("No students found!");
                                                break;
                                            }
                                            System.out.println("List of students found: ");
                                            for (Student student : listStudent) {
                                                System.out.println(student);
                                            }
                                            System.out.println("Enter the ID of the student you want to delete");
                                            int deleteId = Integer.parseInt(scanner.nextLine());
                                            boolean deleteStudent = studentService.deleteStudents(deleteId);
                                            if (deleteStudent) {
                                                System.out.println("Student delete sucessfully!");
                                            }else {
                                                System.out.println("Failed to delete student.");
                                            }
                                            break;
                                            case "8" :
                                                List<Teacher> listTeacher = teacerService.getAllTeachers();
                                                if (listTeacher.isEmpty()) {
                                                    System.out.println("No teacher found!");
                                                    break;
                                                }
                                                System.out.println("List of teacher found: ");
                                                for (Teacher teacher : listTeacher) {
                                                    System.out.println(teacher);
                                                }
                                                System.out.println("Enter the ID of the teacher you want to delete");
                                                int deleteId1 = Integer.parseInt(scanner.nextLine());
                                                boolean deleteTeacher = teacerService.deleteTeacher(deleteId1);
                                                if (deleteTeacher) {
                                                    System.out.println("Teacher delete sucessfully!");
                                                }else {
                                                    System.out.println("Failed to delete teacher.");
                                                }
                                                break;
                                                case "9" :
                                                    CourseMenu courseMenu = new CourseMenu();
                                                    courseMenu.courseMenu();
                                                        break;
                                                    case "10" :
                                                        GroupMenu groupMenu = new GroupMenu();
                                                        groupMenu.groupMenu();
                                                        break;
                                                        case "0" :
                                                            System.out.println("Goodbye!");
                                                            return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
