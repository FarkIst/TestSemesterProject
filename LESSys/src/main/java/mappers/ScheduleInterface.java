package mappers;

import units.Schedule;

public interface ScheduleInterface extends CRUDInterface<Schedule> {
    public Schedule addCoursetoSchedule(int id, int courseId);

    public Schedule removeCourseFromSchedule(int id);

    public Schedule addRoomToSchedule(int id, int roomId);

    public Schedule removeRoomFromSchedule(int id);
}
