package az.pashabank.learning_session.ms_student.controller;


import az.pashabank.learning_session.ms_student.exception.NotFoundStudentException;
import az.pashabank.learning_session.ms_student.exception.NotValidParameters;
import az.pashabank.learning_session.ms_student.model.Student;
import az.pashabank.learning_session.ms_student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        LOGGER.info("Student with id=" + studentId + " is requested");
        return studentService.getStudentById(studentId);
    }

    @GetMapping("all")
    public List<Student> getAll() {
        LOGGER.info("List of all students is requested");
        return studentService.getAll();
    }

    @PostMapping("add")
    public boolean addStudent(@RequestBody Student student) {
        LOGGER.info("Student " + student + " is requested to add");
        try {
            return studentService.addStudent(student);
        } catch (NotValidParameters e) {
            LOGGER.debug(e.getMessage());
            return false;
        }
    }

    @PutMapping("update")
    public boolean updateStudent(@RequestBody Student student) {
        LOGGER.info("Update student with id=" + student.getId() + " is requested");
        try {
            return studentService.updateStudent(student);
        } catch (NotValidParameters e) {
            LOGGER.debug(e.getMessage());
            return false;
        }
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteStudent(@PathVariable Integer id) {
        LOGGER.info("Student with id=" + id + " is requested to delete");
        try {
            return studentService.deleteStudent(id);
        } catch (NotValidParameters e) {
            return false;
        } catch (NotFoundStudentException fe) {
            return false;
        }
    }

    @GetMapping("city/{city}")
    public List<Student> getStudentsByCollegeLocation(@PathVariable("city") String city) {
        LOGGER.info("Students in college city=" + city + " are requested");
        try {
            List<Student> student=studentService.getByCollegeLocation(city);
            return student;
        } catch (NotFoundStudentException e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }
}
