package world.sake.exquakus.brewery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    // e.g. http://localhost:8081/breweries/
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Brewery post(BreweryResource brewery) {
        Brewery entity = brewery.toEntity();
        entity.displayOrder = 1L;
        entity.statusCode = "OK";
        entity.versionNo = 0L;

        entity.registerTrace = "register";
        entity.registerDatetime = LocalDateTime.now();
        entity.updateTrace = "update";
        entity.updateDatetime = LocalDateTime.now();

        breweryDao.insert(entity);

        return breweryDao.selectById(entity.breweryId);
    }

    @DELETE
    @Path("/{breweryId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public BreweryResource delete(@PathParam Long breweryId) {
        Brewery entity = breweryDao.selectById(breweryId);

        breweryDao.delete(entity);

        return new BreweryResource(entity);
    }

    public static class BreweryResource {

        public String breweryName;

        public String breweryNameKana;

        public String address;

        public Integer foundedYear;

        public LocalDate establishedDate;

        public LocalDate defunctDate;

        public String url;

        public String note;

        public Long versionNo;

        public BreweryResource() {
        }

        public BreweryResource(Brewery entity) {
            breweryName = entity.breweryName;
            breweryNameKana = entity.breweryNameKana;
            address = entity.address;
            foundedYear = entity.foundedYear;
            establishedDate = entity.establishedDate;
            defunctDate = entity.defunctDate;
            url = entity.url;
            note = entity.note;
            versionNo = entity.versionNo;
        }

        public Brewery toEntity() {
            Brewery entity = new Brewery();
            entity.breweryName = breweryName;
            entity.breweryNameKana = breweryNameKana;
            entity.address = address;
            entity.foundedYear = foundedYear;
            entity.establishedDate = establishedDate;
            entity.defunctDate = defunctDate;
            entity.url = url;
            entity.note = note;
            entity.versionNo = versionNo;

            return entity;
        }

        @Override
        public String toString() {
            return "BreweryResource [breweryName=" + breweryName + ", breweryNameKana=" + breweryNameKana + ", address=" + address
                    + ", foundedYear=" + foundedYear + ", establishedDate=" + establishedDate + ", defunctDate=" + defunctDate + ", url="
                    + url + ", note=" + note + ", versionNo=" + versionNo + "]";
        }
    }
}
