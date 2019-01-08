package si.strimr.track.player.models.dtos;

import javax.persistence.*;

public class TrackMetadata {

    private Integer id;
    private String trackName;
    private String authorName;
    private String tags;
    private String deezerTrackId;
    private String preview;
    private Integer duration;
    private String albumPicture;

    public Integer getId() {
        return id;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getTags() {
        return tags;
    }

    public String getDeezerTrackId() {
        return deezerTrackId;
    }

    public String getPreview() {
        return preview;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getAlbumPicture() {
        return albumPicture;
    }
}