package rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import rest.controllers.SimpleUserController;
import units.SimpleUser;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiTest extends JerseyTest {

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(SimpleUserController.class);
    }
    
    @Test
    public void testCreate() {
        String path = "/simple-users/";

        SimpleUser user =  new SimpleUser();
        Calendar birthdate = Calendar.getInstance();
        birthdate.set(1996,2,2);
        user.setBirthDate(birthdate);
        user.setName("John");

        final Response response = target(path).request().post(Entity.json(user));

        System.out.println(response.toString());

        assertEquals("should return status 200", 200, response.getStatus());
        assertEquals("Should return json", MediaType.APPLICATION_JSON_TYPE, response.getMediaType());
        assertEquals("Should return same entity id", user.getId(), response.readEntity(SimpleUser.class).getId());
    }
}