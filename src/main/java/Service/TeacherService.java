package Service;

import Repository.TeacherRepository;
import model.Course;
import model.Teacher;

import java.util.List;

public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherService() {
        this.teacherRepository = new TeacherRepository();
    }

    public Teacher login(String fullName, String email) {
        Teacher teacher = teacherRepository.findByFullName(fullName);
        if (teacher != null && teacher.getEmail().equals(email)) {
            return teacher;
        }
        List<Teacher> list = teacherRepository.findTeacherProfile(fullName);
        return list.isEmpty() ? null : list.get(0);
    }
    public boolean addNewTeacher(String fullName, String email, String department) {
        Teacher teacher = new Teacher(0, fullName,department, email);
        return teacherRepository.addNewTeacher(teacher);
    }
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAllTeacher();
    }
    public boolean changeTeacher(int id, String fullName, String department, String email) {
        Teacher teacher = new Teacher(id, fullName, department, email);
        return teacherRepository.changeTeacher(teacher);
    }
    public boolean deleteTeacher(int id) {
        return teacherRepository.deleteTeacherById(id);
    }
}
