package be.trackercracker.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Created by vdabcursist on 19/09/2017.
 */
@Embeddable
public class Coordinate {

    @Column
    private Date timeStamp;
    @Column
    private double latitude;
    @Column
    private double longitude;

    public Coordinate() {
    }

    public Coordinate(Date timeStamp, double latitude, double longitude) {
        this.timeStamp = timeStamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Date getTime() {
        return timeStamp;
    }

    public void setTime(Date time) {
        this.timeStamp = timeStamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
