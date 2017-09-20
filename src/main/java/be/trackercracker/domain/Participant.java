package be.trackercracker.domain;

import javax.persistence.*;
import java.awt.*;

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

    @OneToOne
    private TraceRecord traceRecord;
    //@ManyToOne(mappedBy = "participants")
    //private Group group;



    public Participant(){}
    public Participant(String label, TraceRecord traceRecord) {
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

    public TraceRecord getTraceRecord() {
        return traceRecord;
    }

    public void setTraceRecord(TraceRecord traceRecord) {
        this.traceRecord = traceRecord;
    }
}
