package az.pashabank.learning_session.ms_college.service;

import az.pashabank.learning_session.ms_college.model.College;

import java.util.List;

public interface CollegeService {
    boolean addCollege(College college);

    College getById(Integer id);

    List<College> getAll();

    boolean update(College college);

    boolean delete(Integer id);
}
