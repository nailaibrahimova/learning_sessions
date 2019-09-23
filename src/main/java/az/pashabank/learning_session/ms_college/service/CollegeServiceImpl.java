package az.pashabank.learning_session.ms_college.service;

import az.pashabank.learning_session.ms_college.exception.NotFoundCollegeException;
import az.pashabank.learning_session.ms_college.exception.WrongParameterException;
import az.pashabank.learning_session.ms_college.model.College;
import az.pashabank.learning_session.ms_college.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public College getById(Integer id) {
        List<College> result = collegeRepository.getColleges().stream().
                filter(college -> college.getId().equals(id)).collect(Collectors.toList());
        return result.isEmpty() == false ? result.get(0) : null;
    }

    @Override
    public List<College> getAll() {
        return collegeRepository.getColleges();
    }

    @Override
    public boolean addCollege(College college) {
        try {
            if(college.getId()==null || college.getName()==null || college.getCity()==null){
                throw new WrongParameterException("You did not specified parameters for college");
            }
            collegeRepository.getColleges().add(college);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(College college) {
        try {
            if (college.getId() == null || college.getName() == null || college.getCity() == null ||
                    college.getName().length() <= 2 || college.getCity().length() <= 2) {
                throw new WrongParameterException("You did not specified parameters of college");
            }
            collegeRepository.getColleges().removeIf(c -> c.getId().equals(college.getId()));
            collegeRepository.getColleges().add(college);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            if (id == null || id < 1) throw new WrongParameterException("You did not give the valid id");
            List<College> student = collegeRepository.getColleges().stream().filter(c -> c.getId().equals(id)).collect(Collectors.toList());
            if (student.isEmpty()) throw new NotFoundCollegeException("No college with such id");
            else collegeRepository.getColleges().remove(student.get(0));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
