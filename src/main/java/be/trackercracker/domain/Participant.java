package be.trackercracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vdabcursist on 19/09/2017.
 */

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String label;

    @ManyToOne
    public Group group;

    @Column
    private String traceRecord;

    @ElementCollection
    private List<Coordinate> coordinates = new ArrayList<>();


    public Participant(){}
    public Participant(String label, String traceRecord) {
        this.label = label;
        this.traceRecord = traceRecord;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTraceRecord() {
        return traceRecord;
    }

    public void setTraceRecord(String traceRecord) {
        this.traceRecord = traceRecord;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", group=" + group +
                ", traceRecord='" + traceRecord + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
