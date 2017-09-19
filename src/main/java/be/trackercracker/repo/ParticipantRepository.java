package be.trackercracker.repo;

import be.trackercracker.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vdabcursist on 19/09/2017.
 */
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    }

