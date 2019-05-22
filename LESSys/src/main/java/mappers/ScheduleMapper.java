package mappers;

import units.Course;
import units.Room;
import units.Schedule;

public class ScheduleMapper extends GenericMapper<Schedule> implements ScheduleInterface {
    public ScheduleMapper() {
        super(Schedule.class);
    }

    public ScheduleMapper(String PU) {
        super(PU, Schedule.class);
    }

    public Schedule addCoursetoSchedule(int id, int courseId) {
        Schedule schedule = this.em.find(Schedule.class, id);
        Course course = this.em.find(Course.class, courseId);
        schedule.setCourse(course);
        em.getTransaction().begin();
        em.merge(schedule);
        em.getTransaction().commit();
        return schedule;
    }

    public Schedule removeCourseFromSchedule(int id) {
        Schedule schedule = this.em.find(Schedule.class, id);
        schedule.setCourse(null);
        em.getTransaction().begin();
        em.merge(schedule);
        em.getTransaction().commit();
        return schedule;
    }

    public Schedule addRoomToSchedule(int id, int roomId) {
        Schedule schedule = this.em.find(Schedule.class, id);
        Room room = this.em.find(Room.class, roomId);
        schedule.setRoom(room);
        em.getTransaction().begin();
        em.merge(schedule);
        em.getTransaction().commit();
        return schedule;
    }

    public Schedule removeRoomFromSchedule(int id) {
        Schedule schedule = this.em.find(Schedule.class, id);
        schedule.setRoom(null);
        em.getTransaction().begin();
        em.merge(schedule);
        em.getTransaction().commit();
        return schedule;
    }
}
