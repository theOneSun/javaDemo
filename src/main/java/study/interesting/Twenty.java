package study.interesting;

/**
 * @author sunjian.
 */
public class Twenty
{
    public static void main(String[] args)
    {
        User a = new User("a");
        User b = new User("b");
        int target = 20;
    }

    public static void sayNumber(){

    }


    public static void sayNumberB(){

    }

    static class User{
        String name;

        public User(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }
    }
}
