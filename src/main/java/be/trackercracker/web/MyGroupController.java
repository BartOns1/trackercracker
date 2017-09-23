package be.trackercracker.web;

import be.trackercracker.domain.Group;
import be.trackercracker.domain.Participant;
import be.trackercracker.repo.GroupRepository;
import be.trackercracker.repo.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class MyGroupController {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @RequestMapping(method = RequestMethod.GET, path="/{name}", produces = "application/json")
    public Group getById(@PathVariable("name") String name) {
        return groupRepository.findByGroupName(name);
    }

    @RequestMapping(method = RequestMethod.GET, path="/{name}/participants", produces = "application/json")
    public List<Participant> getParticipantsByGroup(@PathVariable("name") String name) {
        return participantRepository.findParticipantByGroupGroupName(name);
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