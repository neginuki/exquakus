package world.sake.exquakus.config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

// see src/main/resource/META-INF/microprofile-config.properties
@Path("/configs")
public class ConfigController {

    @ConfigProperty(name = "module.name")
    private String moduleName;

    @ConfigProperty(name = "module.alias")
    private String moduleAlias;

    @ConfigProperty(name = "undefined", defaultValue = "未定義のパラメータ名")
    private String undefined;

    @Inject
    private RemoteConfig remoteConfig;

    // e.g. http://localhost:8080/configs/module.alias
    @GET
    @Path("/{name}")
    public String get(@PathParam String name) {
        Config config = ConfigProvider.getConfig();
        String value = config.getValue(name, String.class);

        return value;
    }

    // e.g. http://localhost:8080/configs/name
    @GET
    @Path("/name")
    public String name() {
        return moduleName;
    }

    // e.g. http://localhost:8080/configs/alias
    @GET
    @Path("/alias")
    public String alias() {
        return moduleAlias;
    }

    // e.g. http://localhost:8080/configs/undefined
    @GET
    @Path("/undefined")
    public String undefined() {
        return undefined;
    }

    // e.g. http://localhost:8080/configs/remote
    @GET
    @Path("/remote")
    @Produces(MediaType.APPLICATION_JSON)
    public RemoteConfig remote() {
        return remoteConfig;
    }
}
