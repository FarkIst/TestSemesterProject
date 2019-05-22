package rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Registers the components to be used by the JAX-RS application
 */
public class MyApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public MyApplication(){
        register(JacksonFeature.class);
        packages("rest.controllers");
    }
}