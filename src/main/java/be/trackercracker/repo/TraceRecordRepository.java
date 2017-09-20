package be.trackercracker.repo;

import be.trackercracker.domain.TraceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vdabcursist on 20/09/2017.
 */
public interface TraceRecordRepository extends JpaRepository<TraceRecord,Integer>{
}
