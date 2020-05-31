package world.sake.exquakus.brewery.brand;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import world.sake.exquakus.doma.dao.BrandDao;
import world.sake.exquakus.doma.entity.Brand;

@Path("/breweries/{breweryId}/brands")
public class BrandController {

    private final BrandDao brandDao;

    public BrandController(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    // e.g. http://localhost:8081/breweries/1/brands
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brand> get(@PathParam Long breweryId) {
        return brandDao.selectByBreweryId(breweryId);
    }

    // e.g. http://localhost:8081/breweries/1/brands/2
    @GET
    @Path("/{brandId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Brand get(@PathParam Long breweryId, @PathParam Long brandId) {
        return brandDao.selectById(breweryId, brandId);
    }
}
