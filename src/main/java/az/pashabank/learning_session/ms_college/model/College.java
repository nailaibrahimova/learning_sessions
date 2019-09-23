package az.pashabank.learning_session.ms_college.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {
    private Integer id;
    private String name;
    private String city;
}
