package life.manufacturing;

import java.util.LinkedHashMap;

/**
 * @author sunjian.
 */
public class Calculator {
    public static void main(String[] args) {
        final Calculator calculator = new Calculator();

        //-----------init-----------------
        //两条工作线
        final TestLine line1 = new TestLine();
        final TestLine line2 = new TestLine();
        //三种零件
//        final LinkedHashMap<Integer, Integer> partAStation = new LinkedHashMap<>();
//        partAStation.put(5, 80);
//        partAStation.put(6, 40);
//        partAStation.put(7, 80);
//        final Part partA = new Part(partAStation, 10);
//
//        final LinkedHashMap<Integer, Integer> partBStation = new LinkedHashMap<>();
//        partBStation.put(3, 150);
//        partBStation.put(4, 125);
//        partBStation.put(5, 90);
//        partBStation.put(6, 50);
//        partBStation.put(7, 90);
//        final Part partB = new Part(partBStation, 10);
//
//        final LinkedHashMap<Integer, Integer> partCStation = new LinkedHashMap<>();
//        partCStation.put(1, 160);
//        partCStation.put(2, 130);
//        partCStation.put(3, 200);
//        partCStation.put(4, 145);
//        partCStation.put(5, 100);
//        partCStation.put(6, 60);
//        partCStation.put(7, 100);
//        final Part partC = new Part(partCStation, 16);

        //---------init end-------------------------
        final Part[] parts = calculator.initPart();



    }

    //初始化所有零件
    private Part[] initPart(){
        Part[] parts = new Part[36];

        int index = 0;

        for (int i = 0; i < 10; i++) {
            final LinkedHashMap<Integer, Integer> partAStation = new LinkedHashMap<>();
            partAStation.put(5, 80);
            partAStation.put(6, 40);
            partAStation.put(7, 80);
            final Part partA = new Part(partAStation, 10);
            parts[index] = partA;
            index++;
        }

        for (int i = 0; i < 10; i++) {
            final LinkedHashMap<Integer, Integer> partBStation = new LinkedHashMap<>();
            partBStation.put(3, 150);
            partBStation.put(4, 125);
            partBStation.put(5, 90);
            partBStation.put(6, 50);
            partBStation.put(7, 90);
            final Part partB = new Part(partBStation, 10);
            parts[index] = partB;
            index++;
        }
        for (int i = 0; i < 16; i++) {
            final LinkedHashMap<Integer, Integer> partCStation = new LinkedHashMap<>();
            partCStation.put(1, 160);
            partCStation.put(2, 130);
            partCStation.put(3, 200);
            partCStation.put(4, 145);
            partCStation.put(5, 100);
            partCStation.put(6, 60);
            partCStation.put(7, 100);
            final Part partC = new Part(partCStation, 16);
            parts[index] = partC;
            index++;
        }
        return parts;
    }

}
