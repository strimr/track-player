package si.strimr.track.player.services.beans;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.annotation.Timed;

import si.strimr.track.player.models.dtos.TrackData;
import si.strimr.track.player.services.clients.TrackDataClient;

import si.strimr.track.player.models.dtos.TrackMetadata;
import si.strimr.track.player.services.clients.TrackMetadataClient;

import si.strimr.track.player.models.entities.TrackBundle;
import si.strimr.track.player.services.configuration.AppProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.logging.Logger;


@ApplicationScoped
// @RequestScoped
public class TrackPlayerBean {

    private Logger log = Logger.getLogger(TrackPlayerBean.class.getName());

    @Inject
    private AppProperties appProperties;

    @Inject
    private TrackDataClient trackDataClient;

    @Inject
    private TrackMetadataClient trackMetadataClient;

    @Inject
    private TrackPlayerBean trackPlayerBean;

    private Client httpClient;

    @Inject
    @DiscoverService("rso-track-data")
    private Optional<String> trackDataBaseUrl;

    @Inject
    @DiscoverService("rso-track-metadata")
    private Optional<String> trackMetadataBaseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }


    public TrackBundle getTrackBundle(Integer trackId) {
        TrackBundle trackBundle = new TrackBundle();

//        TrackData trackData = trackPlayerBean.getTrackData(trackId);
        TrackData trackData = trackDataClient.getTrackData(trackId);

//        TrackMetadata trackMetadata = trackPlayerBean.getTrackMetadata(trackId);
        TrackMetadata trackMetadata = trackMetadataClient.getTrackMetadata(trackId);


        if(trackData != null) {
            trackBundle.setTrackData(trackData);
        }
        if(trackMetadata != null) {
            trackBundle.setTrackMetadata(trackMetadata);
        }

        return trackBundle;
    }



//    @Timed
//    @CircuitBreaker(requestVolumeThreshold = 3)
//    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
//    @Fallback(fallbackMethod = "getTrackDataFallback")
//    public TrackData getTrackData(Integer trackId) {
//        if (trackDataBaseUrl.isPresent()) {
//            try {
//                return httpClient
//                        .target(trackDataBaseUrl.get() + "/v1/track-data/" + trackId)
//                        .request().get(new GenericType<TrackData>() {
//                        });
//            } catch (WebApplicationException | ProcessingException e) {
//                log.severe(e.getMessage());
//                throw new InternalServerErrorException(e);
//            }
//        }
//        return null;
//    }
//
//    public TrackData getTrackDataFallback(Integer trackId) {
//        return new TrackData();
//    }


//    @Timed
//    @CircuitBreaker(requestVolumeThreshold = 3)
//    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
//    @Fallback(fallbackMethod = "getTrackMetadataFallback")
//    public TrackMetadata getTrackMetadata(Integer trackId) {
//        if (trackMetadataBaseUrl.isPresent()) {
//            try {
//                return httpClient
//                        .target(trackMetadataBaseUrl.get() + "/v1/track-metadata/" + trackId)
//                        .request().get(new GenericType<TrackMetadata>() {
//                        });
//            } catch (WebApplicationException | ProcessingException e) {
//                log.severe(e.getMessage());
//                throw new InternalServerErrorException(e);
//            }
//        }
//        return null;
//    }
//
//    public TrackMetadata getTrackMetadataFallback(Integer trackId) {
//        return new TrackMetadata();
//    }

    public void loadOrder(Integer n) {


    }
}
