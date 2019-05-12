package mappers;

import units.Course;
import units.Room;
import units.Schedule;

public interface ScheduleInterface extends CRUDInterface<Schedule>{
    public Schedule addCoursetoSchedule(Schedule schedule, Course course);
    public Schedule removeCoursefromSchedule(Schedule schedule, Course course);
    public Schedule addRoomtoSchedule(Schedule schedule, Room room);
    public Schedule removeRoomfromSchedule(Schedule schedule, Room room);
}
