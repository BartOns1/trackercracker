package be.trackercracker.domain;

import be.trackercracker.repo.GroupRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vdabcursist on 19/09/2017.
 */
@Entity
@Table(name="tracker_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column //(nullable = false)
    private String groupName;

    @OneToMany
    private List<Participant> participants = new ArrayList<>();


    public Group(){}
    public Group(String groupName, List<Participant> participants) {
        this.groupName = groupName;
        this.participants = participants;
    }

    public Integer getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @JsonIgnore
    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
