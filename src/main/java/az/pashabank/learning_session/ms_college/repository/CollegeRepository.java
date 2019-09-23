package az.pashabank.learning_session.ms_college.repository;

import az.pashabank.learning_session.ms_college.model.College;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CollegeRepository {

    private List<College> colleges = new ArrayList<>();

    public CollegeRepository() {
        colleges.add(new College(1, "BEU", "Khirdalan"));
        colleges.add(new College(2, "ADNSU", "Baku"));
        colleges.add(new College(3, "MGU", "Moscow"));
    }
}
