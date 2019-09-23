package az.pashabank.learning_session.ms_student.repository;

import az.pashabank.learning_session.ms_student.model.Student;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(1, "Naila", "Ibrahimova", 1));
        students.add(new Student(2, "Lala", "Seyidova", 2));
        students.add(new Student(3, "Rena", "Bagirova", 3));
    }
}
