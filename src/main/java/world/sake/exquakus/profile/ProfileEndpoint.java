package world.sake.exquakus.profile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.runtime.configuration.ProfileManager;

@Path("/profile")
public class ProfileEndpoint {

    // e.g. http://localhost:8080/profile
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return ProfileManager.getActiveProfile();
    }
}
