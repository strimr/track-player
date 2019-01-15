package si.strimr.track.player.models.dtos;

import javax.persistence.*;

public class TrackData {

    private Integer id;
    private Integer trackMetadataId;
    private String trackFileContent;
    private String trackFileType;
    private String trackFileName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrackMetadataId() {
        return trackMetadataId;
    }

    public void setTrackMetadataId(Integer trackMetadataId) {
        this.trackMetadataId = trackMetadataId;
    }

    public String getTrackFileContent() {
        return trackFileContent;
    }

    public void setTrackFileContent(String trackFileContent) {
        this.trackFileContent = trackFileContent;
    }

    public String getTrackFileType() {
        return trackFileType;
    }

    public void setTrackFileType(String trackFileType) {
        this.trackFileType = trackFileType;
    }

    public String getTrackFileName() {
        return trackFileName;
    }

    public void setTrackFileName(String trackFileName) {
        this.trackFileName = trackFileName;
    }

}