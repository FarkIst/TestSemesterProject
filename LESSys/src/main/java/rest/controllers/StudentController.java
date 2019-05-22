package rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mappers.StudentMapper;
import units.Course;
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
    public Response getUsers() {
        Collection<Student> entities = mapper.returnAllEntities();
        return Response.status(200).entity(entities).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response createUser(Student entity) {
        entity = mapper.createEntity(entity);
        return Response.status(200).entity(entity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id) throws IOException {
        Student entity = mapper.readEntity(id);
        ObjectMapper Obj = new ObjectMapper();
        String output = Obj.writeValueAsString(entity);

        return Response.status(200).entity(output).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response putUser(Student entity) {
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
    @Path("/{id}/register-course/{courseId}")
    public Response registerCourse(@PathParam("id") int id, @PathParam("courseId") int courseId) {
        Course entity = mapper.registerCourse(id, courseId);
        return Response.status(200).entity(entity).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/leave-course/{courseId}")
    public Response leaveCourse(@PathParam("id") int id, @PathParam("courseId") int courseId) {
        mapper.leaveCourse(id, courseId);
        return Response.status(200).build();
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/{id}/register-course/{courseId}")
//    public Response makePayment(@PathParam("id") int id, @PathParam("courseId") int courseId, JSONObject request) {
//        double amount = Double.parseDouble(request.optString("amount"));
//        Student entity = mapper.makePayment(id, courseId, amount);
//        return Response.status(200).entity(entity).build();
//    }
}