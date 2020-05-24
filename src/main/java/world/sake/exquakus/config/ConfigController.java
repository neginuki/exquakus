package world.sake.exquakus.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/configs")
public class ConfigController {

    @ConfigProperty(name = "module.name")
    private String moduleName;

    @ConfigProperty(name = "module.alias")
    private String moduleAlias;

    // e.g. http://localhost:8081/configs/module.alias
    @GET
    @Path("/{name}")
    public String get(@PathParam String name) {
        Config config = ConfigProvider.getConfig();
        String value = config.getValue(name, String.class);

        return value;
    }

    // e.g. http://localhost:8081/configs/name
    @GET
    @Path("/name")
    public String name() {
        return moduleName;
    }

    // e.g. http://localhost:8081/configs/alias
    @GET
    @Path("/alias")
    public String alias() {
        return moduleAlias;
    }
}
