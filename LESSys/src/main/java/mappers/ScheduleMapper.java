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

    public Schedule addCoursetoSchedule(Schedule schedule, Course course) {
        return null;
    }

    public Schedule removeCoursefromSchedule(Schedule schedule, Course course) {
        return null;
    }

    public Schedule addRoomtoSchedule(Schedule schedule, Room room) {
        return null;
    }

    public Schedule removeRoomfromSchedule(Schedule schedule, Room room) {
        return null;
    }
}
