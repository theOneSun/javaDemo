package refactoring.replacetypecode.withclass;

/**
 * @author sunjian.
 */
public class BloodGroup {
    public static final BloodGroup O = new BloodGroup(0);
    public static final BloodGroup A = new BloodGroup(1);
    public static final BloodGroup B = new BloodGroup(2);
    public static final BloodGroup AB = new BloodGroup(3);

    private static final BloodGroup[] values = {O, A, B, AB};

    private int code;

    private BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static BloodGroup code(int index) {
        return values[index];
    }

}
