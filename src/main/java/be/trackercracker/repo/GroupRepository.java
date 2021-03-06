package be.trackercracker.repo;

import be.trackercracker.domain.Group;
import be.trackercracker.domain.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vdabcursist on 20/09/2017.
 */
public interface GroupRepository extends JpaRepository<Group,Integer> {
   // List<Group> findDistinctByParticipants(Participant participant);
    Group findByGroupName(String name);
    }
