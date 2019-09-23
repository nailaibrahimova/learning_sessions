package az.pashabank.learning_session.ms_college.controller;

import az.pashabank.learning_session.ms_college.model.College;
import az.pashabank.learning_session.ms_college.service.CollegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CollegeController.class);

    @GetMapping("all")
    public List<College> getAll() {
        LOGGER.info("List of all colleges is requested");
        return collegeService.getAll();
    }

    @GetMapping("getById/{id}")
    public College getById(@PathVariable Integer id) {
        LOGGER.info("College with id=" + id + " is requested");
        return collegeService.getById(id);

    }

    @PostMapping("add")
    public boolean addCollege(@RequestBody College college) {
        LOGGER.info("College with id=" + college.getId() + " is requested to add");
        return collegeService.addCollege(college);
    }

    @PutMapping("update")
    public boolean update(@RequestBody College college) {
        LOGGER.info("College with id=" + college.getId() + " is requested to update");
        return collegeService.update(college);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        LOGGER.info("College with id=" + id + " is requested to delete");
        return collegeService.delete(id);
    }
}
