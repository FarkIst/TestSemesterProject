package units;

import javax.persistence.Entity;

@Entity
public class Staff extends User{
    protected int staffNo;
    protected Boolean isCouncilMember;

    public int getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }

    public Boolean isCouncilMember() {
        return isCouncilMember;
    }

    public void setIsCouncilMember(Boolean isCouncilMember) {
        this.isCouncilMember = isCouncilMember;
    }
}
