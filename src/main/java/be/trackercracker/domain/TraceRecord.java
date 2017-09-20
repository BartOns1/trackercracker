package be.trackercracker.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vdabcursist on 19/09/2017.
 */

@Entity
public class TraceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    private List<Coordinate> coordinates;

    @Column
    private String TraceRecordName;
    //@OneToOne
    //private Participant participant;



    public TraceRecord(){}
    public TraceRecord(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
        TraceRecordName = this.getId().toString()+".log";
    }

    public Integer getId() {
        return id;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public String getTraceRecordName() {
        return TraceRecordName;
    }
}
