package be.trackercracker.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vdabcursist on 19/09/2017.
 */
@Entity
public class Group_ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column //(nullable = false)
    private String groupName;

    @OneToMany
    private List<Participant> participants;

    public Group_(String groupName, List<Participant> participants) {
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

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
