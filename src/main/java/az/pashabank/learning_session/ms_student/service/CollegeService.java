package az.pashabank.learning_session.ms_student.service;

import az.pashabank.learning_session.ms_student.model.College;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "collegeService", url = "localhost:8081/college")
public interface CollegeService {
    @GetMapping("getById/{id}")
    College getById(@PathVariable Integer id);
}
