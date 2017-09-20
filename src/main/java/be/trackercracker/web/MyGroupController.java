package be.trackercracker.web;

import be.trackercracker.domain.Group;
import be.trackercracker.repo.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group")
public class MyGroupController {
    @Autowired
    GroupRepository groupRepository;

    @RequestMapping(method = RequestMethod.GET, path="{id}", produces = "application/json")
    public Group getById(@PathVariable("id") int id) {
        return groupRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Group> create(@RequestBody Group input) {
        if(input.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        groupRepository.save(input);
        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Group> update(@RequestBody Group input) {
        if(input.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        groupRepository.save(input);
        return new ResponseEntity<>(input, HttpStatus.OK);
    }

}