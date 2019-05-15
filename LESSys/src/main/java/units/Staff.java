package units;

import javax.persistence.Entity;

@Entity
public class Staff extends User{
    protected int staffNo;
    protected Boolean councilMember;

    public int getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }

    public Boolean getCouncilMember() {
        return councilMember;
    }

    public void setCouncilMember(Boolean councilMember) {
        this.councilMember = councilMember;
    }
}
