package Service;

import Repository.CourseRepository;
import Repository.StudentRepository;
import model.Student;
import model.Student_Course;
import model.Teacher;

import java.time.LocalDate;
import java.util.List;

public class StudentService {
        private final StudentRepository studentRepository;
        public StudentService(StudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }

        public StudentService() {
            this.studentRepository = new StudentRepository();
        }

        public Student login(String fullName, String email) {
            Student student = studentRepository.findByFullName(fullName);
            if (student != null && student.getEmail().equals(email)) {
                return student;
            }
            List<Student> list = studentRepository.findStudentProfile(fullName);
            return list.isEmpty() ? null : list.get(0);
        }
    public boolean addNewStudent(String fullName, int age, String email, int group_id, LocalDate enrollmentDate, int course_id) {
            Student student = new Student(0, fullName, 0, email,  group_id, enrollmentDate, course_id );
            return studentRepository.addNewStudent(student);
    }
    public List<Student> getAllStudents() {
            return  studentRepository.findAllStudents();
    }
    public boolean changeStudent(int id, String fullName, String email, int age, int group_id, LocalDate enrollmentDate, int course_id) {
            Student student = new Student(id, fullName, age, email,  group_id, enrollmentDate,  course_id );
            return studentRepository.changeStudent(student);
    }
    public boolean deleteStudents(int id) {
            return studentRepository.deleteStudentById(id);
    }
    public List<Student> getStudentsByCourseID(int courseId){
            return studentRepository.findStudentTeacherCourses(courseId);
    }
}
