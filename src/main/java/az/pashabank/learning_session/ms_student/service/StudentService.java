package az.pashabank.learning_session.ms_student.service;

import az.pashabank.learning_session.ms_student.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(Integer student_id);

    List<Student> getAll();

    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(Integer id);

    List<Student> getByCollegeLocation(String city);
}
