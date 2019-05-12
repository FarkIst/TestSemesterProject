package rest;

import mappers.UserMapper;
import units.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users/")
public class UserController {

    UserMapper userMapper;

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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getUserInJSON(Integer id){
        User user = new User(id);
        user.setName("George");
        return user;
    }
}