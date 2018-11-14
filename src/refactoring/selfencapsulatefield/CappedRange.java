package refactoring.selfencapsulatefield;

/**
 * @author sunjian.
 */
public class CappedRange extends IntRange
{
    private int cap;

    public CappedRange(int low, int high, int cap)
    {
        super(low,high);
        this.cap = cap;
    }

    public int getCap()
    {
        return cap;
    }

    public void setCap(int cap)
    {
        this.cap = cap;
    }

    @Override
    public int getHigh()
    {
        return Math.max(super.getHigh(),cap);
    }
}
