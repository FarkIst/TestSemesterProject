package rest;

import mappers.ScheduleMapper;
import org.codehaus.jackson.map.ObjectMapper;
import units.Schedule;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;

@Path("/schedules/")
public class ScheduleController {
    ScheduleMapper mapper = new ScheduleMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getUsers() {
        Collection<Schedule> entities = mapper.returnAllEntities();
        return Response.status(200).entity(entities).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response createUser(Schedule entity) {
        entity = mapper.createEntity(entity);
        return Response.status(200).entity(entity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id) throws IOException {
        Schedule entity = mapper.readEntity(id);
        ObjectMapper Obj = new ObjectMapper();
        String output = Obj.writeValueAsString(entity);

        return Response.status(200).entity(output).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response putUser(Schedule entity) {
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
    @Path("/{id}/add-course/{courseId}")
    public Response addCourseToSchedule(@PathParam("id") int id, @PathParam("courseId") int courseId) {
        Schedule entity = mapper.addCoursetoSchedule(id, courseId);
        return Response.status(200).entity(entity).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/add-course/")
    public Response removeCourseFromSchedule(@PathParam("id") int id) {
        Schedule entity = mapper.removeCourseFromSchedule(id);
        return Response.status(200).entity(entity).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/add-course/{roomId}")
    public Response addRoomToSchedule(@PathParam("id") int id, @PathParam("roomId") int roomId) {
        Schedule entity = mapper.addRoomtoSchedule(id, roomId);
        return Response.status(200).entity(entity).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/add-course/")
    public Response removeRoomFromSchedule(@PathParam("id") int id) {
        Schedule entity = mapper.removeRoomFromSchedule(id);
        return Response.status(200).entity(entity).build();
    }
}