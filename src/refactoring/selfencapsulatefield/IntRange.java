package refactoring.selfencapsulatefield;

/**
 * @author sunjian.
 */
public class IntRange
{
    private int low;
    private int high;

    public IntRange(int low, int high)
    {
        /*this.low = low;
        this.high = high;*/
        initialize(low,high);
    }
    private void initialize(int low, int high){
        this.low = low;
        this.high = high;
    }

    public int getLow()
    {
        return low;
    }

    public void setLow(int low)
    {
        this.low = low;
    }

    public int getHigh()
    {
        return high;
    }

    public void setHigh(int high)
    {
        this.high = high;
    }
}
