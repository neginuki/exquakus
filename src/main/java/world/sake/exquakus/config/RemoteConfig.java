package world.sake.exquakus.config;

import javax.validation.constraints.Max;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "remote")
public class RemoteConfig {

    public S3 s3;

    public Api api;

    public static class S3 {
        public String url;

        public String accesskey;

        public String secretkey;
    }

    public static class Api {

        @Max(999)
        public long timeout;

        public String log;
    }
}