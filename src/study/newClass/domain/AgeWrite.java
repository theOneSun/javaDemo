package study.newClass.domain;

/**
 * @authur sunjian.
 */
public class AgeWrite
{
    private String id;
    private String businessId;
    private String index;
    private Double rate;

    public AgeWrite()
    {
    }

    public AgeWrite(String id, String businessId, String index, Double rate)
    {
        this.id = id;
        this.businessId = businessId;
        this.index = index;
        this.rate = rate;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getBusinessId()
    {
        return businessId;
    }

    public void setBusinessId(String businessId)
    {
        this.businessId = businessId;
    }

    public String getIndex()
    {
        return index;
    }

    public void setIndex(String index)
    {
        this.index = index;
    }

    public Double getRate()
    {
        return rate;
    }

    public void setRate(Double rate)
    {
        this.rate = rate;
    }

    @Override
    public String toString()
    {
        return "AgeWrite{" + "id='" + id + '\'' + ", businessId='" + businessId + '\'' + ", index='" + index + '\'' + ", rate=" + rate + '}';
    }
}
