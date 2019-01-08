package si.strimr.track.player.models.dtos;

public class TrackData {

    private Integer id;
    private Integer trackMetadataId;
    private String trackFileContent;
    private String trackFileType;
    private String trackFileName;

    public Integer getId() {
        return id;
    }

    public Integer getTrackMetadataId() {
        return trackMetadataId;
    }

    public String getTrackFileContent() {
        return trackFileContent;
    }

    public String getTrackFileType() {
        return trackFileType;
    }

    public String getTrackFileName() {
        return trackFileName;
    }

}