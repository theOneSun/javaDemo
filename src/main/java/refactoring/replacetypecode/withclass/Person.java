package refactoring.replacetypecode.withclass;

/**
 * @author sunjian.
 */
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
