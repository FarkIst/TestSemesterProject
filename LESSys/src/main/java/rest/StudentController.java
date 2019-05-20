package rest;

import mappers.StudentMapper;
import org.codehaus.jackson.map.ObjectMapper;
import units.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;

@Path("/students/")
public class StudentController {
    StudentMapper mapper = new StudentMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getUsersInJSON() {
        Collection<Student> entities = mapper.returnAllEntities();
        return Response.status(200).entity(entities).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response createUserInJSON(Student entity) {
        entity = mapper.createEntity(entity);
        return Response.status(200).entity(entity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getUserInJSON(@PathParam("id") int id) throws IOException {
        Student entity = mapper.readEntity(id);
        ObjectMapper Obj = new ObjectMapper();
        String output = Obj.writeValueAsString(entity);

        return Response.status(200).entity(output).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response putUserInJSON(Student entity) {
        entity = mapper.editEntity(entity);
        return Response.status(200).entity(entity).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteUserInJSON(@PathParam("id") int id) {
        mapper.deleteEntity(id);
        return Response.status(200).build();
    }
}