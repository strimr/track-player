package si.strimr.track.player.api.v1.resources;

import com.kumuluz.ee.logs.cdi.Log;
import com.kumuluz.ee.logs.cdi.LogParams;
import si.strimr.track.player.models.dtos.TrackData;
import si.strimr.track.player.models.dtos.TrackMetadata;
import si.strimr.track.player.models.entities.TrackBundle;
import si.strimr.track.player.services.beans.TrackPlayerBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Log(value = LogParams.METRICS, methodCall = true)
@ApplicationScoped
@Path("/track-player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TrackPlayerResource {

    @Inject
    private TrackPlayerBean trackPlayerBean;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response getPlayer() {

        return Response.ok("select id of a track").build();
    }

    @GET
    @Path("/{trackId}")
    public Response getPlayerForTrack(@PathParam("trackId") Integer trackId) {

        // get track-data
        // get track-metadata

        TrackBundle trackBundle = trackPlayerBean.getTrackBundle(trackId);

        if (trackBundle == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(trackBundle).build();
    }
}
