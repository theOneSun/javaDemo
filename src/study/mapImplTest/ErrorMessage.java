package study.mapImplTest;

/**
 * @authur sunjian.
 */
public enum ErrorMessage
{
    DATA_EMPTY("数据有空"),
    DATA_REPEAT("数据重复")
    ;
    private String message;

    ErrorMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
