package study.extendsTest;

/**
 * @author sunjian.
 */
public class ExtendsDemo
{
    public static void main(String[] args)
    {
        Animal dog = new Dog();
        print(dog);

    }

    public static void print(Animal animal){
        System.out.println(animal.get());
    }
}
