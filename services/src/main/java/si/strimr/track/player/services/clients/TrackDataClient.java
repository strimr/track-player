package si.strimr.track.player.services.clients;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import si.strimr.track.player.models.dtos.TrackData;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriInfo;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class TrackDataClient {

    private Logger log = Logger.getLogger(TrackDataClient.class.getName());

    private Client httpClient;

    @Inject
    @DiscoverService("rso-track-data")
    private Optional<String> trackDataBaseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    @CircuitBreaker(requestVolumeThreshold = 3)
    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
    @Fallback(fallbackMethod = "getTrackDataFallback")
    public TrackData getTrackData(Integer trackId) {

        if (trackDataBaseUrl.isPresent()) {
            try {
                // TODO - pass uriInfo
                return httpClient
                        .target(trackDataBaseUrl.get() + "/v1/track-data/"+trackId)
                        .request().get(new GenericType<TrackData>(){});
            } catch (Exception e) {
                log.severe(e.getMessage());
                throw new InternalServerErrorException(e);
            }
        }

        return null;

    }

    public TrackData getTrackDataFallback(Integer trackId) {
        return new TrackData();
    }
}