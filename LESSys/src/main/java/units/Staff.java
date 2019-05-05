package units;

import javax.persistence.Entity;

@Entity
public class Staff extends User{
    private int staffNo;

    public int getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }
}
