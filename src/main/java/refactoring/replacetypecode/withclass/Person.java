package refactoring.replacetypecode.withclass;

import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class Person {

    private BloodGroup bloodGroup;

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Person(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
