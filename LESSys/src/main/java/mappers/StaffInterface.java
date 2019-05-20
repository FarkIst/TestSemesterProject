package mappers;

import units.Staff;
import units.Subject;

public interface StaffInterface {
    public Staff addToSchoolCommittee(Staff staff);
    public Subject suggestSubject(Staff staff, Subject subject);
    public Subject voteSubject(Staff staff, Subject subject);
}
