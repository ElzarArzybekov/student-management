package Service;

import Repository.CourseRepository;
import Repository.StudentRepository;
import model.Course;
import model.Student;
import model.Student_Course;

import java.time.LocalDate;
import java.util.List;

public class CourceService {
    private final CourseRepository courseRepository;

    public CourceService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public CourceService() {
        this.courseRepository = new CourseRepository();
    }
    public boolean addCourse(String name, String description, int teacher_id, int credits) {
        Course course = new Course(0, name, description, teacher_id, credits);
        return courseRepository.addNewCourse(course);
    }
    public boolean addStudentToCourse(int courseId, int studentId, LocalDate enrolmentDate) {
        return courseRepository.addStudentToCourseById(courseId, studentId, enrolmentDate);
    }
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }
    public List<Student_Course>  getAllStudentCourses() {
        return courseRepository.getAllStudentsAtTheCourse();
    }
    public boolean deleteCourse(int courseId) {
        return courseRepository.DeleteCourseById(courseId);
    }
    public List<Course> getTeacherCourses(int teacherId) {
        return courseRepository.findTeacherCourses(teacherId);
    }
    public List<Student_Course> getStudentCourseById(int courseId) {
        return courseRepository.findStudentByCourseId(courseId);
    }
    public List<Student_Course> getEnrolCourseByStudentId(int studentId) {
        return courseRepository.myEnrolledCourses(studentId);
    }
}
