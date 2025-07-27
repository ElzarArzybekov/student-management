package Service;

import Repository.GroupRepository;
import Repository.StudentRepository;
import model.Group;

import java.time.LocalDate;
import java.util.List;

public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public GroupService() {
        this.groupRepository = new GroupRepository();
    }
    public boolean addNewGroup(String name, int curator_id, LocalDate start_year) {
        Group group = new Group(0, name, curator_id, start_year);
        return groupRepository.addGroup(group);
    }
    public List<Group> findAllGroups() {
        return groupRepository.getAllGroups();
    }
    public boolean deleteGroup(int id) {
        return groupRepository.deleteGroup(id);
    }
    public List<Group> getTeacherGroup(int curator_id) {
        return groupRepository.getTeacherGroups(curator_id);
    }
}
