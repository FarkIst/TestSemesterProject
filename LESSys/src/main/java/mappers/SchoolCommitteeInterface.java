package mappers;

import units.Staff;
import units.Subject;

public interface SchoolCommitteeInterface extends CRUDInterface<Staff>{
    public Subject suggestSubject(Staff staff, Subject subject);
    public Subject voteSubject(Staff staff, Subject subject);
}
