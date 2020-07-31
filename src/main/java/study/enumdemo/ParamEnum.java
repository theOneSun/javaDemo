package study.enumdemo;

/**
 * @author sunjian.
 */
public enum ParamEnum implements Talk
{
    /**
     * 服务水平
     */
    SERVICE_LEVEL{
        @Override
        public void talk() {
            System.out.println(1);
        }
    },
    /**
     * 服务礼仪
     */
    SERVICE_ETIQUETTE{
        @Override
        public void talk() {
            System.out.println(1);
        }
    },
    /**
     * 沟通技巧
     */
    COMMUNICATION_SKILL{
        @Override
        public void talk() {
            System.out.println(1);
        }
    },
    /**
     * 问题回应
     */
    QUESTION_RESPONSE{
        @Override
        public void talk() {
            System.out.println(1);
        }
    },;

    public void print(){
        System.out.println(this.name());
    }

}
