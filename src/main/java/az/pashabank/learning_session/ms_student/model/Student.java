package az.pashabank.learning_session.ms_student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private int universityId;
    private static Integer nextId = 1;
}
