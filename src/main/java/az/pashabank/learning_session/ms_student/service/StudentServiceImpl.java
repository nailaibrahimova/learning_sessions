package az.pashabank.learning_session.ms_student.service;

import az.pashabank.learning_session.ms_student.exception.NotFoundStudentException;
import az.pashabank.learning_session.ms_student.exception.NotValidParameters;
import az.pashabank.learning_session.ms_student.model.Student;
import az.pashabank.learning_session.ms_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CollegeService collegeService;

    @Override
    public Student getStudentById(Integer student_id) {
        List<Student> students = studentRepository.getStudents().stream().filter(student -> student.getId().equals(student_id)).collect(Collectors.toList());
        return students.isEmpty() ? null : students.get(0);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getStudents();
    }

    @Override
    public boolean addStudent(Student student) {
        try {
            if (student.getId() == null || student.getFirstName() == null || student.getLastName() == null ||
                    student.getFirstName().length() <= 2 || student.getLastName().length() <= 2) {
                throw new NotValidParameters("You did not specified parameters of student");
            }
            studentRepository.getStudents().add(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            if (student.getId() == null || student.getFirstName() == null || student.getLastName() == null ||
                    student.getFirstName().length() <= 2 || student.getLastName().length() <= 2) {
                throw new NotValidParameters("You did not specified parameters of student");
            }
            studentRepository.getStudents().removeIf(s -> s.getId().equals(student.getId()));
            studentRepository.getStudents().add(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteStudent(Integer id) {
        try {
            if (id == null || id < 1) throw new NotValidParameters("You did not give the valid id");
            List<Student> student = studentRepository.getStudents().stream().filter(s -> s.getId().equals(id)).collect(Collectors.toList());
            if (student.isEmpty()) throw new NotFoundStudentException("No student with such id");
            else studentRepository.getStudents().remove(student.get(0));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Student> getByCollegeLocation(String city) {
        try {
            if (city == null) throw new NotValidParameters("Not valid city name");
            List<Student> student = studentRepository.getStudents()
                    .stream()
                    .filter(s -> collegeService.getById(s.getUniversityId()).getCity().equals(city))
                    .collect(Collectors.toList());
            if(student.isEmpty()) throw new NotFoundStudentException("No students in city='"+city+"'.");
            else return student;
        } catch (Exception e) {
            return null;
        }
    }
}
