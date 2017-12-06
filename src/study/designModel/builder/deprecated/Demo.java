package study.designModel.builder.deprecated;

/**
 * Created by sunjian on 2017/6/1.
 */
public class Demo
{
    public static void main(String[] args){
        ComputerBuilder computerBuilder = new DellComputerBuilder();
        Director director = new Director(computerBuilder);

        director.construct();

        Computer computer = computerBuilder.retrieveComputer();
        System.out.println(computer);
    }
}
