package world.sake.exquakus.user;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/users")
public class UserController {

    private UserRepository repository = UserRepository.testsetup();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResource get(@PathParam Long id) {
        return repository.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserResource> index() {
        return repository.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserResource post(UserResource resource) {
        return repository.create(resource);
    }
}
