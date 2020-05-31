package world.sake.exquakus.brewery;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import world.sake.exquakus.doma.dao.BreweryDao;
import world.sake.exquakus.doma.entity.Brewery;

@Path("/breweries")
public class BreweryController {

    private final BreweryDao breweryDao;

    public BreweryController(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    // e.g. http://localhost:8081/breweries/
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brewery> get() {
        return breweryDao.selectList();
    }

    // e.g. http://localhost:8081/breweries/1
    @GET
    @Path("/{breweryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Brewery get(@PathParam Long breweryId) {
        return breweryDao.selectById(breweryId);
    }
}
