package be.trackercracker.web;

/**
 * Created by vdabcursist on 20/09/2017.
 */

import be.trackercracker.domain.Coordinate;
import jdk.nashorn.internal.runtime.Undefined;
import org.springframework.web.bind.annotation.RestController;

import be.trackercracker.domain.Participant;
import be.trackercracker.repo.GroupRepository;
import be.trackercracker.repo.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group/participant")
public class MyParticipantController {
    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    GroupRepository groupRepository;


  //  @RequestMapping(method = RequestMethod.GET, path="/all", produces = "application/json")
   // public List<Participant> getAll() {
   //     return participantRepository.findAll();
  //  }

    @RequestMapping(method = RequestMethod.GET, path="/{name}", produces = "application/json")
    public Participant findByLabel(@PathVariable("name") String name) {
        return participantRepository.findByLabel(name);
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        Participant participant = participantRepository.findOne(id);
     //   List<Group> groups=groupRepository.findDistinctByParticipants(participant);
      //  System.out.println(groups.toString());

       // for(Group group:groups) {
       //     group.getParticipants().remove(participant);
       //     groupRepository.save(group);
       // }
        //TraceRecord traceRecord=participant.getTraceRecord();
        //Integer trace_id=traceRecord.getId();
        //for (Coordinate coordinate: traceRecord.getCoordinates()) {
        //    sett all null todo
        //}
        //traceRecordRepository.delete(trace_id);
        participantRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Participant> create(@RequestBody Participant input) {
        if(input.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        participantRepository.save(input);
        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }



    @RequestMapping(method = RequestMethod.PUT, path="/coordinates/{name}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> addCoordinates(@PathVariable("name") String name, @RequestBody Coordinate input){
        if(input.getTime() == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            Participant participant = participantRepository.findByLabel(name);
            participant.getCoordinates().add(input);
            System.out.println(input.toString());
            System.out.println(participant.toString());

            participantRepository.save(participant);
            return new ResponseEntity<>(HttpStatus.OK);
    }



    //

    // talk to repo: find Participant by id, add coordinate to partipant getCoordinates().add(c), then save paricipant




    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Participant> update(@RequestBody Participant input) {
        if(input.getId() == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        participantRepository.save(input);
        return new ResponseEntity<>(input, HttpStatus.OK);
    }




}