package Menu;

import Service.*;
import model.Group;
import model.Teacher;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GroupMenu {
        private StudentService studentService;
        private TeacherService teacerService;
        private AdminService adminService;
        private CourceService courseService;
        private GroupService groupService;

        public GroupMenu() {
            this.studentService = new StudentService();
            this.teacerService = new TeacherService();
            this.adminService = new AdminService();
            this.courseService = new CourceService();
            this.groupService = new GroupService();
        }
        public void groupMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add new group");
                System.out.println("2. View all groups");
                System.out.println("3. Delete a group");
                System.out.println("4. Back");

                System.out.println("Choice: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1" :
                        System.out.println("Enter group name: ");
                        String groupName = scanner.nextLine();

                        List<Teacher> curators = teacerService.getAllTeachers();
                        if (curators.isEmpty()){
                            System.out.println("No teachers found");
                            break;
                        }
                        System.out.println("Teachers found: ");
                        for (Teacher teacher : curators) {
                            System.out.println(teacher);
                        }
                        System.out.println("Enter curator ID: ");
                        int curatorID = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter start year: ");
                        LocalDate startDate = LocalDate.parse(scanner.nextLine());

                         boolean AddNewGroup = groupService.addNewGroup(groupName, curatorID, startDate);
                         if (AddNewGroup) {
                             System.out.println("Successfully added group");
                         }else {
                             System.out.println("Failed to add group");
                         }
                        break;
                        case "2" :
                            List<Group> viewAllGroups = groupService.findAllGroups();
                            if (viewAllGroups.isEmpty()){
                                System.out.println("No groups found");
                            }else {
                                System.out.println("Groups found: ");
                                for (Group group : viewAllGroups) {
                                    System.out.println(group);
                                }
                            }
                            break;
                            case "3" :
                                List<Group> ListGroupToDelete = groupService.findAllGroups();
                                if (ListGroupToDelete.isEmpty()){
                                    System.out.println("No groups found");
                                    break;
                                }
                                    System.out.println("Groups found: ");
                                    for (Group group : ListGroupToDelete) {
                                        System.out.println(group);
                                    }
                                System.out.println("Enter group ID to delete: ");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    boolean DeleteGroup = groupService.deleteGroup(id);
                                    if (DeleteGroup) {
                                        System.out.println("Successfully deleted group");
                                    }else {
                                        System.out.println("Failed to delete group");
                                    }
                                break;
                                case "4" :
                                    return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
}
