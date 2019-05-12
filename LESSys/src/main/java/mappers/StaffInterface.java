package mappers;

import units.Staff;

public interface StaffInterface extends CRUDInterface<Staff> {
    public Staff addToSchoolCommittee(Staff staff);
}
