package si.strimr.track.player.models.entities;

import si.strimr.track.player.models.dtos.TrackData;
import si.strimr.track.player.models.dtos.TrackMetadata;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity(name = "track_bundle")
public class TrackBundle {

    @Transient
    private TrackData trackData;
    private TrackMetadata trackMetadata;

    public TrackData getTrackData() {
        return trackData;
    }

    public void setTrackData(TrackData trackData) {
        this.trackData = trackData;
    }

    public TrackMetadata getTrackMetadata() {
        return trackMetadata;
    }

    public void setTrackMetadata(TrackMetadata trackMetadata) {
        this.trackMetadata = trackMetadata;
    }
}