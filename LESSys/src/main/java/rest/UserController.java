package rest;

import gherkin.deps.com.google.gson.Gson;
import mappers.UserMapper;
import org.codehaus.jackson.map.ObjectMapper;
import units.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/users/")
public class UserController {

    UserMapper userMapper = new UserMapper();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/hello/{name}")
    public Response getMsg(@PathParam("name") String name) {

        String output = "Hello   : " + name;

        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<User> getUsersInJSON(){
        List<User> users = userMapper.returnAllEntities();
        return users;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getUserInJSON(@PathParam("id") int id) throws IOException {
        User user = new User(33);
        user.setName("George");
        User userOut = userMapper.createEntity(user);
        ObjectMapper Obj = new ObjectMapper();
        String output = Obj.writeValueAsString(userOut);

        return Response.status(200).entity(output).build();
    }
}