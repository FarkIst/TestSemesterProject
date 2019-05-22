package rest;

import mappers.CourseMapper;
import org.codehaus.jackson.map.ObjectMapper;
import units.Course;
import units.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;

@Path("/courses/")
public class CourseController {
    CourseMapper mapper = new CourseMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getUsers() {
        Collection<Course> entities = mapper.returnAllEntities();
        return Response.status(200).entity(entities).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response createUser(Course entity) {
        entity = mapper.createEntity(entity);
        return Response.status(200).entity(entity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id) throws IOException {
        Course entity = mapper.readEntity(id);
        ObjectMapper Obj = new ObjectMapper();
        String output = Obj.writeValueAsString(entity);

        return Response.status(200).entity(output).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response putUser(Course entity) {
        entity = mapper.editEntity(entity);
        return Response.status(200).entity(entity).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        mapper.deleteEntity(id);
        return Response.status(200).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/add-student/{studentId}")
    public Response addStudentToCourse(@PathParam("id") int id, @PathParam("studentId") int studentId) {
        Student entity = mapper.addStudentToCourse(id, studentId);
        return Response.status(200).entity(entity).build();
    }
}